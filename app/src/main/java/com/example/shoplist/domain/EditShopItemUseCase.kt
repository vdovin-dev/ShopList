package com.example.shoplist.domain

class EditShopItemUseCase(private val shopListRepo: ShopListRepo) {
    fun editShopItem(shopItem: ShopItem){
        shopListRepo.editShopItem(shopItem)
    }
}