package com.example.shoplist.data

import com.example.shoplist.data.ShopListRepoImpl.shopList
import com.example.shoplist.domain.ShopItem
import com.example.shoplist.domain.ShopListRepo

object ShopListRepoImpl:ShopListRepo {
    private val shopList = mutableListOf<ShopItem>()

    //Переменная которая хранит Айдишку
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        //Если айди не определен то присваиваем ему айдишку иначе добавляем в коллекцию
        if (shopItem.id == ShopItem.UNDEFIEND_ID){
        //Присваиваем и увеличиваем айдишку при помощи инкремента
            shopItem.id = autoIncrementId++
    }
        //Добавляем новый Айди
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        //Заменяем старый элемент
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {

      return  shopList.find {
          //Поиск по Айдишке
          it.id == shopItemId
      }?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}