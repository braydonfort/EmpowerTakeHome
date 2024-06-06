package com.example.data.repo

import com.example.data.models.Beneficiary

/**
 * BeneficiariesRepo
 * Repo Interface for beneficiaries functions
 * @see[BeneficiariesRepoImpl]
 */
interface BeneficiariesRepo {
     fun getBeneficiariesList(): List<Beneficiary>?
}