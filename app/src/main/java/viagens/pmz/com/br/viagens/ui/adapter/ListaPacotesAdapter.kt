package viagens.pmz.com.br.viagens.ui.adapter

import alura.pmz.com.br.financask.extension.formataParaBrasileiro
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat.getDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_pacote.view.*
import viagens.pmz.com.br.viagens.R.layout.item_pacote
import viagens.pmz.com.br.viagens.model.Pacote
import viagens.pmz.com.br.viagens.utils.DiasUtil
import viagens.pmz.com.br.viagens.utils.ResourceUtil

class ListaPacotesAdapter(private val pacotes: List<Pacote>, private val context: Context) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context).inflate(item_pacote, parent, false)

        val pacote = pacotes[position]
        mostraLocal(viewCriada, pacote)
        mostraImagem(pacote, viewCriada)
        mostraDias(pacote, viewCriada)
        mostraPreco(viewCriada, pacote)

        return viewCriada
    }

    private fun mostraPreco(viewCriada: View, pacote: Pacote) {
        viewCriada.item_pacote_preco.text = pacote.preco.formataParaBrasileiro()
    }

    private fun mostraDias(pacote: Pacote, viewCriada: View) {
        val diasEmTexto = DiasUtil.getDias(pacote.dias)
        viewCriada.item_pacote_dias.text = diasEmTexto
    }

    private fun mostraImagem(pacote: Pacote, viewCriada: View) {
        val drawableImagemPacote = ResourceUtil.devolveDrawable(context, pacote.imagem)
        viewCriada.item_pacote_imagem.setImageDrawable(drawableImagemPacote)
    }

    private fun mostraLocal(viewCriada: View, pacote: Pacote) {
        viewCriada.item_pacote_local.text = pacote.local
    }

    override fun getItem(position: Int): Any {
        return pacotes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return pacotes.size
    }

}
