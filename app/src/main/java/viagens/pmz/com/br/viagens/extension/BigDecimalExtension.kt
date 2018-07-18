package alura.pmz.com.br.financask.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formataParaBrasileiro(): String {
    val formatoBr = DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
    return formatoBr
            .format(this)
            .replace("R$", "R$ ")
            .replace("-R$ ", "R$ -")
}