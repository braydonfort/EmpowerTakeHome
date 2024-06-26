package com.example.empowertakehome

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.models.Beneficiary
import com.example.empowertakehome.ui.theme.EmpowerTakeHomeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * MainActivity
 * Main activity for the app
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView = LinearLayout(this)

        //create layout
        rootView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        rootView.orientation = LinearLayout.VERTICAL

        val titleTextView = TextView(this).apply {
            setTextSize(TypedValue.COMPLEX_UNIT_SP,30f)
        }
        titleTextView.text = "Beneficiaries List"
        titleTextView.gravity = Gravity.CENTER
        rootView.addView(titleTextView)

        val recyclerView = RecyclerView(this)
        recyclerView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = BeneficiariesAdapter()
        recyclerView.adapter = adapter
        rootView.addView(recyclerView)

        //observe beneficiaries list
        viewModel._beneficiariesList.observe(this, Observer {
             adapter.setData(it)
        })
        setContentView(rootView)

        //set the list
        viewModel.setList()
    }
}