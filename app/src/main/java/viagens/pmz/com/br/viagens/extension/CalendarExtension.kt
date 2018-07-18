package viagens.pmz.com.br.viagens.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro(): String {
    val formatoBrasileiro = SimpleDateFormat("dd/MM")
    return formatoBrasileiro.format(this.time)
}