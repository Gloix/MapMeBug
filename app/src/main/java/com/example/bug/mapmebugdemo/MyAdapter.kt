package com.example.bug.mapmebugdemo

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import nz.co.trademe.mapme.LatLng
import nz.co.trademe.mapme.annotations.AnnotationFactory
import nz.co.trademe.mapme.annotations.MapAnnotation
import nz.co.trademe.mapme.annotations.MarkerAnnotation
import nz.co.trademe.mapme.googlemaps.GoogleMapMeAdapter

/**
 * Created by reneespinoza on 23-03-18.
 */
class MyAdapter(context: Context, val places: MutableList<LatLng>) : GoogleMapMeAdapter(context) {


    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindAnnotation(annotation: MapAnnotation, position: Int, payload: Any?) {
        if (annotation is MarkerAnnotation) {
            annotation.latLng = places[position]
        }
    }

    override fun onCreateAnnotation(factory: AnnotationFactory<GoogleMap>, position: Int, annotationType: Int): MapAnnotation {
        return factory.createMarker(places[position], null, null)
    }

}