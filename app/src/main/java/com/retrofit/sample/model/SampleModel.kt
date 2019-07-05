package com.retrofit.sample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Datum {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("first_name")
    @Expose

    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    var password: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
}


open class User {

    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("per_page")
    @Expose
    var perPage: Int? = null
    @SerializedName("total")
    @Expose
    var total: Int? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}


open class ResponseCreateUser {

    @SerializedName("job")
    @Expose
    var job: String? = null


    @SerializedName("name")
    @Expose
    var name: String? = null


    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

}
class RequestUser{
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("job")
    @Expose
    var job: String? = null



}