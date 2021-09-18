package app.datafit.android.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeResponse(
        @SerializedName("id")
        @Expose
        var id: String? = null,
        @SerializedName("training_id")
        @Expose
        var training_id: String? = null,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("duration")
        @Expose
        var duration: String? = null,
        @SerializedName("description")
        @Expose
        var description: String? = null,
        @SerializedName("display")
        @Expose
        var display: Boolean? = null,
        @SerializedName("finished_at")
        @Expose
        var finished_at: String? = null)
