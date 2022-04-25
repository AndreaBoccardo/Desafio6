package cl.desafiolatm.desafio6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.desafiolatm.desafio6.modelo.Tarea
import cl.desafiolatm.desafio6.repository.TareaRepository
import java.text.SimpleDateFormat

class TareaViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = TareaRepository(application.applicationContext)
    val lista: LiveData<List<Tarea>> = repo.listar()
    val tareaMutable = MutableLiveData<Tarea>()

    fun agregar(tarea : String, fecha : String){
        val  sdf = SimpleDateFormat("dd/MM/yyyy").parse(fecha)
        val t = Tarea(tarea, sdf)
        repo.agregar(t)
    }

    fun eliminar(tarea: Tarea){
        repo.eliminar(tarea)
    }

    fun editar(id:Int ,tarea: String, fecha: String){
        val  sdf = SimpleDateFormat("dd/MM/yyyy").parse(fecha)
        val t = Tarea(tarea, sdf)
        t.id = id
        repo.editar(t)
    }
}