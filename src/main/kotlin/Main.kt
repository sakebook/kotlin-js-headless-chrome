import fs.`T$50`
import kotlinx.coroutines.*
import kotlinx.serialization.json.JsonObject
import kotlin.js.JSON.stringify

private val scope = CoroutineScope(Dispatchers.Default)
private const val FILE_NAME = "capture.png"
private const val URL = "https://slack.com/api/files.upload"
private val slackConfig = SlackConfig()

fun main(args: Array<String>) {
    val url = parseUrl(args) ?: throw IllegalArgumentException("URL is not found.")
    scope.launch {
        capture(url)
        postToSlack(FILE_NAME)
    }
}

fun parseUrl(args: Array<String>): String? {
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

suspend fun postToSlack(fileName: String) {
    val form = createFormData(fileName)
    val axios = Axios.create(object : AxiosRequestConfig {
        override var method: String? = "POST"
        override var responseType: String? = "json"
        override var headers: Any? = kotlin.js.json(
            "Authorization" to "Bearer ${slackConfig.token}",
            "content-type" to "multipart/form-data;boundary=" + form.getBoundary(),
        )
    })

    val result = axios.post<JsonObject>(url = URL, data = form).await()
    println(stringify(result, replacer = {key: String, value: Any? -> if (key == "_httpMessage" || key == "req" || key == "_currentRequest") null else value }))
}

private fun createFormData(fileName: String): FormData {
    val form = FormData()
    val file = fs.createReadStream(path = fileName, options = object : `T$50`{})
    form.append("file", file)
    form.append("channels", slackConfig.channel)
    return form
}
