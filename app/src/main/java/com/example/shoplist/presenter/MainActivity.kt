package com.example.shoplist.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.R
import com.example.shoplist.databinding.ActivityMainBinding
import com.example.shoplist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var llShopList : LinearLayout

     private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llShopList = findViewById(R.id.ll_shop_list)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this){
            showList(it)

        }
    }
    private fun showList(list:List<ShopItem>){
        for (shopItem in list){
            val layoutId = if(shopItem.enabled){
                R.layout.item_shop_enabled
            }else{
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId,llShopList,false)
            llShopList.addView(view)
        }

    }
}