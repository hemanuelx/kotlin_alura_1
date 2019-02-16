package com.mobway.financask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mobway.financask.R
import com.mobway.financask.extension.formatDate
import com.mobway.financask.model.Transaction
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesAdapter(   transactions: List<Transaction>,
    context: Context) : BaseAdapter() {

    private val transactions = transactions
    private val context = context

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val createdView = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)
        val transaction = transactions[position]

        createdView.transacao_valor.text = transaction.value.toString()
        createdView.transacao_categoria.text = transaction.category
        createdView.transacao_data.text = transaction.date.formatDate()

        return createdView
    }

    override fun getItem(position: Int): Transaction {
        return transactions[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transactions.size
    }
}
