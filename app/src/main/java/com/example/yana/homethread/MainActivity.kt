package com.example.yana.homethread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTime = findViewById<EditText>(R.id.etTime)
        val tvTime = findViewById<TextView>(R.id.tvTime)
        val btnTime = findViewById<Button>(R.id.btnTime)


        btnTime.setOnClickListener {

            val namber = etTime.text.toString().toLong()

            object : CountDownTimer(namber * 1000,1000){
                override fun onTick(millisUntilFinished: Long) {
                    val sdf = SimpleDateFormat("mm:ss", Locale.getDefault())
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = millisUntilFinished
                    tvTime.text = sdf.format(calendar.time)
                }

                override fun onFinish() {
                    tvTime.text = "Finish"
                }

            }.start()

        }

    }
}