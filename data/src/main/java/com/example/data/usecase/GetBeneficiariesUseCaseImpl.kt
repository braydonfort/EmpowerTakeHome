package com.example.data.usecase

import com.example.data.models.Beneficiary
import com.example.data.repo.BeneficiariesRepo
import javax.inject.Inject

class GetBeneficiariesUseCaseImpl @Inject constructor(private val beneficiariesRepo: BeneficiariesRepo): GetBeneficiariesUseCase {
    override fun execute(): List<Beneficiary>? {
        return beneficiariesRepo.getBeneficiariesList()
    }
}