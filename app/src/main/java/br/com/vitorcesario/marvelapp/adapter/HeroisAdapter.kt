package br.com.vitorcesario.marvelapp.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.vitorcesario.marvelapp.Herois.Herois
import br.com.vitorcesario.marvelapp.R
import kotlinx.android.synthetic.main.herois_lista.view.*

class JogoAdapter(private val jogos: List<Herois>,
                  private val context: Context,
                  val listener: (Herois) -> Unit) : Adapter<JogoAdapter.ViewHolder>() {
//Método que recebe o ViewHolder e a posição da lista.
//Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = jogos[position]
        holder?.let {
            it.bindView(note, listener)
        }
    }
    //Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.herois_lista, parent, false)
        return ViewHolder(view)
    }
    //Método que deverá retornar quantos itens há na lista.
    override fun getItemCount(): Int {
        return jogos.size
    }
    /*
    Com o ViewHolder iremos relacionar o layout criado e adicionar os valores a ele*/
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(herois: Herois,
                     listener: (Herois) -> Unit) = with(itemView) {
            val ivJogo = ivHeroi
            val tvNome = tvNome
            val tvDescricao = tvDescricao
            ivJogo.setImageDrawable(ContextCompat.getDrawable(context, herois.resourceId))
            tvNome.text = herois.nome
            tvDescricao.text = herois.descricao
            setOnClickListener { listener(herois) }
        }
    }
    interface ClickListener {
        fun onClick(view: View, position: Int)
    }
}
