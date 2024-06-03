package es.estech.mapsexample.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import es.estech.mapsexample.R
import es.estech.mapsexample.data.Location
import es.estech.mapsexample.databinding.FragmentMapBinding
import es.estech.mapsexample.ui.view.LocationViewModel


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private lateinit var mapa: GoogleMap
    private val viewModel by activityViewModels<LocationViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentMapBinding.inflate(inflater, container, false)

        val fragmentMap =childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        fragmentMap.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(map: GoogleMap) {
        mapa = map
//        binding.button.setOnClickListener {
//            accionesUnPermiso()
//        }
//
//        binding.button2.setOnClickListener {
//            accionesVariosPermisos()
//        }

        /* TIPO DE MAPA */
        map.mapType = GoogleMap.MAP_TYPE_NORMAL
//        GoogleMap.MAP_TYPE_NONE
//        GoogleMap.MAP_TYPE_NORMAL
//        GoogleMap.MAP_TYPE_SATELLITE
//        GoogleMap.MAP_TYPE_TERRAIN

        map.isTrafficEnabled = false  //trafico activado



        val uiSettings = map.uiSettings
        uiSettings.isZoomControlsEnabled = true //controles de zoom

        uiSettings.isCompassEnabled = true //mostrar la brújula

        uiSettings.isZoomGesturesEnabled = true //gestos de zoom

        uiSettings.isScrollGesturesEnabled = true //Gestos de scroll

        uiSettings.isTiltGesturesEnabled = true //Gestos de ángulo

        uiSettings.isRotateGesturesEnabled = true //Gestos de rotación


        map.setOnMapClickListener {location ->
            val latitud = location.latitude
            val longitud = location.longitude
            addLocationAlertDialog(location.latitude, location.longitude)



        }


        //todo asignar max y min zoom al mapa (3 a 22)
//        map.setMinZoomPreference(6.0f)
//        map.setMaxZoomPreference(14.0f)

        //todo Mover cámara
        val latLng = LatLng(38.38, -3.78)  //LatLng es latitud y longitud en double
        val cu = CameraUpdateFactory.newLatLng(latLng)
        val cuZoom = CameraUpdateFactory.newLatLngZoom(
            latLng,
            8f
        ) //float determina el nivel de zoom, siendo 1 el más lejano

        //todo mueve la cámara a una ubicación
        //map.moveCamera(cuZoom)

        //todo mover cámara cuando el mapa esté cargado
//        map.setOnMapLoadedCallback {
//            map.animateCamera(cuZoom)
//        }

        //todo mover cámara con animación
//        binding.fabRefresh.setOnClickListener {
//            val madrid = CameraUpdateFactory.newLatLngZoom(
//                LatLng(40.42062134847416, -3.7042661462520288),
//                7f
//            )
//            map.animateCamera(madrid)
//        }

        //todo zoom maximo
//        binding.fabZoom.setOnClickListener {
//            val maxZoom = CameraUpdateFactory.zoomTo(20f)
//            map.animateCamera(maxZoom)
//        }

        //todo centrar mapa en un área
//        val australia = LatLngBounds(
//            LatLng(-40.069652872281544, 110.99998935230147),
//            LatLng(-12.929600324985966, 155.64842237872773)
//        )
//
//        map.moveCamera(CameraUpdateFactory.newLatLngBounds(australia, 20))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(australia.center, 3f))

        //todo listener para esperar que el mapa esté cargado
//        map.setOnMapLoadedCallback {
//            map.animateCamera(
//                CameraUpdateFactory.newLatLngBounds(australia, 20)
//            )
//        }


        //todo listener al pulsar un punto de interés
//        map.setOnPoiClickListener { pointOfInterest ->
//
//            Toast.makeText(
//                this@MainActivity,
//                "Nombre del sitio: " + pointOfInterest.name,
//                Toast.LENGTH_SHORT
//            ).show()
//            val ubicacion = pointOfInterest.latLng
//            map.animateCamera(CameraUpdateFactory.newLatLng(ubicacion))
//        }

        // todo añadir marker
//        val options1 = MarkerOptions()
//            .position(LatLng(38.5, -3.3))
//            .title("Sitio")
//            .snippet("Pulsa aquí para acceder")
//            .alpha(.6f)
//            .rotation(90f)
//        val marker1 = map.addMarker(options1)
//
//        val options2 = MarkerOptions()
//            .position(LatLng(38.09418604624217, -3.6312538))
//            .title("Sitio2")
//            .snippet("Pulsa aquí para acceder")
//            .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker))
//        val marker2 = map.addMarker(options2)
//
//        val options3 = MarkerOptions()
//            .position(LatLng(39.5, -2.3))
//            .title("Sitio3")
//            .snippet("Pulsa aquí para acceder")
//            .flat(true)
//        val marker3 = map.addMarker(options3)
//
//        val options4 = MarkerOptions()
//            .position(LatLng(37.5, -4.3))
//            .title("Sitio4")
//            .snippet("Pulsa aquí para acceder")
//            .flat(true)
//            .draggable(true)
//            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
//        val marker4 = map.addMarker(options4)
//        marker4?.tag = "mimarker"
//
//        map.setOnMapClickListener {
//            map.clear()
//            val options = MarkerOptions().position(it)
//            map.addMarker(options)
//        }

        //todo listener draggable para arrastrar y solar marker
//        map.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {
//            override fun onMarkerDrag(p0: Marker) {
//            }
//
//            override fun onMarkerDragEnd(marker: Marker) {
//                if (marker.tag == "mimarker") {
//                    val latLng1 = marker.position
//                    val latitud = latLng1.latitude
//                    val longitud = latLng1.longitude
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Latitud: $latitud, Longitud: $longitud",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//
//            override fun onMarkerDragStart(p0: Marker) {
//            }
//        })

        //todo click en el marker
//        map.setOnMarkerClickListener { marker ->
//            if (marker == marker2) {
//                Toast.makeText(this@MainActivity, "Escuela Estech", Toast.LENGTH_SHORT).show()
//            }
//            false
//        }

        //todo click en cartel del marker
//        map.setOnInfoWindowClickListener { marker ->
//            if (marker == marker2) {
//                val i = Intent(Intent.ACTION_VIEW)
//                i.data = Uri.parse("https://escuelaestech.es")
//                startActivity(i)
//            }
//        }

        // todo eliminar marker
//        map.setOnMarkerClickListener {
//            if (it == marker2) {
//                marker2.remove()
//                true
//            }
//            false
//        }

        //todo crear Custom Window
//        map.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
//            override fun getInfoContents(p0: Marker): View {
//                val binding = CustomWindowInfoBinding.inflate(layoutInflater)
//                return binding.root
//            }
//
//            override fun getInfoWindow(p0: Marker): View? {
//                return null
//            }
//
//        })

        //todo crear Polyline
//        var rectOptions = PolylineOptions()
//            .color(Color.RED)
//            .width(10f)
//            .clickable(true)
//            .add(LatLng(38.096821, -3.627834)) //1er punto
//            .add(LatLng(38.096855, -3.627126)) //este
//            .add(LatLng(38.097779, -3.627174)) //norte
//            .add(LatLng(38.097760, -3.627908)) //oeste
//            .add(LatLng(38.097496, -3.628524)) //suroeste
//
//        val campoFutbol = map.addPolyline(rectOptions)
//
//        rectOptions = PolylineOptions()
//            .color(Color.YELLOW)
//            .width(10f)
//            .clickable(true)
//            .add(LatLng(38.096821, -3.627834)) //init point
//            .add(LatLng(38.09745732808713, -3.6278839818218995))
//
//        map.addPolyline(rectOptions)


        //todo crear Polygon
//        val options = PolygonOptions().strokeColor(Color.RED)
//            .strokeWidth(20f)
//            .fillColor(ContextCompat.getColor(this, R.color.semiTransparent))
//            .zIndex(10f)
//            .clickable(true)
//            .add(LatLng(43.75341412588365, -9.593843256556998)) //1er punto
//            .add(LatLng(42.986742508776935, 3.5018585563121136)) // Hacia al este
//            .add(LatLng(36.401581867949574, 0.8211947624026644)) // Hacia el norte
//            .add(LatLng(36.860036902084985, -10.560640034688271)) // Hacia el oeste
//
//        val spainLine: Polygon = map.addPolygon(options)


        // todo  crear circle
//        val circleOptions = CircleOptions()
//            .center(LatLng(38.93515236530402, -100.83512605947585))
//            .radius(2000000.0)
//            .strokeColor(Color.BLUE)
//            .strokeWidth(10f)
//            .clickable(true)
//            .fillColor(ContextCompat.getColor(this, R.color.semiTransparent))
//        val circleUsa: Circle = map.addCircle(circleOptions)

        //todo  click sobre las formas
//        map.setOnPolylineClickListener { polyline ->
//            if (polyline == campoFutbol) {
//                Toast.makeText(this@MainActivity, "Dar vueltas al campo", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        map.setOnPolygonClickListener { polygon ->
//            if (polygon == spainLine)
//                Toast.makeText(this@MainActivity, "España incomunicada", Toast.LENGTH_SHORT).show()
//
//        }
//
//        map.setOnCircleClickListener { circle ->
//            if (circle == circleUsa) {
//                val builder = AlertDialog.Builder(this@MainActivity)
//                builder.setMessage("Disparar misil?")
//                builder.setPositiveButton(
//                    "SI"
//                ) { dialog, which ->
//                    circleUsa.remove()
//                    val mCircleOptions = CircleOptions()
//                        .center(LatLng(38.93515236530402, -100.83512605947585))
//                        .radius(2000000.0)
//                        .strokeColor(Color.BLUE)
//                        .fillColor(Color.BLUE)
//                        .strokeWidth(10f)
//                    map.addCircle(mCircleOptions)
//                }
//                builder.setNegativeButton(
//                    "NO"
//                ) { dialog, which ->
//                    circleUsa.remove()
//                }
//                builder.create().show()
//            }
//        }
    }

    private fun addLocationAlertDialog(latitud:Double, altitud:Double){
        val builder = android.app.AlertDialog.Builder(requireContext())
        val view = layoutInflater.inflate(R.layout.alert_dialog_add_locale, null)
        builder.setView(view)

        val dialog = builder.create()
        dialog.window?.setDimAmount(0.7f)
        dialog.show()

        view.findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            val nombre = view.findViewById<EditText>(R.id.etLocaleName).text.toString()
            val description = view.findViewById<EditText>(R.id.etDesc).text.toString()
            val rating = view.findViewById<EditText>(R.id.etRating).text.toString().toInt()
            val visitado = view.findViewById<RadioButton>(R.id.radioButtonVisited).isChecked

            val locale = Location(nombre, latitud, altitud,visitado,description,rating)

            viewModel.addLocation(locale)
            dialog.dismiss()

        }

        builder.show()
    }

}