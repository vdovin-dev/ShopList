package com.example.shoplist.domain

class AddShopItemUseCase(private val shopListRepo: ShopListRepo) {
    fun addShopItem(shopItem: ShopItem){
        shopListRepo.addShopItem(shopItem)


    }
}