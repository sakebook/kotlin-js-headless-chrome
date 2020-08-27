import kotlin.js.Promise

external interface ChromiumBrowser : Browser {
    override fun contexts(): Array<BrowserContext>
    override fun newContext(options: BrowserContextOptions): Promise<ChromiumBrowserContext>
//    fun newBrowserCDPSession(): Promise<CDPSession>
//    fun startTracing(page: Page = definedExternally, options: ChromiumBrowserStartTracingOptions = definedExternally): Promise<Unit>
//    fun stopTracing(): Promise<Buffer>
}

external interface ChromiumBrowserContext : BrowserContext {
    override fun on(event: String /* 'backgroundpage' | 'page' */, listener: (page: Page) -> Unit): ChromiumBrowserContext /* this */
    fun on(event: String /* 'serviceworker' */, listener: (worker: Worker) -> Unit): ChromiumBrowserContext /* this */
    override fun on(event: String /* 'close' */, listener: () -> Unit): ChromiumBrowserContext /* this */
    override fun once(event: String /* 'backgroundpage' | 'page' */, listener: (page: Page) -> Unit): ChromiumBrowserContext /* this */
    fun once(event: String /* 'serviceworker' */, listener: (worker: Worker) -> Unit): ChromiumBrowserContext /* this */
    override fun once(event: String /* 'close' */, listener: () -> Unit): ChromiumBrowserContext /* this */
    override fun addListener(
        event: String /* 'backgroundpage' | 'page' */,
        listener: (page: Page) -> Unit
    ): ChromiumBrowserContext /* this */
    fun addListener(event: String /* 'serviceworker' */, listener: (worker: Worker) -> Unit): ChromiumBrowserContext /* this */
    override fun addListener(event: String /* 'close' */, listener: () -> Unit): ChromiumBrowserContext /* this */
    override fun removeListener(
        event: String /* 'backgroundpage' | 'page' */,
        listener: (page: Page) -> Unit
    ): ChromiumBrowserContext /* this */
    fun removeListener(event: String /* 'serviceworker' */, listener: (worker: Worker) -> Unit): ChromiumBrowserContext /* this */
    override fun removeListener(event: String /* 'close' */, listener: () -> Unit): ChromiumBrowserContext /* this */
    override fun off(event: String /* 'backgroundpage' | 'page' */, listener: (page: Page) -> Unit): ChromiumBrowserContext /* this */
    fun off(event: String /* 'serviceworker' */, listener: (worker: Worker) -> Unit): ChromiumBrowserContext /* this */
    override fun off(event: String /* 'close' */, listener: () -> Unit): ChromiumBrowserContext /* this */
    fun backgroundPages(): Array<Page>
//    fun newCDPSession(page: Page): Promise<CDPSession>
    fun serviceWorkers(): Array<Worker>
//    override fun waitForEvent(event: String /* 'backgroundpage' | 'page' */, optionsOrPredicate: `T$8`): Promise<Page>
//    fun waitForEvent(event: String /* 'serviceworker' */, optionsOrPredicate: `T$11` = definedExternally): Promise<Worker>
//    override fun waitForEvent(event: String /* 'close' */, optionsOrPredicate: `T$1`): Promise<Unit>
}
