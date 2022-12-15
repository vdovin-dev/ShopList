package com.example.shoplist.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shoplist.R
import com.example.shoplist.domain.ShopItem
import java.text.FieldPosition
import java.util.Collections.list

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    val list = listOf<ShopItem>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
      val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_shop_disabled,parent,false)
        return ShopItemViewHolder(view)
    }
    //Получаем элемент из списка,и установливаем наме
    override fun onBindViewHolder(viewHolder: ShopItemViewHolder,position: Int) {
        val shopItem = list[position]
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()
        viewHolder.view.setOnLongClickListener{
            true
        }
    }
   //Метод возвращает кол-во элементов в коллекции
    override fun getItemCount(): Int {
        return list.size
    }
    class ShopItemViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }
}