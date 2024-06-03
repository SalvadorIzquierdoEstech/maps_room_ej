package es.estech.mapsexample.data

import androidx.lifecycle.LiveData

class Repository(private val locationDAO: LocationDAO) {

    val locationList:LiveData<List<Location>> = locationDAO.getLocationList()

    suspend fun addLocation(location: Location){
        locationDAO.addLocation(location)
    }
    suspend fun deleteLocation(location: Location){
        locationDAO.deleteLocation(location)
    }
}