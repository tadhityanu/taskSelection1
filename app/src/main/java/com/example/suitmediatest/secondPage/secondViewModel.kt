package com.example.suitmediatest.secondPage

import android.content.Intent
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.suitmediatest.databinding.ActivitySecondPageBinding
import com.example.suitmediatest.secondPage.secondPage.Companion.EXTRA_NAME

class secondViewModel:ViewModel() {

    var name = ""
    var userName = ""

     fun nameOfUser(username:String){
         name = username
    }

    fun selectedUsername(username: String){
        userName = username
    }

}