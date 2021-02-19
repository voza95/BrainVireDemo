package com.example.brainviredemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brainviredemo.MainActivity
import com.example.brainviredemo.R
import kotlinx.android.synthetic.main.main_list_item.view.*
import java.util.LinkedHashMap

class MainListAdapter(
        var mContext: MainActivity,
        var mMap: LinkedHashMap<String, LinkedHashMap<String, Double>>,
        var rateDates: ArrayList<String>
) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>(){

    var count:Int = 0
    class MainListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.main_list_item,parent,false)
        return  MainListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
       /* for (item in mMap){
            holder.itemView.titleTV.text = item.key+" : "+item.value+"\n"
        }*/

        holder.itemView.dateTV.text = rateDates[position]//mMap[rateDates[position]].toString()
        //holder.itemView.detailTV.text = "Date: "+ mMap[rateDates[position]].toString()

        var subKeys = ArrayList<String>(mMap[rateDates[position]]?.keys)
        var subValues = ArrayList<Double>(mMap[rateDates[position]]?.values)
        holder.itemView.viewOneTV.text = "${subKeys[0]} = ${subValues[0]}"
    }

    override fun getItemCount(): Int {
        return mMap.size
    }
}