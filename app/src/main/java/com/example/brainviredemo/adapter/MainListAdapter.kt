package com.example.brainviredemo.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
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

        holder.itemView.tablaCuerpo.isStretchAllColumns = true
        holder.itemView.tablaCuerpo.bringToFront()
        for ((index,row) in subKeys.withIndex()){
            var tr = TableRow(mContext)
            var c1 = TextView(mContext)
            c1.text = row
            c1.gravity = Gravity.CENTER
            c1.setBackgroundResource(R.drawable.cell_shape)
            var c2 = TextView(mContext)
            c2.text = subValues[index].toString()
            c2.setBackgroundResource(R.drawable.cell_shape)
            c2.gravity = Gravity.CENTER
            tr.addView(c1)
            tr.addView(c2)
            holder.itemView.tablaCuerpo.addView(tr)
        }

    }

    override fun getItemCount(): Int {
        return mMap.size
    }
}