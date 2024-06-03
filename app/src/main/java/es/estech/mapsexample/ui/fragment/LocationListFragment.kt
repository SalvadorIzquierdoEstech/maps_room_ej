package es.estech.mapsexample.ui.fragment

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import es.estech.mapsexample.data.Location
import es.estech.mapsexample.databinding.FragmentLocationListBinding
import es.estech.mapsexample.ui.adapter.LocationAdapter
import es.estech.mapsexample.ui.view.LocationViewModel

class LocationListFragment : Fragment() {

    private lateinit var binding: FragmentLocationListBinding
    private lateinit var adapter: LocationAdapter
    private val viewModel by activityViewModels<LocationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getLocationList().observe(viewLifecycleOwner){
            configRecycler(it)
        }
    }


    private fun configRecycler(list: List<Location>) {
        val layoutManager = LinearLayoutManager(requireContext())
        adapter = LocationAdapter(
            list,
            LocationViewModel(application = Application()),
            object : LocationAdapter.LocationClick{
                override fun onClick(location: Location) {
                    TODO("Not yet implemented")
                }
            })
        binding.rvLocationLIst.layoutManager = layoutManager
        binding.rvLocationLIst.adapter = adapter
    }


}