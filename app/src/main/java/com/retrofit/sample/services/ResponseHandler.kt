package com.retrofit.sample.services

import android.util.Log
import com.retrofit.sample.model.ResponseCreateUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResponseHandler private constructor() {

    fun <T> handleResponse(call: Call<APIResponse<T>>, serviceCallBack: ServiceCallBack<T>) {

        call.enqueue(object : Callback<APIResponse<T>> {
            override fun onResponse(call: Call<APIResponse<T>>, response: Response<APIResponse<T>>) {
                var message = ""
                Log.d(""+response.body(),""+response.code())
                when (response.code()) {
                    200 -> {
                        message = "OK"
                    }
                    201 -> {
                        message = "Created"
                    }
                    202 -> {
                        message = "Accepted"
                    }
                    203 -> {
                        message = "Non-Authoritative Information"

                    }
                    400 -> {
                        message = "Bad Request"
                    }
                    401 -> {
                        message = "Unauthorized"
                    }
                    404 -> {
                        message = "Not Found"
                    }
                    else -> {
                        serviceCallBack.onFailed(
                            ServiceError(
                                "" + response.body()!!.responseCode,
                                "" + response.body()!!.responseMessage)

                        )
                    }
                }
                try {
                    Log.d("name",""+response.body())
                        serviceCallBack.onSuccess(response.code(), message , response.body()!!.data!! )

                } catch (e: Exception) {
                    e.printStackTrace()
                    serviceCallBack.onFailed(ServiceError(""+response.code(),""+e.message))
                   // serviceCallBack.onSuccess(response.code(), message, response.body()?.data!!)
                }
            }

            override fun onFailure(call: Call<APIResponse<T>>, t: Throwable) {

                serviceCallBack.onFailed(ServiceError(t.localizedMessage, t.message))
                 Log.d("Error" + t.message, "" + t.localizedMessage)
            }
        })

    }

    companion object {

        private var instance: ResponseHandler? = null

        @Synchronized
        fun getInstance(): ResponseHandler {

            if (instance == null)
                instance = ResponseHandler()
            return instance as ResponseHandler
        }
    }
}
