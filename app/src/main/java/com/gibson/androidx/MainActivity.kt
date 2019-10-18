package com.gibson.androidx

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = map_fragment as SupportMapFragment
        mapFragment.getMapAsync(this)

//        drawer_layout.openDrawer(Gravity.LEFT, true)
        menu_view.setOnClickListener {
            drawer_layout.openDrawer(Gravity.LEFT, true)
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap.also {
            val seoul = LatLng(37.566, 126.9784)
            it.moveCamera(CameraUpdateFactory.newLatLng(seoul))
            it.setMinZoomPreference(12f)
        }
    }

}
