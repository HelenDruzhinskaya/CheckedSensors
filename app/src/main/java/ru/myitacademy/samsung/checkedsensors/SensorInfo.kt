package ru.myitacademy.samsung.checkedsensors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SensorInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_info)
        val intent = getIntent()
        (findViewById<TextView>(R.id.info)).text = intent.getStringExtra("sd")
    }
}