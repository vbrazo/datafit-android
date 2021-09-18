package app.datafit.android.models

data class ProfileResponse(
    val id: Int,
    val user_id: String,
    val name: String,
    val age: String,
    val gender: String,
    val goal: String,
    val height: String,
    val weight: String,
    val level: String,
    val days_of_rest: List<String>,
    val created_at: String,
    val updated_at: String
)
