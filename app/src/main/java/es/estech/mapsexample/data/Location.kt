package es.estech.mapsexample.data

import androidx.room.Entity
@Entity(tableName = "location_table", primaryKeys = ["latitude", "altitude"])
data class Location (
    val nombre:String,
    val latitude:Double,
    val altitude:Double,
    val visitada:Boolean,
    val descripcion:String,
    val valoracion: Int
)