package com.example.systech_coffeemiau.ui.viewsmodels

import androidx.lifecycle.ViewModel
import com.example.systech_coffeemiau.domain.usecases.GetGatoUseCase
import javax.inject.Inject

class GatoViewModel @Inject constructor(private val gatoUseCase: GetGatoUseCase): ViewModel() {


}