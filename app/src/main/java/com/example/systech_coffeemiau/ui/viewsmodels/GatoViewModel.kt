package com.example.systech_coffeemiau.ui.viewsmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.systech_coffeemiau.domain.models.GatoModel
import com.example.systech_coffeemiau.domain.usecases.GetGatoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GatoViewModel @Inject constructor(private val gatoUseCase: GetGatoUseCase): ViewModel() {

    private var _gatoList = MutableLiveData<List<GatoModel>>()
    val gatoList: LiveData<List<GatoModel>> = _gatoList

    private var _gato = MutableLiveData<GatoModel>()
    val gato: LiveData<GatoModel> = _gato

    init {
        initializeGatoList()
    }

    private fun initializeGatoList() {
        viewModelScope.launch {
            val loadedGatoList = withContext(Dispatchers.IO){
                val gatoList = gatoUseCase.getGatoList()

                gatoList.map { gatoUseCase.getGato(it) }
            }

            _gatoList.postValue(loadedGatoList)
        }
    }

}