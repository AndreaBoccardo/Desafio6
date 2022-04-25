package cl.desafiolatm.desafio6.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.desafiolatm.desafio6.modelo.Tarea
import cl.desafiolatm.desafio6.room.ProyectoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TareaRepository(var context: Context) {

    private val db = ProyectoDatabase.getInstancia(context)

    fun agregar(tarea: Tarea){
        CoroutineScope(Dispatchers.IO).launch {
            db.tareaDao().agregar(tarea)
        }
    }

    fun eliminar(tarea: Tarea){
        CoroutineScope(Dispatchers.IO).launch {
            db.tareaDao().eliminar(tarea)
        }
    }

    fun editar(tarea: Tarea){
        CoroutineScope(Dispatchers.IO).launch {
            db.tareaDao().editar(tarea)
        }
    }

    fun listar() : LiveData<List<Tarea>>{
        return db.tareaDao().listar()
    }
}