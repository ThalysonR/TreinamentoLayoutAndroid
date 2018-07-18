package alura.pmz.com.br.financask.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.limitaEmAte(caracteres: Int): String {
    if (this.length > caracteres) {
        val primeiroCaracter = 0
        return "${this.substring(primeiroCaracter, caracteres)}..."
    }
    return this
}

fun String.converteParaCalendar(): Calendar {
    val formatoBr = SimpleDateFormat("dd/MM/yyyy")
    val dataConvertida: Date = formatoBr.parse(this)
    val data = Calendar.getInstance()
    data.time = dataConvertida
    return data
}