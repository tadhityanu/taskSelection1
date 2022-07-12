package com.example.suitmediatest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.suitmediatest.R
import com.example.suitmediatest.api.userResponse
import com.example.suitmediatest.databinding.ItemUsernameBinding

class userAdapter:RecyclerView.Adapter<userAdapter.ListViewHolder>() {

    private var listUser:List<userResponse>? = null
    private var onItemClickCallback : OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setUserList(user:List<userResponse>?){
        this.listUser = user
        notifyDataSetChanged()
    }

    inner class ListViewHolder(val binding: ItemUsernameBinding):RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(userResponse: userResponse){

            binding.root.setOnClickListener{
                onItemClickCallback?.onItemClicked(userResponse)
            }

            binding.apply {
                Glide.with(itemView)
                    .load(userResponse.avatar)
                    .apply(RequestOptions().override(250, 250))
                    .into(imgUser)
                txtUsername.text = userResponse.first_name + userResponse.last_name
                txtEmail.text = userResponse.email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ItemUsernameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: userAdapter.ListViewHolder, position: Int) {
        listUser?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return if (listUser == null) 0
        else listUser?.size!!
    }

    interface OnItemClickCallback {
        fun onItemClicked (data:userResponse)
    }

}