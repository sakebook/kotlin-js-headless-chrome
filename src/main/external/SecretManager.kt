import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.Promise

@JsModule("@google-cloud/secret-manager")
external object SecretManager {
    class SecretManagerServiceClient {
        fun accessSecretVersion(json: kotlin.js.Json = definedExternally): Promise<Array<AccessSecretVersionResponse>>
    }
}

@Serializable
external class AccessSecretVersionResponse {
    @SerialName("name")
    val name: String
    val payload: Data
}

@JsName("data")
external class Data {
    val data: Buffer
}

external class Buffer {
    fun toString(str: String): String
}

fun Array<AccessSecretVersionResponse>.value(): String {
    return this[0].payload.data.toString("utf8")
}
