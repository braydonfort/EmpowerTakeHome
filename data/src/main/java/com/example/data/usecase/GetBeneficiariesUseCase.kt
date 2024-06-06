package com.example.data.usecase

import com.example.data.models.Beneficiary

interface GetBeneficiariesUseCase {
     fun execute(): List<Beneficiary>?
}