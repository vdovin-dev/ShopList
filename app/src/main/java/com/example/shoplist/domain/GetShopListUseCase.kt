package com.example.shoplist.domain

class GetShopListUseCase(private val shopListRepo: ShopListRepo) {
    fun getShopList():List<ShopItem>{
        return shopListRepo.getShopList()
    }
}