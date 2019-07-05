package com.retrofit.sample.services

import com.retrofit.sample.model.Datum
import com.retrofit.sample.model.RequestUser
import com.retrofit.sample.model.ResponseCreateUser
import com.retrofit.sample.model.User
import retrofit2.Call
import retrofit2.http.*

interface APICallBack {

    //Querying data api/users?page=2
    @GET("api/users?")
    fun getUsers(@Query("page")page:String) : Call<APIResponse<List<Datum>>>

    ///api/user
    @POST("api/user")
    fun createUser(@Body user: RequestUser):Call<APIResponse<ResponseCreateUser>>

    @PUT("")
    fun updateUser():Call<User>

    @DELETE("")
    fun deleteUser()

    @PATCH("")
    fun patchUser():Call<User>




}