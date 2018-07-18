package viagens.pmz.com.br.viagens.utils

class DiasUtil {
    companion object {
        fun getDias(dias: Int): String {
            return if (dias > 1) {
                "$dias dias"
            } else {
                "$dias dia"
            }
        }
    }
}
