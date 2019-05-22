package com.theapache64.removebg.utils


import com.google.gson.annotations.SerializedName

/**
 * Generated using MockAPI (https://github.com/theapache64/Mock-API) : Tue May 21 16:42:56 UTC 2019
 */
class ErrorResponse(
    @SerializedName("errors")
    val errors: List<Error>
) {

    class Error(
        @SerializedName("title")
        val title: String,
        @SerializedName("detail")
        val detail: String,
        @SerializedName("code")
        val code: String
    )
}