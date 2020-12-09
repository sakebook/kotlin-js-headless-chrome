import fs.`T$50`
import kotlinx.coroutines.*
import kotlin.js.JSON.stringify
import kotlin.js.Promise
import kotlin.properties.Delegates


private const val FILE_NAME = "capture.png"
private const val URL = "https://slack.com/api/files.upload"
private val scope = CoroutineScope(Dispatchers.Default)

var slackConfig: SlackConfig by Delegates.notNull<SlackConfig>()

private fun createSlackConfig() {
    kotlin.js.console.log("createSlackConfig")
    val projectId = js("process.env.PROJECT_ID")?.unsafeCast<String>() ?: throw IllegalArgumentException("project id is not found.")
    val slackChannelKey = js("process.env.SLACK_CHANNEL_KEY")?.unsafeCast<String>() ?: throw IllegalArgumentException("channel key is not found.")
    val slackTokenKey = js("process.env.SLACK_TOKEN_KEY")?.unsafeCast<String>() ?: throw IllegalArgumentException("token key is not found.")
    val client = SecretManager.SecretManagerServiceClient()
    val secretChannel = client.accessSecretVersion(
        kotlin.js.json(
            "name" to "projects/${projectId}/secrets/${slackChannelKey}/versions/latest"
        )
    )
    val secretToken = client.accessSecretVersion(
        kotlin.js.json(
            "name" to "projects/${projectId}/secrets/${slackTokenKey}/versions/latest"
        )
    )
    val awaits = arrayOf(secretToken, secretChannel)
    Promise.all(awaits)
        .then { res ->
            kotlin.js.console.log("SlackConfig created maybe success")
            slackConfig = SlackConfig(token = res[0].value(), channel = res[1].value())
//            kotlin.js.console.log("slackConfig: ${JSON.stringify(slackConfig)}")
        }.catch { throw it }
}

@JsName("exports")
private external object Exports {
    var capture: dynamic
    var afterTimeout: dynamic
}

fun main() {
    createSlackConfig()
    // for local
//    capture(object{} as Request,  object{} as Response)
    Exports.capture = ::capture
    Exports.afterTimeout = ::timeout
}

fun timeout(req: Request, res: Response) {
    setTimeout({
        console.log("Function running...");
        res.end()
    }, 600000)
}

fun capture(req: Request, res: Response) {
    val url = parseUrl(req) ?: throw IllegalArgumentException("URL is not found.")
    scope.promise {
        val tmpDir = Os.tmpdir()
        kotlin.js.console.log("tmpDir is $tmpDir")
        val capturing = async { capturePage(url, tmpDir) }
        capturing.await()
        kotlin.js.console.log("capture success")
        postToSlack("$tmpDir/$FILE_NAME")
    }.then {
        kotlin.js.console.log("top then")
        res.send("success").status(200)
    }.catch {
        kotlin.js.console.log("top catch")
        kotlin.js.console.log(it.message)
        kotlin.js.console.log(stringify(it.message))
        kotlin.js.console.log(stringify(it))
        res.send("error").status(500)
    }
}

fun parseUrl(req: Request): String? {
    // TODO:
    return "http://whatsmyuseragent.org/"
}

suspend fun capturePage(url: String, tmpDir: String) = coroutineScope {
    kotlin.js.console.log("capturePage start")
    val browser = Puppeteer.launch(options = object : LaunchOptions {
        override var args: Array<String>? = arrayOf("--no-sandbox", "--disable-setuid-sandbox", "--single-process")
    }).await()
    val page = browser.newPage().await()
    page.goto(url).await()
    page.waitForTimeout(5000).await()
    page.screenshot(object : PageScreenshotOptions {
        override var path: String? = "${tmpDir}/$FILE_NAME"
        override var fullPage: Boolean? = true
    }).await()
    page.close().await()
    browser.close().await()
}

fun postToSlack(fileName: String): Promise<SlackResponse> {
    kotlin.js.console.log("postToSlack start")
    val form = createFormData(fileName)
    val axios = Axios.create(object : AxiosRequestConfig {
        override var method: String? = "POST"
        override var responseType: String? = "json"
        override var headers: Any? = kotlin.js.json(
            "Authorization" to "Bearer ${slackConfig.token}",
            "content-type" to "multipart/form-data;boundary=" + form.getBoundary(),
        )
    })
    return axios.post<SlackResponse>(url = URL, data = form)
}

private fun createFormData(fileName: String): FormData {
    val form = FormData()
    val file = fs.createReadStream(path = fileName, options = object : `T$50` {})
    form.append("file", file)
    form.append("channels", slackConfig.channel)
    return form
}
