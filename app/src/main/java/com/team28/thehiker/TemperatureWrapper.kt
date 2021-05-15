package com.team28.thehiker

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log

open class TemperatureWrapper(private var sensorManager: SensorManager): SensorEventListener{

    private val temperatureSensor : Sensor?


    init {
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        if (temperatureSensor != null) {
            sensorManager.registerListener(this, temperatureSensor, 1000);
        }
    }

    fun kill(){
        sensorManager.unregisterListener(this)
    }

    open fun isTemperatureSensorAvailable() : Boolean{

        return temperatureSensor != null
    }

    open fun getTemperature() : Double?{
        return null
    }

    override fun onSensorChanged(event: SensorEvent?) {
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}