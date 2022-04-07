package com.example.dontrun.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dontrun.R
import com.example.dontrun.model.User

class MainAdapter:RecyclerView.Adapter<MainViewHolder>() {

    var user = mutableListOf<User>()
    fun setUserList(users:List<User>){
        this.user=users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view,parent,false)
        return MainViewHolder(view)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user=user[position]
        holder.username.text=user.username
        holder.email.text=user.email
    }

    override fun getItemCount(): Int {
        return user.size
    }

}
class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
{
    var username = itemView.findViewById<TextView>(R.id.username_tv)
    var email=itemView.findViewById<TextView>(R.id.email_tv)
}
