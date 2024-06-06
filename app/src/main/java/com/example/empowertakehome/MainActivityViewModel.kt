package com.example.empowertakehome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.Beneficiary
import com.example.data.usecase.GetBeneficiariesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val getBeneficiariesUseCase: GetBeneficiariesUseCase): ViewModel() {
    private var beneficiariesList = MutableLiveData<List<Beneficiary>>()
    val _beneficiariesList: LiveData<List<Beneficiary>>
        get() = beneficiariesList

     fun setList(){
         beneficiariesList.value = getBeneficiariesUseCase.execute()
    }
}