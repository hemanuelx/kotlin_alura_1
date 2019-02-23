package com.mobway.financask.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formatValueToBrazilianCurrency(): String {
    val brazilianCurrency = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
    return brazilianCurrency.format(this).replace("R$", "R$ ").replace("-R$ " , "R$ -")
}