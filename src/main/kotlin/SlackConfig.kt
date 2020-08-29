class SlackConfig {
    val token: String
    val channel: String

    init {
        DotEnv.config()
        token = js("process.env.SLACK_TOKEN")?.unsafeCast<String>() ?: throw IllegalArgumentException("token is not found.")
        channel = js("process.env.SLACK_CHANNEL")?.unsafeCast<String>() ?: throw IllegalArgumentException("channel is not found.")
    }
}

@JsModule("dotenv")
private external object DotEnv {
    fun config()
}
