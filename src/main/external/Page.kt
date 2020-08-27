import org.w3c.dom.url.URL
import kotlin.js.Promise
import kotlin.js.RegExp

external interface Page {
    fun <R, Arg> evaluate(pageFunction: String, arg: Arg): Promise<R>
//    fun <R, Arg> evaluate(pageFunction: (arg: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<R>
    fun <R> evaluate(pageFunction: String, arg: Any = definedExternally): Promise<R>
//    fun <R> evaluate(pageFunction: (arg: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<R>
//    fun <R, Arg> evaluateHandle(pageFunction: String, arg: Arg): Promise<SmartHandle<R>>
//    fun <R, Arg> evaluateHandle(pageFunction: (arg: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<SmartHandle<R>>
//    fun <R> evaluateHandle(pageFunction: String, arg: Any = definedExternally): Promise<SmartHandle<R>>
//    fun <R> evaluateHandle(pageFunction: (arg: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<SmartHandle<R>>
//    fun <K : Any> `$`(selector: K): Promise<ElementHandleForTag<K>?>
//    fun `$`(selector: String): Promise<HTMLOrSVGElementHandle?>
//    fun <K : Any> `$$`(selector: K): Promise<Array<ElementHandleForTag<K>>>
//    fun `$$`(selector: String): Promise<Array<HTMLOrSVGElementHandle>>
    fun <K : Any, R, Arg> `$eval`(selector: K, pageFunction: String, arg: Arg): Promise<R>
//    fun <K : Any, R, Arg> `$eval`(selector: K, pageFunction: (on: Any, arg2: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<R>
    fun <R, Arg> `$eval`(selector: String, pageFunction: String, arg: Arg): Promise<R>
//    fun <R, Arg, E> `$eval`(selector: String, pageFunction: (on: E, arg2: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<R>
    fun <K : Any, R> `$eval`(selector: K, pageFunction: String, arg: Any = definedExternally): Promise<R>
//    fun <K : Any, R> `$eval`(selector: K, pageFunction: (on: Any, arg2: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<R>
    fun <R> `$eval`(selector: String, pageFunction: String, arg: Any = definedExternally): Promise<R>
//    fun <R, E> `$eval`(selector: String, pageFunction: (on: E, arg2: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<R>
    fun <K : Any, R, Arg> `$$eval`(selector: K, pageFunction: String, arg: Arg): Promise<R>
//    fun <K : Any, R, Arg> `$$eval`(selector: K, pageFunction: (on: Array<Any>, arg2: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<R>
    fun <R, Arg> `$$eval`(selector: String, pageFunction: String, arg: Arg): Promise<R>
//    fun <R, Arg, E> `$$eval`(selector: String, pageFunction: (on: Array<E>, arg2: Unboxed<Arg>) -> dynamic, arg: Arg): Promise<R>
    fun <K : Any, R> `$$eval`(selector: K, pageFunction: String, arg: Any = definedExternally): Promise<R>
//    fun <K : Any, R> `$$eval`(selector: K, pageFunction: (on: Array<Any>, arg2: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<R>
    fun <R> `$$eval`(selector: String, pageFunction: String, arg: Any = definedExternally): Promise<R>
//    fun <R, E> `$$eval`(selector: String, pageFunction: (on: Array<E>, arg2: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally): Promise<R>
//    fun <R, Arg> waitForFunction(pageFunction: String, arg: Arg, options: PageWaitForFunctionOptions = definedExternally): Promise<SmartHandle<R>>
//    fun <R, Arg> waitForFunction(pageFunction: (arg: Unboxed<Arg>) -> dynamic, arg: Arg, options: PageWaitForFunctionOptions = definedExternally): Promise<SmartHandle<R>>
//    fun <R> waitForFunction(pageFunction: String, arg: Any = definedExternally, options: PageWaitForFunctionOptions = definedExternally): Promise<SmartHandle<R>>
//    fun <R> waitForFunction(pageFunction: (arg: Unboxed<Unit>) -> dynamic, arg: Any = definedExternally, options: PageWaitForFunctionOptions = definedExternally): Promise<SmartHandle<R>>
//    fun <K : Any> waitForSelector(selector: K, options: PageWaitForSelectorOptions /* PageWaitForSelectorOptions & `T$13` */ = definedExternally): dynamic /* Promise | Promise */
//    fun waitForSelector(selector: String, options: PageWaitForSelectorOptions /* PageWaitForSelectorOptions & `T$13` */ = definedExternally): dynamic /* Promise | Promise */
    fun on(
        event: String /* 'close' | 'crash' | 'domcontentloaded' | 'load' */,
        listener: () -> Unit
    ): Page /* this */
//    fun on(event: String /* 'console' */, listener: (consoleMessage: ConsoleMessage) -> Unit): Page /* this */
//    fun on(event: String /* 'dialog' */, listener: (dialog: Dialog) -> Unit): Page /* this */
//    fun on(event: String /* 'download' */, listener: (download: Download) -> Unit): Page /* this */
//    fun on(event: String /* 'filechooser' */, listener: (fileChooser: FileChooser) -> Unit): Page /* this */
//    fun on(event: String /* 'frameattached' | 'framedetached' | 'framenavigated' */, listener: (frame: Frame) -> Unit): Page /* this */
    fun on(event: String /* 'pageerror' */, listener: (error: Error) -> Unit): Page /* this */
    fun on(event: String /* 'popup' */, listener: (page: Page) -> Unit): Page /* this */
    fun on(
        event: String /* 'request' | 'requestfailed' | 'requestfinished' */,
        listener: (request: Request) -> Unit
    ): Page /* this */
    fun on(event: String /* 'response' */, listener: (response: Response) -> Unit): Page /* this */
    fun on(event: String /* 'worker' */, listener: (worker: Worker) -> Unit): Page /* this */
    fun once(
        event: String /* 'close' | 'crash' | 'domcontentloaded' | 'load' */,
        listener: () -> Unit
    ): Page /* this */
//    fun once(event: String /* 'console' */, listener: (consoleMessage: ConsoleMessage) -> Unit): Page /* this */
//    fun once(event: String /* 'dialog' */, listener: (dialog: Dialog) -> Unit): Page /* this */
//    fun once(event: String /* 'download' */, listener: (download: Download) -> Unit): Page /* this */
//    fun once(event: String /* 'filechooser' */, listener: (fileChooser: FileChooser) -> Unit): Page /* this */
//    fun once(event: String /* 'frameattached' | 'framedetached' | 'framenavigated' */, listener: (frame: Frame) -> Unit): Page /* this */
    fun once(event: String /* 'pageerror' */, listener: (error: Error) -> Unit): Page /* this */
    fun once(event: String /* 'popup' */, listener: (page: Page) -> Unit): Page /* this */
    fun once(
        event: String /* 'request' | 'requestfailed' | 'requestfinished' */,
        listener: (request: Request) -> Unit
    ): Page /* this */
    fun once(event: String /* 'response' */, listener: (response: Response) -> Unit): Page /* this */
    fun once(event: String /* 'worker' */, listener: (worker: Worker) -> Unit): Page /* this */
    fun addListener(
        event: String /* 'close' | 'crash' | 'domcontentloaded' | 'load' */,
        listener: () -> Unit
    ): Page /* this */
//    fun addListener(event: String /* 'console' */, listener: (consoleMessage: ConsoleMessage) -> Unit): Page /* this */
//    fun addListener(event: String /* 'dialog' */, listener: (dialog: Dialog) -> Unit): Page /* this */
//    fun addListener(event: String /* 'download' */, listener: (download: Download) -> Unit): Page /* this */
//    fun addListener(event: String /* 'filechooser' */, listener: (fileChooser: FileChooser) -> Unit): Page /* this */
//    fun addListener(event: String /* 'frameattached' | 'framedetached' | 'framenavigated' */, listener: (frame: Frame) -> Unit): Page /* this */
    fun addListener(event: String /* 'pageerror' */, listener: (error: Error) -> Unit): Page /* this */
    fun addListener(event: String /* 'popup' */, listener: (page: Page) -> Unit): Page /* this */
    fun addListener(
        event: String /* 'request' | 'requestfailed' | 'requestfinished' */,
        listener: (request: Request) -> Unit
    ): Page /* this */
    fun addListener(event: String /* 'response' */, listener: (response: Response) -> Unit): Page /* this */
    fun addListener(event: String /* 'worker' */, listener: (worker: Worker) -> Unit): Page /* this */
    fun removeListener(
        event: String /* 'close' | 'crash' | 'domcontentloaded' | 'load' */,
        listener: () -> Unit
    ): Page /* this */
//    fun removeListener(event: String /* 'console' */, listener: (consoleMessage: ConsoleMessage) -> Unit): Page /* this */
//    fun removeListener(event: String /* 'dialog' */, listener: (dialog: Dialog) -> Unit): Page /* this */
//    fun removeListener(event: String /* 'download' */, listener: (download: Download) -> Unit): Page /* this */
//    fun removeListener(event: String /* 'filechooser' */, listener: (fileChooser: FileChooser) -> Unit): Page /* this */
//    fun removeListener(event: String /* 'frameattached' | 'framedetached' | 'framenavigated' */, listener: (frame: Frame) -> Unit): Page /* this */
    fun removeListener(event: String /* 'pageerror' */, listener: (error: Error) -> Unit): Page /* this */
    fun removeListener(event: String /* 'popup' */, listener: (page: Page) -> Unit): Page /* this */
    fun removeListener(
        event: String /* 'request' | 'requestfailed' | 'requestfinished' */,
        listener: (request: Request) -> Unit
    ): Page /* this */
    fun removeListener(event: String /* 'response' */, listener: (response: Response) -> Unit): Page /* this */
    fun removeListener(event: String /* 'worker' */, listener: (worker: Worker) -> Unit): Page /* this */
    fun off(
        event: String /* 'close' | 'crash' | 'domcontentloaded' | 'load' */,
        listener: () -> Unit
    ): Page /* this */
//    fun off(event: String /* 'console' */, listener: (consoleMessage: ConsoleMessage) -> Unit): Page /* this */
//    fun off(event: String /* 'dialog' */, listener: (dialog: Dialog) -> Unit): Page /* this */
//    fun off(event: String /* 'download' */, listener: (download: Download) -> Unit): Page /* this */
//    fun off(event: String /* 'filechooser' */, listener: (fileChooser: FileChooser) -> Unit): Page /* this */
//    fun off(event: String /* 'frameattached' | 'framedetached' | 'framenavigated' */, listener: (frame: Frame) -> Unit): Page /* this */
    fun off(event: String /* 'pageerror' */, listener: (error: Error) -> Unit): Page /* this */
    fun off(event: String /* 'popup' */, listener: (page: Page) -> Unit): Page /* this */
    fun off(
        event: String /* 'request' | 'requestfailed' | 'requestfinished' */,
        listener: (request: Request) -> Unit
    ): Page /* this */
    fun off(event: String /* 'response' */, listener: (response: Response) -> Unit): Page /* this */
    fun off(event: String /* 'worker' */, listener: (worker: Worker) -> Unit): Page /* this */
//    var accessibility: Accessibility
//    fun addInitScript(script: Function<*>, arg: Serializable = definedExternally): Promise<Unit>
//    fun addInitScript(script: String, arg: Serializable = definedExternally): Promise<Unit>
//    fun addInitScript(script: PageAddInitScriptScript, arg: Serializable = definedExternally): Promise<Unit>
//    fun addScriptTag(options: PageAddScriptTagOptions): Promise<ElementHandle__0>
//    fun addStyleTag(options: PageAddStyleTagOptions): Promise<ElementHandle__0>
    fun bringToFront(): Promise<Unit>
//    fun check(selector: String, options: PageCheckOptions = definedExternally): Promise<Unit>
//    fun click(selector: String, options: PageClickOptions = definedExternally): Promise<Unit>
    fun close(options: PageCloseOptions = definedExternally): Promise<Unit>
    fun content(): Promise<String>
    fun context(): BrowserContext
//    var coverage: ChromiumCoverage?
//    fun dblclick(selector: String, options: PageDblclickOptions = definedExternally): Promise<Unit>
//    fun dispatchEvent(selector: String, type: String, eventInit: Any = definedExternally, options: PageDispatchEventOptions = definedExternally): Promise<Unit>
//    fun emulateMedia(options: PageEmulateMediaOptions): Promise<Unit>
    fun exposeBinding(name: String, playwrightBinding: Function<*>): Promise<Unit>
    fun exposeFunction(name: String, playwrightFunction: Function<*>): Promise<Unit>
//    fun fill(selector: String, value: String, options: PageFillOptions = definedExternally): Promise<Unit>
//    fun focus(selector: String, options: PageFocusOptions = definedExternally): Promise<Unit>
//    fun frame(options: String): Frame?
//    fun frame(options: PageFrameOptions): Frame?
//    fun frames(): Array<Frame>
//    fun getAttribute(selector: String, name: String, options: PageGetAttributeOptions = definedExternally): Promise<String?>
//    fun goBack(options: PageGoBackOptions = definedExternally): Promise<Response?>
//    fun goForward(options: PageGoForwardOptions = definedExternally): Promise<Response?>
    fun goto(url: String, options: PageGotoOptions = definedExternally): Promise<Response?>
//    fun hover(selector: String, options: PageHoverOptions = definedExternally): Promise<Unit>
//    fun innerHTML(selector: String, options: PageInnerHTMLOptions = definedExternally): Promise<String>
//    fun innerText(selector: String, options: PageInnerTextOptions = definedExternally): Promise<String>
    fun isClosed(): Boolean
//    var keyboard: Keyboard
//    fun mainFrame(): Frame
//    var mouse: Mouse
    fun opener(): Promise<Page?>
//    fun pdf(options: PagePdfOptions = definedExternally): Promise<Any>
//    fun press(selector: String, key: String, options: PagePressOptions = definedExternally): Promise<Unit>
//    fun reload(options: PageReloadOptions = definedExternally): Promise<Response?>
    fun route(url: String, handler: (arg0: Route, arg1: Request) -> Unit): Promise<Unit>
    fun route(url: RegExp, handler: (arg0: Route, arg1: Request) -> Unit): Promise<Unit>
    fun route(url: (arg0: URL) -> Boolean, handler: (arg0: Route, arg1: Request) -> Unit): Promise<Unit>
    fun screenshot(options: PageScreenshotOptions = definedExternally): Promise<Any>
//    fun selectOption(selector: String, values: String?, options: PageSelectOptionOptions = definedExternally): Promise<Array<String>>
//    fun selectOption(selector: String, values: ElementHandle__0?, options: PageSelectOptionOptions = definedExternally): Promise<Array<String>>
//    fun selectOption(selector: String, values: Array<String>?, options: PageSelectOptionOptions = definedExternally): Promise<Array<String>>
//    fun selectOption(selector: String, values: PageSelectOptionValues?, options: PageSelectOptionOptions = definedExternally): Promise<Array<String>>
//    fun selectOption(selector: String, values: Array<ElementHandle__0>?, options: PageSelectOptionOptions = definedExternally): Promise<Array<String>>
//    fun selectOption(selector: String, values: Array<Any>?, options: PageSelectOptionOptions = definedExternally): Promise<Array<String>>
//    fun setContent(html: String, options: PageSetContentOptions = definedExternally): Promise<Unit>
    fun setDefaultNavigationTimeout(timeout: Number)
    fun setDefaultTimeout(timeout: Number)
//    fun setExtraHTTPHeaders(headers: `T$0`): Promise<Unit>
//    fun setInputFiles(selector: String, files: String, options: PageSetInputFilesOptions = definedExternally): Promise<Unit>
//    fun setInputFiles(selector: String, files: Array<String>, options: PageSetInputFilesOptions = definedExternally): Promise<Unit>
//    fun setInputFiles(selector: String, files: PageSetInputFilesFiles, options: PageSetInputFilesOptions = definedExternally): Promise<Unit>
//    fun setInputFiles(selector: String, files: Array<Any>, options: PageSetInputFilesOptions = definedExternally): Promise<Unit>
//    fun setViewportSize(viewportSize: PageSetViewportSizeViewportSize): Promise<Unit>
//    fun textContent(selector: String, options: PageTextContentOptions = definedExternally): Promise<String?>
    fun title(): Promise<String>
//    fun type(selector: String, text: String, options: PageTypeOptions = definedExternally): Promise<Unit>
//    fun uncheck(selector: String, options: PageUncheckOptions = definedExternally): Promise<Unit>
    fun unroute(url: String, handler: (arg0: Route, arg1: Request) -> Unit = definedExternally): Promise<Unit>
    fun unroute(url: RegExp, handler: (arg0: Route, arg1: Request) -> Unit = definedExternally): Promise<Unit>
    fun unroute(
        url: (arg0: URL) -> Boolean,
        handler: (arg0: Route, arg1: Request) -> Unit = definedExternally
    ): Promise<Unit>
    fun url(): String
//    fun viewportSize(): PageViewportSize?
//    fun waitForEvent(event: String /* 'close' | 'crash' | 'domcontentloaded' | 'load' */, optionsOrPredicate: `T$1` = definedExternally): Promise<Unit>
//    fun waitForEvent(event: String /* 'console' */, optionsOrPredicate: `T$2` = definedExternally): Promise<ConsoleMessage>
//    fun waitForEvent(event: String /* 'dialog' */, optionsOrPredicate: `T$3` = definedExternally): Promise<Dialog>
//    fun waitForEvent(event: String /* 'download' */, optionsOrPredicate: `T$4` = definedExternally): Promise<Download>
//    fun waitForEvent(event: String /* 'filechooser' */, optionsOrPredicate: `T$5` = definedExternally): Promise<FileChooser>
//    fun waitForEvent(event: String /* 'frameattached' | 'framedetached' | 'framenavigated' */, optionsOrPredicate: `T$6` = definedExternally): Promise<Frame>
//    fun waitForEvent(event: String /* 'pageerror' */, optionsOrPredicate: `T$7` = definedExternally): Promise<Error>
//    fun waitForEvent(event: String /* 'popup' */, optionsOrPredicate: `T$8` = definedExternally): Promise<Page>
//    fun waitForEvent(event: String /* 'request' | 'requestfailed' | 'requestfinished' */, optionsOrPredicate: `T$9` = definedExternally): Promise<Request>
//    fun waitForEvent(event: String /* 'response' */, optionsOrPredicate: `T$10` = definedExternally): Promise<Response>
//    fun waitForEvent(event: String /* 'worker' */, optionsOrPredicate: `T$11` = definedExternally): Promise<Worker>
//    fun waitForLoadState(state: String /* "load" | "domcontentloaded" | "networkidle" */ = definedExternally, options: PageWaitForLoadStateOptions = definedExternally): Promise<Unit>
//    fun waitForNavigation(options: PageWaitForNavigationOptions = definedExternally): Promise<Response?>
//    fun waitForRequest(urlOrPredicate: String, options: PageWaitForRequestOptions = definedExternally): Promise<Request>
//    fun waitForRequest(urlOrPredicate: RegExp, options: PageWaitForRequestOptions = definedExternally): Promise<Request>
//    fun waitForRequest(urlOrPredicate: Function<*>, options: PageWaitForRequestOptions = definedExternally): Promise<Request>
//    fun waitForResponse(urlOrPredicate: String, options: PageWaitForResponseOptions = definedExternally): Promise<Response>
//    fun waitForResponse(urlOrPredicate: RegExp, options: PageWaitForResponseOptions = definedExternally): Promise<Response>
//    fun waitForResponse(urlOrPredicate: Function<*>, options: PageWaitForResponseOptions = definedExternally): Promise<Response>
    fun waitForTimeout(timeout: Number): Promise<Unit>
    fun workers(): Array<Worker>
}

external interface PageCloseOptions {
    var runBeforeUnload: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PageGotoOptions {
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var waitUntil: String? /* "load" | "domcontentloaded" | "networkidle" */
        get() = definedExternally
        set(value) = definedExternally
    var referer: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PageScreenshotOptions {
    var path: String?
        get() = definedExternally
        set(value) = definedExternally
    var type: String? /* "png" | "jpeg" */
        get() = definedExternally
        set(value) = definedExternally
    var quality: Number?
        get() = definedExternally
        set(value) = definedExternally
    var fullPage: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var clip: PageScreenshotOptionsClip?
        get() = definedExternally
        set(value) = definedExternally
    var omitBackground: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PageScreenshotOptionsClip {
    var x: Number
    var y: Number
    var width: Number
    var height: Number
}
