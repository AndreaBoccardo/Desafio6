package cl.desafiolatm.desafio6.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.desafiolatm.desafio6.dao.TareaDao
import cl.desafiolatm.desafio6.modelo.Tarea
import cl.desafiolatm.desafio6.util.FechaConverter

@Database(entities = [Tarea::class], version = 1)
@TypeConverters(FechaConverter::class)
abstract class ProyectoDatabase: RoomDatabase() {

    abstract fun tareaDao(): TareaDao

    companion object{
        @Volatile
        private var instancia: ProyectoDatabase? = null

        fun getInstancia(contexto: Context) : ProyectoDatabase
        {
            if(instancia == null)
            {
                synchronized(this)
                {
                    instancia = Room.databaseBuilder(contexto,
                        ProyectoDatabase::class.java,
                        "proyecto_db").build()
                }
            }
            return instancia!!
        }
    }
}