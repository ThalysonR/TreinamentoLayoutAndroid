package viagens.pmz.com.br.viagens.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista_pacotes.*
import viagens.pmz.com.br.viagens.R
import viagens.pmz.com.br.viagens.dao.PacoteDAO
import viagens.pmz.com.br.viagens.model.Pacote
import viagens.pmz.com.br.viagens.ui.adapter.ListaPacotesAdapter

class ListaPacotesActivity : AppCompatActivity() {

    private val tituloAppBar = "Pacotes"
    private val pacotes: List<Pacote> = PacoteDAO().lista()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)
        title = tituloAppBar
        configuraLista()

        val intentResumoPacoteActivity = Intent(this, ResumoPacoteActivity::class.java)
        startActivity(intentResumoPacoteActivity)
    }

    private fun configuraLista() {
        lista_pacotes_listview.adapter = ListaPacotesAdapter(pacotes, this)
    }
}
