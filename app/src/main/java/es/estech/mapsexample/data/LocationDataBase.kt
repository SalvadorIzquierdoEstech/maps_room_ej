package es.estech.mapsexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Location::class], version = 1)
abstract class LocationDataBase :RoomDatabase() {

    abstract fun locationDao(): LocationDAO
    companion object{

        @Volatile
        private var INSTANCE: LocationDataBase? = null
        fun getDatabase(context: Context): LocationDataBase {
            val temporalInstance = INSTANCE
            if (temporalInstance != null) {
                return temporalInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocationDataBase::class.java,
                    "contact_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}