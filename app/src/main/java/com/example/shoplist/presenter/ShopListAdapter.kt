package com.example.shoplist.presenter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    val list = listOf<ShopItem>()

    class ShopItemViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
   //Метод возвращает кол-во элементов в коллекции
    override fun getItemCount(): Int {
        return list.size
    }
}