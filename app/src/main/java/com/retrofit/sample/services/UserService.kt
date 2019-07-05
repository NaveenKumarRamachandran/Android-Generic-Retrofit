package com.retrofit.sample.services

import com.retrofit.sample.model.Datum
import com.retrofit.sample.model.RequestUser
import com.retrofit.sample.model.ResponseCreateUser
import retrofit2.Call

class UserService {

    private val apiCallBack: APICallBack = APIService.getInstance().getUser()

    companion object {

        private var instance: UserService? = null

        fun getInstance(): UserService {
            if (instance == null) {
                instance = UserService()
            }
            return instance as UserService
        }

    }

    fun getUser(str: String, serviceCallBack: ServiceCallBack<List<Datum>>) {
            val call: Call<APIResponse<List<Datum>>> = this.apiCallBack.getUsers(str)
        ResponseHandler.getInstance().handleResponse(call, serviceCallBack)

    }

    fun createUser(user:RequestUser, serviceCallBack: ServiceCallBack<ResponseCreateUser>) {
        val call: Call<APIResponse<ResponseCreateUser>> = this.apiCallBack.createUser(user)
        ResponseHandler.getInstance().handleResponse(call, serviceCallBack)
    }

}