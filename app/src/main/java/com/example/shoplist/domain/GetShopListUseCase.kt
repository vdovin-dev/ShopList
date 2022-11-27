package com.example.shoplist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepo: ShopListRepo) {
    fun getShopList():LiveData<List<ShopItem>>{
        return shopListRepo.getShopList()
    }
}