package com.angle.hshb.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by angle on 2018/9/7.
 * DESC:
 */
class ListAdapter(val item : ArrayList<String>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){
    override fun getItemCount(): Int {
        return item.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.setPadding(10,20,0,0)
        holder.textView.text = item.get(position)
    }

    class MyViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)
}