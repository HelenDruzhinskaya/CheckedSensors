package ru.myitacademy.samsung.checkedsensors

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
 lateinit var sm: SensorManager
 lateinit var list: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sm = (getSystemService(SENSOR_SERVICE) as SensorManager)
    }
@RequiresApi(Build.VERSION_CODES.N)
fun readSensor(view: View) {
    val sensorList = sm.getSensorList(-1)
    var sensorName = ArrayList<String>()
    sensorList.forEach { sensorName.add(it.name) }
    list = findViewById(R.id.sensorlist)
    var adapterName =
        ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, sensorName)
    list.adapter = adapterName
    list.onItemClickListener = AdapterView.OnItemClickListener { adapt, view, index, id ->
        val rSensor = sensorList.get(index)
        var sensor_info = "name: " + rSensor.name +
                "\ntype: " + rSensor.type +
                "\npower: " + rSensor.power +
                "\nversion: " + rSensor.version +
                "\nvendor: " + rSensor.vendor +
                "\nresolution: " + rSensor.resolution +
              "\nDynamic: " + rSensor.isDynamicSensor +
               "\nWakeUp: " + rSensor.isWakeUpSensor
        var intent = Intent(this@MainActivity, SensorInfo::class.java)
        intent.putExtra("sd", sensor_info)
        startActivity(intent)
        //   Toast.makeText(applicationContext,sensor_info,Toast.LENGTH_LONG).show()}
    }
}
}