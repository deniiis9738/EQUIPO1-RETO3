package com.example.systech_coffeemiau.ui.viewsmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.usecases.GetProductoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductoViewModel @Inject constructor(
    private val productoUseCase: GetProductoUseCase
): ViewModel() {
    init {
        getProductList()
    }

    private var _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _productList
    private var _productoModel = MutableLiveData<Product>()
    val productoModel: LiveData<Product> = _productoModel

    private fun getProductList(){
        viewModelScope.launch {
            val loadedProductosList = withContext(Dispatchers.IO) {
                val productosList = productoUseCase.getProductList()
                productosList.map { producto ->
                    productoUseCase.getProducto(producto.id)
                }
            }
            _productList.postValue(loadedProductosList)
        }
    }

    fun getProducto(id: Long) {
        viewModelScope.launch {
            val loadedProducto = withContext(Dispatchers.IO) {
                productoUseCase.getProducto(id)
            }
            _productoModel.postValue(loadedProducto)
        }
    }
}