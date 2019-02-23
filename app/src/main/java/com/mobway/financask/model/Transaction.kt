package com.mobway.financask.model

import java.math.BigDecimal
import java.util.*

class Transaction (val value: BigDecimal,
                   val category: String = "Indefinido",
                   val transactionType: TransactionType,
                   val date: Calendar = Calendar.getInstance())