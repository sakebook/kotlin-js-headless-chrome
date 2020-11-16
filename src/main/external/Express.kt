external interface Request {
    val body: Any
}

external interface Response {
    fun status(code: Int): Response
    fun send(message: String): Response
    fun end(): Response
    fun set(str1: String, str2: String)
}
