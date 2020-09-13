import fs.`T$50`
import kotlinx.coroutines.*
import kotlin.js.JSON.stringify


private const val FILE_NAME = "capture.png"
private const val URL = "https://slack.com/api/files.upload"
private val scope = CoroutineScope(Dispatchers.Default)

private val slackConfig = SlackConfig()

@JsName("exports")
private external object Exports {
    var capture: dynamic
}

fun main() {
    Exports.capture = ::function
}

fun function(req: Request, res: Response) {
    val url = parseUrl(req) ?: throw IllegalArgumentException("URL is not found.")
    scope.launch(CoroutineExceptionHandler { _, throwable ->
        res.send(throwable.message ?: "").status(500)
    }) {
        capture(url)
        val response = postToSlack(FILE_NAME)
        when (response.data.ok) {
            true -> res.send("success").status(200)
            false -> res.send("error").status(400)
        }
    }
}

fun parseUrl(req: Request): String? {
    // TODO:
    return "http://whatsmyuseragent.org/"
}

suspend fun capture(url: String) {
    val browser = Playwright.chromium.launch().await()
    val context = browser.newContext().await()
    val page = context.newPage().await()
    page.goto(url).await()
    page.waitForTimeout(3000).await()
    page.screenshot(object : PageScreenshotOptions {
        override var path: String? = FILE_NAME
        override var fullPage: Boolean? = true
    }).await()
    page.close().await()
    context.close().await()
    browser.close().await()
}

suspend fun postToSlack(fileName: String): SlackResponse {
    val form = createFormData(fileName)
    val axios = Axios.create(object : AxiosRequestConfig {
        override var method: String? = "POST"
        override var responseType: String? = "json"
        override var headers: Any? = kotlin.js.json(
            "Authorization" to "Bearer ${slackConfig.token}",
            "content-type" to "multipart/form-data;boundary=" + form.getBoundary(),
        )
    })
    val response = axios.post<SlackResponse>(url = URL, data = form).await()
    console.log(stringify(response, replacer = {key: String, value: Any? -> if (key == "_httpMessage" || key == "req" || key == "_currentRequest") null else value }))
    return response
}

private fun createFormData(fileName: String): FormData {
    val form = FormData()
    val file = fs.createReadStream(path = fileName, options = object : `T$50` {})
    form.append("file", file)
    form.append("channels", slackConfig.channel)
    return form
}
