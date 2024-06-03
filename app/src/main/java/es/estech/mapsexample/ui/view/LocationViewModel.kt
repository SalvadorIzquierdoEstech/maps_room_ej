package es.estech.mapsexample.ui.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import es.estech.mapsexample.data.Location
import es.estech.mapsexample.data.LocationDataBase
import es.estech.mapsexample.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationViewModel(application: Application): AndroidViewModel(application) {

    private val locationList:LiveData<List<Location>>
    private val repository: Repository

    init {
        val localDao = LocationDataBase.getDatabase(application).locationDao()
        repository = Repository(localDao)
        locationList = repository.locationList
    }


    fun getLocationList() = locationList

    fun deleteLocation(location: Location){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteLocation(location)
        }
    }

    fun addLocation(location: Location){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addLocation(location)
        }
    }

}