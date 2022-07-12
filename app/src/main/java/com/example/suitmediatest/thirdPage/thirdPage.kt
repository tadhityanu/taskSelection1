package com.example.suitmediatest.thirdPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitmediatest.adapter.userAdapter
import com.example.suitmediatest.api.userResponse
import com.example.suitmediatest.databinding.ActivityThirdPageBinding
import com.example.suitmediatest.secondPage.secondPage
import com.example.suitmediatest.secondPage.secondPage.Companion.EXTRA_SELECTED_FIRSTNAME
import com.example.suitmediatest.secondPage.secondPage.Companion.EXTRA_SELECTED_LASTNAME


class thirdPage : AppCompatActivity() {

    private lateinit var binding: ActivityThirdPageBinding
    private lateinit var viewModel : thirdViewModel
    private lateinit var adapter: userAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityThirdPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        backButton()
        setRecyclerView()
        setViewModel()

        adapter.setOnItemClickCallback(object : userAdapter.OnItemClickCallback{
            override fun onItemClicked(data: userResponse) {
                val intent = Intent(this@thirdPage, secondPage::class.java)
                intent.putExtra(EXTRA_SELECTED_FIRSTNAME, data.first_name)
                intent.putExtra(EXTRA_SELECTED_LASTNAME, data.last_name)
                startActivity(intent)
            }
        })

    }

    private fun setRecyclerView(){
        binding.rvUser.setHasFixedSize(true)
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        adapter = userAdapter()
        binding.rvUser.adapter = adapter

    }

    private fun setViewModel(){
        viewModel =ViewModelProvider(this)[thirdViewModel::class.java]
        viewModel.setUser()

        viewModel.getUser().observe(this){
            if (it!=null){
                adapter.setUserList(it)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun backButton() {
        binding.imgBack.setOnClickListener {
            val intent = Intent(this, secondPage::class.java)
            startActivity(intent)

        }
    }
}