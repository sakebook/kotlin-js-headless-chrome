
import kotlin.js.Promise

external interface BrowserType<Browser> {
    fun connect(options: BrowserTypeConnectOptions): Promise<Browser>
    fun launch(options: LaunchOptions = definedExternally): Promise<Browser>
}

external interface LaunchOptions {
    var headless: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var executablePath: String?
        get() = definedExternally
        set(value) = definedExternally
    var args: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreDefaultArgs: dynamic /* Boolean? | Array<String>? */
        get() = definedExternally
        set(value) = definedExternally
//    var proxy: BrowserTypeLaunchOptionsProxy?
//        get() = definedExternally
//        set(value) = definedExternally
    var downloadsPath: String?
        get() = definedExternally
        set(value) = definedExternally
    var chromiumSandbox: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var firefoxUserPrefs: Any?
        get() = definedExternally
        set(value) = definedExternally
    var handleSIGINT: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var handleSIGTERM: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var handleSIGHUP: Boolean?
        get() = definedExternally
        set(value) = definedExternally
//    var logger: Logger?
//        get() = definedExternally
//        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
//    var env: `T$12`?
//        get() = definedExternally
//        set(value) = definedExternally
    var devtools: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var slowMo: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Worker {
    fun <R, Arg> evaluate(pageFunction: String, arg: Arg): Promise<R>
//    fun <R, Arg> evaluate(pageFunction: (arg: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<R>
    fun <R> evaluate(pageFunction: String, arg: Any = definedExternally): Promise<R>
//    fun <R> evaluate(pageFunction: (arg: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<R>
//    fun <R, Arg> evaluateHandle(pageFunction: String, arg: Arg): Promise<SmartHandle<R>>
//    fun <R, Arg> evaluateHandle(pageFunction: (arg: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<SmartHandle<R>>
//    fun <R> evaluateHandle(pageFunction: String, arg: Any = definedExternally): Promise<SmartHandle<R>>
//    fun <R> evaluateHandle(pageFunction: (arg: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<SmartHandle<R>>
    fun on(event: String /* 'close' */, listener: (worker: Worker) -> Unit): Worker /* this */
    fun once(event: String /* 'close' */, listener: (worker: Worker) -> Unit): Worker /* this */
    fun addListener(event: String /* 'close' */, listener: (worker: Worker) -> Unit): Worker /* this */
    fun removeListener(event: String /* 'close' */, listener: (worker: Worker) -> Unit): Worker /* this */
    fun off(event: String /* 'close' */, listener: (worker: Worker) -> Unit): Worker /* this */
    fun url(): String
}

external interface BrowserNewPageOptions {
    var acceptDownloads: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreHTTPSErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var bypassCSP: Boolean?
        get() = definedExternally
        set(value) = definedExternally
//    var viewport: BrowserNewPageOptionsViewport?
//        get() = definedExternally
//        set(value) = definedExternally
    var userAgent: String?
        get() = definedExternally
        set(value) = definedExternally
    var deviceScaleFactor: Number?
        get() = definedExternally
        set(value) = definedExternally
    var isMobile: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var hasTouch: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var javaScriptEnabled: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timezoneId: String?
        get() = definedExternally
        set(value) = definedExternally
//    var geolocation: BrowserNewPageOptionsGeolocation?
//        get() = definedExternally
//        set(value) = definedExternally
    var locale: String?
        get() = definedExternally
        set(value) = definedExternally
    var permissions: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
//    var extraHTTPHeaders: `T$0`?
//        get() = definedExternally
//        set(value) = definedExternally
    var offline: Boolean?
        get() = definedExternally
        set(value) = definedExternally
//    var httpCredentials: BrowserNewPageOptionsHttpCredentials?
//        get() = definedExternally
//        set(value) = definedExternally
    var colorScheme: String? /* "light" | "dark" | "no-preference" */
        get() = definedExternally
        set(value) = definedExternally
//    var logger: Logger?
//        get() = definedExternally
//        set(value) = definedExternally
}

external interface Route {
    fun abort(errorCode: String = definedExternally): Promise<Unit>
//    fun `continue`(overrides: RouteContinueOverrides = definedExternally): Promise<Unit>
//    fun fulfill(response: RouteFulfillResponse): Promise<Unit>
//    fun request(): Request
}

@JsModule("playwright")
@JsNonModule
@JsName("playwright")
external object Playwright {
    val chromium: BrowserType<ChromiumBrowser>
}
