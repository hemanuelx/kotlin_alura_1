package com.mobway.financask.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mobway.financask.R
import com.mobway.financask.extension.formatDate
import com.mobway.financask.extension.formatValueToBrazilianCurrency
import com.mobway.financask.extension.limitedUntil
import com.mobway.financask.model.Transaction
import com.mobway.financask.model.TransactionType
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(
    private val transactions: List<Transaction>,
    private val context: Context
) : BaseAdapter() {
    private val categoryLimit = 14

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val createdView = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)
        val transaction = transactions[position]

        addValue(createdView,transaction)
        addIcon(createdView, transaction)
        addCategory(createdView, transaction)
        addDate(createdView, transaction)

        return createdView
    }

    private fun addDate(createdView: View, transaction: Transaction) {
        createdView.transacao_data.text = transaction.date.formatDate()
    }

    private fun addCategory(createdView: View, transaction: Transaction) {
        createdView.transacao_categoria.text = transaction.category.limitedUntil(categoryLimit)
    }

    private fun addIcon(createdView: View, transaction: Transaction) {
        val icon = iconByType(transaction.transactionType)
        createdView.transacao_icone.setBackgroundResource(iconByType(transaction.transactionType))
    }

    private fun iconByType(transactionType: TransactionType): Int {
        return if (transactionType == TransactionType.INCOMING) {
            R.drawable.icone_transacao_item_receita
        } else {
            R.drawable.icone_transacao_item_despesa
        }
    }

    private fun addValue(createdView: View, transaction: Transaction) {
        if (transaction.transactionType == TransactionType.INCOMING) {
            createdView.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.receita))
        } else {
            createdView.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.despesa))
        }
        createdView.transacao_valor.text = transaction.value.formatValueToBrazilianCurrency()
    }

    private fun colorByType(transactionType: TransactionType): Int {
       return if (transactionType == TransactionType.INCOMING) {
            ContextCompat.getColor(context, R.color.receita)
        } else {
            ContextCompat.getColor(context, R.color.despesa)
        }
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
