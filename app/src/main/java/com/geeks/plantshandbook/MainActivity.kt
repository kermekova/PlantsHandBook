package com.geeks.plantshandbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.geeks.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()

    private val plantsNameMap = mapOf(
        R.drawable.plant1 to "Bamboo",
        R.drawable.plant2 to "Cactus",
        R.drawable.plant3 to "Eucaliptus",
        R.drawable.plant4 to "Fiddle-Leaf Fig",
        R.drawable.plant5 to "Orchid",)

    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,)

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        }

    private fun init(){
        binding.apply {
            rvName.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rvName.adapter = adapter
            btnAdd.setOnClickListener{
                if(index > 4) index = 0
                val imageId = imageIdList[index]
                val plantName = plantsNameMap[imageId] ?: "Unknown Plant"
                val plant = Plant(imageId, plantName)
                adapter.addPlant(plant)
                index++
            }
        }
    }
}