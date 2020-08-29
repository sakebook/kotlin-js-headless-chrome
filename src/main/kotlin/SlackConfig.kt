class SlackConfig {
    val token: String
    val channel: String

    init {
        DotEnv.config()
        token = js("process.env.SLACK_TOKEN")?.unsafeCast<String>() ?: "dame token"
        channel = js("process.env.SLACK_CHANNEL")?.unsafeCast<String>() ?: "dame channel"
    }
}

@JsModule("dotenv")
private external object DotEnv {
    fun config()
}
