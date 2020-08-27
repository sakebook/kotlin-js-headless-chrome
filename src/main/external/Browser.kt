import org.w3c.dom.url.URL
import kotlin.js.Promise
import kotlin.js.RegExp

external interface Browser {
    fun on(event: String /* 'disconnected' */, listener: () -> Unit): Browser /* this */
    fun once(event: String /* 'disconnected' */, listener: () -> Unit): Browser /* this */
    fun addListener(event: String /* 'disconnected' */, listener: () -> Unit): Browser /* this */
    fun removeListener(event: String /* 'disconnected' */, listener: () -> Unit): Browser /* this */
    fun off(event: String /* 'disconnected' */, listener: () -> Unit): Browser /* this */
    fun close(): Promise<Unit>
    fun contexts(): Array<BrowserContext>
    fun isConnected(): Boolean
    fun newContext(options: BrowserContextOptions = definedExternally): Promise<BrowserContext>
    fun newPage(options: BrowserNewPageOptions = definedExternally): Promise<Page>
    fun version(): String
}

external interface BrowserContext {
    fun on(event: String /* 'close' */, listener: () -> Unit): BrowserContext /* this */
    fun on(event: String /* 'page' */, listener: (page: Page) -> Unit): BrowserContext /* this */
    fun once(event: String /* 'close' */, listener: () -> Unit): BrowserContext /* this */
    fun once(event: String /* 'page' */, listener: (page: Page) -> Unit): BrowserContext /* this */
    fun addListener(event: String /* 'close' */, listener: () -> Unit): BrowserContext /* this */
    fun addListener(event: String /* 'page' */, listener: (page: Page) -> Unit): BrowserContext /* this */
    fun removeListener(event: String /* 'close' */, listener: () -> Unit): BrowserContext /* this */
    fun removeListener(event: String /* 'page' */, listener: (page: Page) -> Unit): BrowserContext /* this */
    fun off(event: String /* 'close' */, listener: () -> Unit): BrowserContext /* this */
    fun off(event: String /* 'page' */, listener: (page: Page) -> Unit): BrowserContext /* this */
    //    fun addCookies(cookies: Array<BrowserContextAddCookiesCookies>): Promise<Unit>
//    fun addInitScript(script: Function<*>, arg: Serializable = definedExternally): Promise<Unit>
//    fun addInitScript(script: String, arg: Serializable = definedExternally): Promise<Unit>
//    fun addInitScript(script: BrowserContextAddInitScriptScript, arg: Serializable = definedExternally): Promise<Unit>
    fun clearCookies(): Promise<Unit>
    fun clearPermissions(): Promise<Unit>
    fun close(): Promise<Unit>
    //    fun cookies(urls: String = definedExternally): Promise<Array<Cookie>>
//    fun cookies(urls: Array<String> = definedExternally): Promise<Array<Cookie>>
//    fun exposeBinding(name: String, playwrightBinding: Function<*>): Promise<Unit>
//    fun exposeFunction(name: String, playwrightFunction: Function<*>): Promise<Unit>
//    fun grantPermissions(permissions: Array<String>, options: BrowserContextGrantPermissionsOptions = definedExternally): Promise<Unit>
    fun newPage(): Promise<Page>
    fun pages(): Array<Page>
    fun route(url: String, handler: (arg0: Route, arg1: Request) -> Unit): Promise<Unit>
    fun route(url: RegExp, handler: (arg0: Route, arg1: Request) -> Unit): Promise<Unit>
    fun route(url: (arg0: URL) -> Boolean, handler: (arg0: Route, arg1: Request) -> Unit): Promise<Unit>
    fun setDefaultNavigationTimeout(timeout: Number)
    fun setDefaultTimeout(timeout: Number)
    //    fun setExtraHTTPHeaders(headers: `T$0`): Promise<Unit>
//    fun setGeolocation(geolocation: BrowserContextSetGeolocationGeolocation?): Promise<Unit>
//    fun setHTTPCredentials(httpCredentials: BrowserContextSetHTTPCredentialsHttpCredentials?): Promise<Unit>
    fun setOffline(offline: Boolean): Promise<Unit>
    fun unroute(url: String, handler: (arg0: Route, arg1: Request) -> Unit = definedExternally): Promise<Unit>
    fun unroute(url: RegExp, handler: (arg0: Route, arg1: Request) -> Unit = definedExternally): Promise<Unit>
    fun unroute(
        url: (arg0: URL) -> Boolean,
        handler: (arg0: Route, arg1: Request) -> Unit = definedExternally
    ): Promise<Unit>
//    fun waitForEvent(event: String /* 'close' */, optionsOrPredicate: `T$1` = definedExternally): Promise<Unit>
//    fun waitForEvent(event: String /* 'page' */, optionsOrPredicate: `T$8` = definedExternally): Promise<Page>
}

external interface BrowserTypeConnectOptions {
    var wsEndpoint: String
    var slowMo: Number?
        get() = definedExternally
        set(value) = definedExternally
    //    var logger: Logger?
//        get() = definedExternally
//        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface BrowserContextOptions {
    var acceptDownloads: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreHTTPSErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var bypassCSP: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    //    var viewport: ViewportSize?
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
    //    var geolocation: Geolocation?
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
    //    var httpCredentials: HTTPCredentials?
//        get() = definedExternally
//        set(value) = definedExternally
    var colorScheme: String? /* "light" | "dark" | "no-preference" */
        get() = definedExternally
        set(value) = definedExternally
//    var logger: Logger?
//        get() = definedExternally
//        set(value) = definedExternally
}
