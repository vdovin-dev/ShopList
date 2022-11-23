package com.example.shoplist.domain

interface ShopListRepo {
    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId:Int):ShopItem
    
    fun getShopList():List<ShopItem>

}