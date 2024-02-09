package com.example.systech_coffeemiau.ui.viewsmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.systech_coffeemiau.domain.models.GatoModel
import com.example.systech_coffeemiau.domain.usecases.GetGatoUseCase
import javax.inject.Inject

class GatoViewModel @Inject constructor(private val gatoUseCase: GetGatoUseCase): ViewModel() {

    private var _gatoList = MutableLiveData<List<GatoModel>>()
    val gatoList: LiveData<List<GatoModel>> = _gatoList

    private var _gato = MutableLiveData<GatoModel>()
    val gato: LiveData<GatoModel> = _gato

    init {
        _gatoList.value = gatoUseCase.getGatoList()
    }

}