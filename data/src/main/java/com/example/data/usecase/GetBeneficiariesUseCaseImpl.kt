package com.example.data.usecase

import com.example.data.models.Beneficiary
import com.example.data.repo.BeneficiariesRepo
import javax.inject.Inject

/**
 * GetBeneficiariesUseCaseImpl
 * Implementation Class for getting the beneficiaries list
 * @see[GetBeneficiariesUseCase]
 * @param[BeneficiariesRepo]
 */
class GetBeneficiariesUseCaseImpl @Inject constructor(private val beneficiariesRepo: BeneficiariesRepo): GetBeneficiariesUseCase {
    /**
     * execute returns list of beneficiaries
     */
    override fun execute(): List<Beneficiary>? {
        return beneficiariesRepo.getBeneficiariesList()
    }
}