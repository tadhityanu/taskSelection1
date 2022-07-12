package com.example.suitmediatest.firstPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.ActivityMainBinding
import com.example.suitmediatest.secondPage.secondPage
import com.example.suitmediatest.secondPage.secondPage.Companion.EXTRA_NAME

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        palindromeCheck()
        nextButton()
    }

    private fun nextButton(){
        binding.btnNext.setOnClickListener{
            val textName :Editable? = binding.edtUsername.text
            val intent = Intent(this, secondPage::class.java)
            intent.putExtra(EXTRA_NAME, textName.toString())
            startActivity(intent)
            finish()
        }
    }

    private fun palindromeCheck(){
        binding.btnCheck.setOnClickListener{
            val text = binding.edtPalindromeText.text.toString()
            if (isPalindrome(text)){
                Toast.makeText(this, "Text is Palindrome", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Text is not Palindrome", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPalindrome(text: String) : Boolean{
        val reverseString = text.reversed().toString()
        return text.equals(reverseString, ignoreCase = true)
    }

}