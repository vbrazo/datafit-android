package app.datafit.android.api

import retrofit2.Call
import app.datafit.android.models.*
import retrofit2.http.*
import com.google.gson.JsonElement

interface Api {
    @Headers("Content-type: application/json", "Accept-Language: en")
    @GET("/api/mobile/profiles/by_signature")
    fun getProfile():Call<ProfileResponse>

    @FormUrlEncoded
    @POST("/api/users")
    fun createUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("name") name: String
    ):Call<SignUpResponse>

    @FormUrlEncoded
    @POST("/api/users/sign_in")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ):Call<SignUpResponse>

    @FormUrlEncoded
    @PUT("/api/mobile/users/change_password")
    fun changePassword(
        @Field("password") password: String,
        @Field("password_confirmation") password_confirmation: String
    ):Call<SignUpResponse>

    @FormUrlEncoded
    @PUT("/api/mobile/users/change_profile")
    fun editProfile(
        @Field("height") height: String,
        @Field("weight") weight: String,
        @Field("age") age: String,
        @Field("gender") gender: String,
        @Field("goal") goal: String
    ):Call<ProfileResponse>

    @FormUrlEncoded
    @PUT("/api/mobile/users/change_profile")
    fun editLevel(
        @Field("level") level: String
    ):Call<ProfileResponse>

    @FormUrlEncoded
    @PUT("/api/mobile/users/change_profile")
    fun editFrequency(
        @Field("days_of_rest") days_of_rest: String
    ):Call<ProfileResponse>
}
