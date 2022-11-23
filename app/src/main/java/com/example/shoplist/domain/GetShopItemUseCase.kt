package com.example.shoplist.domain

class GetShopItemUseCase(private val shopListRepo: ShopListRepo) {
    fun getShopItem(shopItemId:Int):ShopItem{
        return shopListRepo.getShopItem(shopItemId)
    }
}