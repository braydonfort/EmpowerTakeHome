package com.example.data.repo

import com.example.data.models.Beneficiary

interface BeneficiariesRepo {
     fun getBeneficiariesList(): List<Beneficiary>?
}