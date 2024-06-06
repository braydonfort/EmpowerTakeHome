package com.example.data.repo

import android.content.Context
import com.example.data.models.Beneficiary
import com.example.data.utils.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

/**
 * BeneficiariesRepoImpl
 * Repo Implementation for beneficiaries functions
 * @see[BeneficiariesRepo]
 * @param[Context]
 */
class BeneficiariesRepoImpl @Inject constructor(private val context: Context): BeneficiariesRepo{
    /**
     * Function to get the List of Beneficiaries
     * gets json file and converts in to return a List of Beneficiary
     */
    override fun getBeneficiariesList(): List<Beneficiary>? {
        val jsonString = getJsonDataFromAsset(context, "Beneficiaries.json")
        return if (jsonString != null) {
            val gson = Gson()
            val listType = object : TypeToken<List<Beneficiary>>() {}.type
            gson.fromJson(jsonString, listType)
        } else {
            emptyList()
        }
    }
}