package viagens.pmz.com.br.viagens.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.content.res.AppCompatResources.getDrawable

class ResourceUtil {

    companion object {
        private const val drawable = "drawable"
        fun devolveDrawable(context: Context, nomeImagem: String): Drawable? {
            val resources = context.resources
            val idDoDrawable = resources.getIdentifier(nomeImagem, drawable, context.packageName)
            return getDrawable(context, idDoDrawable)
        }
    }


}