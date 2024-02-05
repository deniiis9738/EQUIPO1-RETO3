package com.example.systech_coffeemiau.ui.viewsmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.systech_coffeemiau.domain.models.ProductoModel
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
        getProducto(1)
    }

    private var _productoModel = MutableLiveData<ProductoModel>()
    val productoModel: LiveData<ProductoModel> = _productoModel

    private fun getProducto(id: Long) {
        viewModelScope.launch {
            val loadedProducto = withContext(Dispatchers.IO) {
                productoUseCase.getProducto(id)
            }
            _productoModel.postValue(loadedProducto)
        }
    }
}