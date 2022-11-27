package com.example.shoplist.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplist.data.ShopListRepoImpl
import com.example.shoplist.domain.DeleteShopItemUseCase
import com.example.shoplist.domain.EditShopItemUseCase
import com.example.shoplist.domain.GetShopListUseCase
import com.example.shoplist.domain.ShopItem

class MainViewModel:ViewModel() {

    private val repository = ShopListRepoImpl

    private val getShopListUseCase= GetShopListUseCase(repository)
    private val deleteShopListItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()
    //Метод получения списка
    fun getShopList(){
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    //Метод удаления элемента
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopListItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }


}