package cl.desafiolatm.desafio6.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tarea_table")
data class Tarea(
    @ColumnInfo (name = "tarea")
    var tarea:String,
    @ColumnInfo(name = "fecha")
    var fecha: Date
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}