package es.estech.mapsexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.estech.mapsexample.data.Location
import es.estech.mapsexample.databinding.HolderLocationListBinding
import es.estech.mapsexample.ui.view.LocationViewModel

class LocationAdapter(
    private val locationList: List<Location>,
    private val viewModel: LocationViewModel,
    private val listener: LocationClick
):RecyclerView.Adapter<LocationAdapter.LocationHolder>() {

    interface LocationClick{
        fun onClick(location: Location)
    }

    inner class  LocationHolder(val binding: HolderLocationListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderLocationListBinding.inflate(layoutInflater,parent,false)
        return LocationHolder(binding)
    }

    override fun getItemCount(): Int {
        return locationList.size
    }


    override fun onBindViewHolder(holder:LocationHolder, position: Int) {
        val locale = locationList[position]

        holder.binding.textViewNombre.text = locale.nombre

        holder.binding.textViewRating.text = "${locale.valoracion}/10"

        holder.binding.floatingActionButton.setOnClickListener {
            viewModel.deleteLocation(locale)
        }
    }



}