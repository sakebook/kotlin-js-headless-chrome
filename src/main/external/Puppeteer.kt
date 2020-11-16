import kotlin.js.Promise

@JsModule("puppeteer")
@JsNonModule
@JsName("puppeteer")
external object Puppeteer {
    fun launch(options: LaunchOptions = definedExternally): Promise<Browser>
}
external interface LaunchOptions {
    var args: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Browser {
    fun newPage(): Promise<Page>
    fun close(): Promise<Unit>
}

external interface Page {
    fun close(): Promise<Unit>
    fun goto(url: String): Promise<Any>
    fun screenshot(options: PageScreenshotOptions = definedExternally): Promise<Any>
    fun waitForTimeout(timeout: Number): Promise<Unit>
}

external interface PageScreenshotOptions {
    var path: String?
        get() = definedExternally
        set(value) = definedExternally
    var fullPage: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}
