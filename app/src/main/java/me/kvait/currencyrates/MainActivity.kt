package me.kvait.currencyrates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import me.kvait.currencyrates.Api.ApiRepository
import me.kvait.currencyrates.adapter.AdapterValute
import splitties.toast.toast
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    private val repo = ApiRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSimpleListData()
    }


    private fun getSimpleListData() = lifecycleScope.launch {
        progressBar.visibility = View.VISIBLE
        try {
            val infoFromServer = repo.mGetValute()
            rvItemValute.layoutManager = LinearLayoutManager(this@MainActivity)
            rvItemValute.adapter = AdapterValute(infoFromServer.valutes.map { it.value })

        } catch (e: IOException) {
            toast(getString(R.string.error))
            rvItemValute.layoutManager = LinearLayoutManager(this@MainActivity)
            rvItemValute.adapter = AdapterValute(emptyList())

        }
        progressBar.visibility = View.GONE

    }
}