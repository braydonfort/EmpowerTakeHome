package com.example.data.models

/**
 * BeneficiaryAddress data class
 * Data class representing a beneficiary's address
 */
data class BeneficiaryAddress(
    val firstLineMailing: String,
    val scndLineMailing: String,
    val city: String,
    val zipCode: String,
    val stateCode: String,
    val country: String
)
