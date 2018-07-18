package viagens.pmz.com.br.viagens.ui.activity

import alura.pmz.com.br.financask.extension.formataParaBrasileiro
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import viagens.pmz.com.br.viagens.R
import viagens.pmz.com.br.viagens.extension.formataParaBrasileiro
import viagens.pmz.com.br.viagens.model.Pacote
import viagens.pmz.com.br.viagens.utils.DiasUtil
import viagens.pmz.com.br.viagens.utils.ResourceUtil
import java.math.BigDecimal
import java.util.*

class ResumoPacoteActivity : AppCompatActivity() {

    private val pacote: Pacote = Pacote("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99))

    private val tituloAppBar = "Resumo do Pacote"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)
        title = tituloAppBar

        mostraLocal()
        mostraImagem()
        mostraDias()
        mostraPreco()
        mostraData()
    }

    private fun mostraPreco() {
        resumo_pacote_preco.text = pacote.preco.formataParaBrasileiro()
    }

    private fun mostraDias() {
        resumo_pacote_dias.text = DiasUtil.getDias(pacote.dias)
    }

    private fun mostraImagem() {
        resumo_pacote_imagem.setImageDrawable(ResourceUtil.devolveDrawable(this, pacote.imagem))
    }

    private fun mostraLocal() {
        resumo_pacote_local.text = pacote.local
    }

    private fun mostraData() {
        val dataFormatadaDaViagem = periodoEmTexto(pacote.dias)
        resumo_pacote_data.text = dataFormatadaDaViagem
    }

    private fun periodoEmTexto(dias: Int): String {
        val dataIda = Calendar.getInstance()
        val dataVolta = Calendar.getInstance()
        dataVolta.add(Calendar.DATE, dias)
        val dataFormatadaIda = dataIda.formataParaBrasileiro()
        val dataFormatadaVolta = dataVolta.formataParaBrasileiro()
        return "$dataFormatadaIda - $dataFormatadaVolta de ${dataVolta.get(Calendar.YEAR)}"
    }
}
