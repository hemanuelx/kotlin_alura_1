package com.mobway.financask.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import com.mobway.financask.R
import com.mobway.financask.extension.formatValueToBrazilianCurrency
import com.mobway.financask.model.Resume
import com.mobway.financask.model.Transaction
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumeView(private val context: Context,
                private val view: View,
                transactions: List<Transaction>) {

    private val resume: Resume = Resume(transactions)

    private val incomingColor = ContextCompat.getColor(context, R.color.receita)
    private val outgoColor = ContextCompat.getColor(context, R.color.despesa)

    fun refresh() {
        addIncoming()
        addOutgo()
        addTotal()
    }

    private fun addIncoming() {
        var totalIncoming = resume.incoming
        with(view.resumo_card_receita) {
            setTextColor(incomingColor)
            text = totalIncoming.formatValueToBrazilianCurrency()
        }
    }

    private fun addOutgo() {
        var totalOutgo = resume.outgo
        with(view.resumo_card_despesa) {
            setTextColor(outgoColor)
            text = totalOutgo.formatValueToBrazilianCurrency()
        }
    }

    private fun addTotal() {
        var total = resume.total
        val color = colorByValue(total)
        with(view.resumo_card_total) {
            setTextColor(color)
            text = total.formatValueToBrazilianCurrency()
        }
    }

    private fun colorByValue(value: BigDecimal): Int {
        return if (value >= BigDecimal.ZERO) {
            incomingColor
        } else {
            outgoColor
        }
    }
}