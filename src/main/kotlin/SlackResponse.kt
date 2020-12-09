
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SlackResponse(
    @SerialName("data")
    val `data`: SlackData
)

@Serializable
data class SlackData(
    @SerialName("error")
    val error: String,
    @SerialName("ok")
    val ok: Boolean,
    @SerialName("file")
    val `file`: File
)

@Serializable
data class File(
    @SerialName("channels")
    val channels: List<String>,
    @SerialName("comments_count")
    val commentsCount: Int,
    @SerialName("created")
    val created: Int,
    @SerialName("display_as_bot")
    val displayAsBot: Boolean,
    @SerialName("editable")
    val editable: Boolean,
    @SerialName("external_type")
    val externalType: String,
    @SerialName("filetype")
    val filetype: String,
    @SerialName("groups")
    val groups: List<Any>,
    @SerialName("has_rich_preview")
    val hasRichPreview: Boolean,
    @SerialName("id")
    val id: String,
    @SerialName("ims")
    val ims: List<Any>,
    @SerialName("is_external")
    val isExternal: Boolean,
    @SerialName("is_public")
    val isPublic: Boolean,
    @SerialName("is_starred")
    val isStarred: Boolean,
    @SerialName("mimetype")
    val mimetype: String,
    @SerialName("mode")
    val mode: String,
    @SerialName("name")
    val name: String,
    @SerialName("original_h")
    val originalH: Int,
    @SerialName("original_w")
    val originalW: Int,
    @SerialName("permalink")
    val permalink: String,
    @SerialName("permalink_public")
    val permalinkPublic: String,
    @SerialName("pretty_type")
    val prettyType: String,
    @SerialName("public_url_shared")
    val publicUrlShared: Boolean,
    @SerialName("shares")
    val shares: Shares,
    @SerialName("size")
    val size: Int,
    @SerialName("thumb_1024")
    val thumb1024: String,
    @SerialName("thumb_1024_h")
    val thumb1024H: Int,
    @SerialName("thumb_1024_w")
    val thumb1024W: Int,
    @SerialName("thumb_160")
    val thumb160: String,
    @SerialName("thumb_360")
    val thumb360: String,
    @SerialName("thumb_360_h")
    val thumb360H: Int,
    @SerialName("thumb_360_w")
    val thumb360W: Int,
    @SerialName("thumb_480")
    val thumb480: String,
    @SerialName("thumb_480_h")
    val thumb480H: Int,
    @SerialName("thumb_480_w")
    val thumb480W: Int,
    @SerialName("thumb_64")
    val thumb64: String,
    @SerialName("thumb_720")
    val thumb720: String,
    @SerialName("thumb_720_h")
    val thumb720H: Int,
    @SerialName("thumb_720_w")
    val thumb720W: Int,
    @SerialName("thumb_80")
    val thumb80: String,
    @SerialName("thumb_800")
    val thumb800: String,
    @SerialName("thumb_800_h")
    val thumb800H: Int,
    @SerialName("thumb_800_w")
    val thumb800W: Int,
    @SerialName("thumb_960")
    val thumb960: String,
    @SerialName("thumb_960_h")
    val thumb960H: Int,
    @SerialName("thumb_960_w")
    val thumb960W: Int,
    @SerialName("thumb_tiny")
    val thumbTiny: String,
    @SerialName("timestamp")
    val timestamp: Int,
    @SerialName("title")
    val title: String,
    @SerialName("url_private")
    val urlPrivate: String,
    @SerialName("url_private_download")
    val urlPrivateDownload: String,
    @SerialName("user")
    val user: String,
    @SerialName("username")
    val username: String
)

@Serializable
data class Shares(
    @SerialName("public")
    val `public`: Public
)

@Serializable
data class Public(
    val channel: List<Channel>
)

@Serializable
data class Channel(
    @SerialName("channel_name")
    val channelName: String,
    @SerialName("reply_count")
    val replyCount: Int,
    @SerialName("reply_users")
    val replyUsers: List<Any>,
    @SerialName("reply_users_count")
    val replyUsersCount: Int,
    @SerialName("share_user_id")
    val shareUserId: String,
    @SerialName("team_id")
    val teamId: String,
    @SerialName("ts")
    val ts: String
)
