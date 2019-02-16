package com.mobway.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobway.financask.R
import com.mobway.financask.model.Transaction
import com.mobway.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transactions = listOf(Transaction(BigDecimal(20.5),
            "Comida", Calendar.getInstance()),
            Transaction(BigDecimal(100), "Economia", Calendar.getInstance()))

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transactions, this)

    }
}