package com.example.tamaskozmer.kotlinrxexample.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.tamaskozmer.kotlinrxexample.R
import com.example.tamaskozmer.kotlinrxexample.model.entities.User
import kotlinx.android.synthetic.main.list_item_user.view.*

/**
 * Created by Tamas_Kozmer on 7/3/2017.
 */
class UserListAdapter(val users: List<User>, val listener: (User) -> Unit) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(users[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent.inflate(R.layout.list_item_user))

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User, listener: (User) -> Unit) = with(itemView) {
            name.text = user.displayName
            reputation.text = user.reputation.toString()
            userAvatar.loadUrl(user.profileImage)
            setOnClickListener { listener(user) }
        }
    }

}