package com.example.suitmediatest.thirdPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.suitmediatest.api.ResponseUser
import com.example.suitmediatest.api.apiConfig
import com.example.suitmediatest.api.userResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class thirdViewModel:ViewModel() {

    val listUser = MutableLiveData<List<userResponse>?>()

    fun setUser(){
        apiConfig.apiInstance.getUsers().enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful){
                    listUser.postValue(response.body()?.data)
                } else {
                    listUser.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                listUser.postValue(null)
            }
        })
    }

    fun getUser(): MutableLiveData<List<userResponse>?>{
        return listUser
    }

}