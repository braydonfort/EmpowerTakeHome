package com.example.empowertakehome

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.models.Beneficiary

/**
 * BeneficiariesAdapter
 * Recycler View Adapter for Beneficiaries List in MainActivity
 */

class BeneficiariesAdapter() :
    RecyclerView.Adapter<BeneficiariesAdapter.ViewHolder>() {

    private var data: List<Beneficiary> = listOf()
    private var expandedPosition = RecyclerView.NO_POSITION

    // Set the data
    fun setData(newData: List<Beneficiary>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context

        // Create the root container
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setPadding(16, 16, 16, 16)
            setBackgroundColor(Color.WHITE)

            // Set margin
            val layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(8, 0, 8, 20) // Set margins for spacing between items
            }
            this.layoutParams = layoutParams

            // Set border
            background = GradientDrawable().apply {
                setColor(Color.WHITE)
                setStroke(2, Color.BLACK) // Set the border width and color
            }
        }

        // Create TextViews for values
        val nameTextView = TextView(context).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        }
        val typeTextView = TextView(context).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        }
        val codeTextView = TextView(context).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        }
        val hiddenSSN = TextView(context).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        }
        val hiddenDOB = TextView(context).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        }
        val hiddenPhoneNumber = TextView(context).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        }
        val hiddenAddress = TextView(context).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        }

        // Add TextViews to the container
        container.addView(nameTextView)
        container.addView(typeTextView)
        container.addView(codeTextView)
        container.addView(hiddenSSN)
        container.addView(hiddenDOB)
        container.addView(hiddenPhoneNumber)
        container.addView(hiddenAddress)

        return ViewHolder(container, nameTextView, typeTextView, codeTextView, hiddenSSN, hiddenDOB, hiddenPhoneNumber, hiddenAddress)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beneficiary = data[position]
        holder.bind(beneficiary)
        val isExpanded = position == expandedPosition
        holder.hiddenSSN.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.hiddenDOB.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.hiddenPhoneNumber.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.hiddenAddress.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.itemView.setOnClickListener {
            expandedPosition = if (isExpanded) RecyclerView.NO_POSITION else position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(
        itemView: View,
        private val nameTextView: TextView,
        private val typeTextView: TextView,
        private val codeTextView: TextView,
        val hiddenSSN: TextView,
        val hiddenDOB: TextView,
        val hiddenPhoneNumber: TextView,
        val hiddenAddress: TextView
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(beneficiary: Beneficiary) {
            val fullName = "${beneficiary.firstName} ${beneficiary.lastName}"
            nameTextView.text = fullName
            typeTextView.text = beneficiary.beneType
            val designation = when (beneficiary.designationCode) {
                "C" -> "Contingent"
                "P" -> "Primary"
                else -> "Unknown"
            }
            codeTextView.text = designation
            hiddenSSN.text = beneficiary.socialSecurityNumber
            hiddenDOB.text = beneficiary.dateOfBirth
            hiddenPhoneNumber.text = beneficiary.phoneNumber
            val address = "${beneficiary.beneficiaryAddress.firstLineMailing} ${beneficiary.beneficiaryAddress.scndLineMailing} ${beneficiary.beneficiaryAddress.city}, ${beneficiary.beneficiaryAddress.stateCode} ${beneficiary.beneficiaryAddress.zipCode}, ${beneficiary.beneficiaryAddress.country} "
            hiddenAddress.text = address
        }
    }
}
