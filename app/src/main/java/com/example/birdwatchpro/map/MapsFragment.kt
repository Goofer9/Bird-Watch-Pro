package com.example.birdwatchpro.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birdwatchpro.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import androidx.fragment.app.Fragment

class MapsFragment : Fragment() {
    private lateinit var googleMap: GoogleMap

    private fun getPolylineOptions(routePoints: List<LatLng>): PolylineOptions {
        val polylineOptions = PolylineOptions()
        polylineOptions.addAll(routePoints)
        return polylineOptions
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_maps, container, false)
        val mapView = view.findViewById<MapView>(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()

        try {
            activity?.applicationContext?.let { MapsInitializer.initialize(it) }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mapView.getMapAsync { map ->
            googleMap = map

            // Set up your map and other markers here

            // Example values, replace with actual latitude and longitude
            val userLatitude = 37.7749
            val userLongitude = -122.4194
            val hotspotLatitude = 34.0522
            val hotspotLongitude = -118.2437

            val directionsApiUrl = "https://maps.googleapis.com/maps/api/directions/json?" +
                    "origin=${userLatitude},${userLongitude}&" +
                    "destination=${hotspotLatitude},${hotspotLongitude}&" +
                    "key=AIzaSyDRQ49lX43ASzPZdmkABAoQIeGwsS3ntrk"

            // Make a network request to the Directions API and parse the response
            // Replace this comment with actual code for making the network request

            // Assuming routePoints is the decoded polyline from the API response
            val routePoints: List<LatLng> = emptyList() // Replace with actual route points

            // Draw the route on the map
            val polylineOptions = getPolylineOptions(routePoints)
            googleMap.addPolyline(polylineOptions)
        }

        return view
    }
}
