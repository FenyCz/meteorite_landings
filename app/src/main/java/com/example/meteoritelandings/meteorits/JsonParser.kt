package com.example.meteoritelandings.meteorits
import com.google.gson.Gson

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.meteoritelandings.R
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader

class JsonParser(private val context: Context) {

    private val gson = Gson()

    private val stream: InputStream
        get() = context.resources.openRawResource(R.raw.meteorits)

    @RequiresApi(Build.VERSION_CODES.O)
    fun transform(): List<Meteorit> {
        val itemType = object : TypeToken<List<MeteoritDefault>>() {}.type
        val inputJson = InputStreamReader(stream)
            return gson.fromJson<List<MeteoritDefault>>(inputJson, itemType).map {
                it.fromJsonToMeteorit()}
    }

}