package app.datafit.android.models

data class SignUpResponse(
    val id: Int,
    val email: String,
    val role: String,
    val created_at: String,
    val updated_at: String
)