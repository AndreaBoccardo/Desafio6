package cl.desafiolatm.desafio6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatm.desafio6.R
import cl.desafiolatm.desafio6.databinding.ItemLayoutBinding
import cl.desafiolatm.desafio6.modelo.Tarea

class TareaAdapter : RecyclerView.Adapter<TareaAdapter.CustomViewHolder>() {

    private var lista : List<Tarea> = ArrayList()
    lateinit var listener:MiOnClickListener

    class CustomViewHolder(itemView : View, var listener: MiOnClickListener) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(tarea: Tarea){
            with(binding){
                tvTarea.text = tarea.tarea
                itemView.setOnClickListener{
                    listener.onClickListener(tarea)
                }
                btnEliminar.setOnClickListener{
                    listener.onDeleteListener(tarea)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateData(lista:List<Tarea>){
        this.lista = lista
        notifyDataSetChanged()
    }

    interface MiOnClickListener{
        fun onClickListener(tarea: Tarea)
        fun onDeleteListener(tarea: Tarea)
    }

    fun setOnClickListener(listener: MiOnClickListener)
    {
        this.listener = listener
    }
}