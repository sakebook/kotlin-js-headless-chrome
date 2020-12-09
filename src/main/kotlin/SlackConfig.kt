class SlackConfig(val token: String, val channel: String) {

    init {
        DotEnv.config()
    }
}

@JsModule("dotenv")
private external object DotEnv {
    fun config()
}
