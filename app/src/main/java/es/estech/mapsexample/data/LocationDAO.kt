package es.estech.mapsexample.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LocationDAO {

    @Insert
    suspend fun addLocation( vararg location: Location)
    @Delete
    suspend fun deleteLocation( vararg location: Location)
    @Query("SELECT * FROM location_table ORDER BY nombre")
    fun getLocationList(): LiveData<List<Location>>
}