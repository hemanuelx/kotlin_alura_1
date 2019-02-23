package com.mobway.financask.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formatDate(): String {
    val brazilianFormat: String = "dd/MM/yyyy"
    val format = SimpleDateFormat(brazilianFormat)
    return format.format(this.time)
}