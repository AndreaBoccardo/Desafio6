package cl.desafiolatm.desafio6.util

import androidx.room.TypeConverter
import java.util.*

class FechaConverter {

    @TypeConverter
    fun longToDate(value: Long) : Date? {
        return value.let { Date(it) }
    }

    @TypeConverter
    fun dateToLong(date: Date): Long
    {
        return date.time
    }
}