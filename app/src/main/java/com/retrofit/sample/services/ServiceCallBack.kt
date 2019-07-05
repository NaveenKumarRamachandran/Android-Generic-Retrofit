package com.retrofit.sample.services

interface ServiceCallBack<T> {

    fun onSuccess(responseCode:Int,responseMessage:String, data: T)

    fun onFailed(errorData: ServiceError)
}
