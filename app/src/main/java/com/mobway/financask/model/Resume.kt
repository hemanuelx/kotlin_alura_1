package com.mobway.financask.model

import java.math.BigDecimal

class Resume(private val transactions: List<Transaction>) {
    val incoming get() = sumBy(TransactionType.INCOMING)

    val outgo get() = sumBy(TransactionType.OUTGO)

    val total: BigDecimal get() = incoming.subtract(outgo)

    private fun sumBy(type: TransactionType): BigDecimal {
        val sum = transactions.filter { it.transactionType == type }
            .sumByDouble { it.value.toDouble() }
        return BigDecimal(sum)
    }
}