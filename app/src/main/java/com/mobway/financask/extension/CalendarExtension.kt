package com.mobway.financask.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formatDate(): String {
    val brasilianFormat = "dd/MM/yyyy"
    val format = SimpleDateFormat(brasilianFormat)
    return format.format(this.time)
}