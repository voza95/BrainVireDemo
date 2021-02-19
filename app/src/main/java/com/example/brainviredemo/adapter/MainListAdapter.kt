package com.example.brainviredemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brainviredemo.MainActivity
import com.example.brainviredemo.R
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainListAdapter(
    var mContext: MainActivity,
    var mMap: HashMap<String,HashMap<String,Double>>
) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>(){

    class MainListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.main_list_item,parent,false)
        return  MainListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        for (item in mMap){
            holder.itemView.titleTV.text = item.key+" : "+item.value+"\n"
        }
        /*holder.itemView.titleTV.text = mMap.keys.toString()
        holder.itemView.detailTV.text = mMap.values.toString()*/
    }

    override fun getItemCount(): Int {
        return mMap.size
    }
}