package com.example.meteoritelandings.meteorits

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.android.gms.maps.model.LatLng

class MeteoritDefault(
    val name: String,
    //val year: String,
    val reclat: Double,
    val reclong: Double,
){}

@RequiresApi(Build.VERSION_CODES.O)
fun MeteoritDefault.fromJsonToMeteorit(): Meteorit =
    Meteorit (
        name = name,
        latLng = LatLng(reclat,reclong)
        //year = year
        )
