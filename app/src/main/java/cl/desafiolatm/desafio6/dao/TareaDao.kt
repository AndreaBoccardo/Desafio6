package cl.desafiolatm.desafio6.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.desafiolatm.desafio6.modelo.Tarea

@Dao
interface TareaDao {

    @Insert
    fun agregar(tarea: Tarea)

    @Delete
    fun eliminar(tarea: Tarea)

    @Update
    fun editar(tarea: Tarea)

    @Query("select id, tarea, fecha from tarea_table")
    fun listar(): LiveData<List<Tarea>>
}