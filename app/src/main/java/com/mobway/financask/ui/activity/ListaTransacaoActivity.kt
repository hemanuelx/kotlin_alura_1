package com.mobway.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobway.financask.R
import com.mobway.financask.extension.formatValueToBrazilianCurrency
import com.mobway.financask.model.Transaction
import com.mobway.financask.model.TransactionType
import com.mobway.financask.ui.ResumeView
import com.mobway.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal

class ListaTransacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transactions = exampleTransactions()
        configurateResume(transactions)

        configureList(transactions)
    }

    private fun configurateResume(transactions: List<Transaction>) {
        val decorView = window.decorView
        val resumeView = ResumeView(this,  decorView, transactions)
        resumeView.refresh()
    }

    private fun configureList(transactions: List<Transaction>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transactions, this)
    }

    private fun exampleTransactions(): List<Transaction> {
        return listOf(
            Transaction(value = BigDecimal(20.5), category = "Almoço de final de semana", transactionType = TransactionType.OUTGO),
            Transaction(value = BigDecimal(100), category = "Economia", transactionType = TransactionType.INCOMING),
            Transaction(value = BigDecimal(700), transactionType = TransactionType.OUTGO),
            Transaction(value = BigDecimal(500), category = "Receita", transactionType = TransactionType.INCOMING))
    }
}