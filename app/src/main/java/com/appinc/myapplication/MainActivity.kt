package com.appinc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.CircleOptions
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.MarkerOptions
import com.huawei.hms.maps.model.PolygonOptions
import com.huawei.hms.maps.model.PolylineOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapView = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapView.getMapAsync { map ->
            // Configura el estilo del mapa
            /*val style = MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style)
            map.setMapStyle(style)*/

            // Configura los controles del mapa
            map.uiSettings.isZoomControlsEnabled = true
            map.uiSettings.isMyLocationButtonEnabled = true

            val position = LatLng(51.5074, -0.1278)
            val markerOptions = MarkerOptions().position(position).title("London")
            map.addMarker(markerOptions)

            val lineOptions = PolylineOptions().add(position, LatLng(48.8566, 2.3522))
            map.addPolyline(lineOptions)

            val circleOptions = CircleOptions().center(position).radius(10000.0)
            map.addCircle(circleOptions)

            val polygonOptions = PolygonOptions().add(
                LatLng(40.748817, -73.985428),
                LatLng(40.748817, -73.985428),
                LatLng(40.748817, -73.985428),
                LatLng(40.748817, -73.985428)
            )
            map.addPolygon(polygonOptions)
        }
    }
}