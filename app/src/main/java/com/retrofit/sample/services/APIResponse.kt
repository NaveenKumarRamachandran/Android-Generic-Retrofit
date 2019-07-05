package com.retrofit.sample.services

import com.google.gson.annotations.SerializedName
import com.retrofit.sample.config.CommonConstant
import com.retrofit.sample.model.ResponseCreateUser


class APIResponse<E> {

    @SerializedName(CommonConstant.RESPONSE_CODE)
    var responseCode: Int = 0

    @SerializedName(CommonConstant.RESPONSE_MESSAGE)
    var responseMessage: String? = null

    @SerializedName(CommonConstant.DATA)
    var data: E? = null
}
