package com.example.data.usecase

import com.example.data.models.Beneficiary

/**
 * GetBeneficiariesUseCase
 * Interface for the getting the beneficiaries list
 * @see[GetBeneficiariesUseCaseImpl]
 */
interface GetBeneficiariesUseCase {
     fun execute(): List<Beneficiary>?
}