package com.retrofit.sample.services

interface ServiceCallBack<T> {

    fun onSuccess(responseCode:Int,responseMessage:String, responseBody: APIResponse<T>?)

    fun onFailed(errorData: ServiceError)
}
