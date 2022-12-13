package com.example.shoplist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoplist.data.ShopListRepoImpl.shopList
import com.example.shoplist.domain.ShopItem
import com.example.shoplist.domain.ShopListRepo
import kotlin.random.Random

object ShopListRepoImpl:ShopListRepo {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    //Сщздается сортированный списсок, предаем компаратор для сравнивания элементов списка по айди
    private val shopList = sortedSetOf<ShopItem>({o1,o2 ->o1.id.compareTo(o2.id )})

    //Переменная которая хранит Айдишку
    private var autoIncrementId = 0

    init {
        for(i in 0 until 10){
            val item = ShopItem("Name $i",i, Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        //Если айди не определен то присваиваем ему айдишку иначе добавляем в коллекцию
        if (shopItem.id == ShopItem.UNDEFIEND_ID){
        //Присваиваем и увеличиваем айдишку при помощи инкремента
            shopItem.id = autoIncrementId++
    }
        //Добавляем новый Айди
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }
    //Обновление Списка
    private fun updateList(){
        shopListLD.value = shopList.toList()
    }
}