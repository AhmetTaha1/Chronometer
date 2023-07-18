package com.ahmettaha.chronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.ahmettaha.chronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        var stopTime:Long=0
        binding.btnStart.setOnClickListener{
            binding.chronometer.base=SystemClock.elapsedRealtime()+stopTime
            binding.chronometer.start()
            binding.btnStart.visibility=View.GONE
            binding.btnPause.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))

        }
        binding.btnPause.setOnClickListener{
            stopTime=binding.chronometer.base-SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.btnPause.visibility=View.GONE
            binding.btnStart.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.btnReset.setOnClickListener{
            binding.chronometer.base=SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            stopTime=0
            binding.btnPause.visibility=View.GONE
            binding.btnStart.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }




        }
}