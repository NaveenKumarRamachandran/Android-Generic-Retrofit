package com.retrofit.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.retrofit.sample.model.Datum
import com.retrofit.sample.model.RequestUser
import com.retrofit.sample.model.ResponseCreateUser
import com.retrofit.sample.model.User
import com.retrofit.sample.services.ServiceCallBack
import com.retrofit.sample.services.ServiceError
import com.retrofit.sample.services.UserService

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





    }

    fun createUser(v: View) {
        val user = RequestUser()
        user.job = "Android "
        user.name = "naveen"
        UserService.getInstance().createUser(user, object : ServiceCallBack<ResponseCreateUser> {

            override fun onSuccess(responseCode: Int, responseMessage: String, data: ResponseCreateUser) {
                Log.d("onSuccess", "responseCode$responseCode")
            }


            override fun onFailed(errorData: ServiceError) {
                Log.d("Error onFailed", "" + errorData.errorCode)
            }
        })

    }

    fun getUser(v:View) {
        UserService.getInstance().getUser("2", object : ServiceCallBack<List<Datum>> {

            override fun onSuccess(responseCode: Int, responseMessage: String, data: List<Datum>) {

                for (i in data!!) {
                    Log.d("Data" + i.name, "" + i.email + i.id + i.firstName)

                }
                Log.d("OnSuccess" + data.size, "response")

            }

            override fun onFailed(errorData: ServiceError) {
                Log.d("onFailed" + errorData.errorMessage, "")
                Log.d("nnnwnewnewnienw\n", "error")
            }
        })

    }

}






