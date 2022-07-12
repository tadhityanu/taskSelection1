package com.example.suitmediatest.secondPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ActionMode
import android.view.Menu
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.ActivitySecondPageBinding
import com.example.suitmediatest.firstPage.MainActivity
import com.example.suitmediatest.thirdPage.thirdPage

class secondPage : AppCompatActivity() {

    private lateinit var binding: ActivitySecondPageBinding
    private lateinit var viewModel : secondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(secondViewModel::class.java)

        buttonAction()
        backButton()
        displayName()

    }

    private fun displayName(){
        val name = intent.getStringExtra(EXTRA_NAME).toString()
        viewModel.nameOfUser(name)
        binding.txtName.text = viewModel.name

        val firstName = intent.getStringExtra(secondPage.EXTRA_SELECTED_FIRSTNAME)
        val lastName = intent.getStringExtra(secondPage.EXTRA_SELECTED_LASTNAME)
        val username = firstName + lastName
        viewModel.selectedUsername(username)
        binding.txtSelectedUsername.text = viewModel.userName
    }


    private fun buttonAction(){
        binding.btnChooseUser.setOnClickListener{
            val intent = Intent(this, thirdPage::class.java)
            startActivity(intent)

        }
    }

    private fun backButton(){
        binding.imgBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SELECTED_FIRSTNAME = "extra_selected_firstname"
        const val EXTRA_SELECTED_LASTNAME = "extra_selected_lastname"
    }

}