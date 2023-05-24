package com.example.glidetest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.glidetest.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var imageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root)}

        imageUrl = savedInstanceState?.getString(KEY_IMAGE_URL) ?: imagesList[Random.nextInt(imagesList.size)]

        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageView)
    }

    companion object {
        const val KEY_IMAGE_URL = "KEY_IMAGE_URL"

        val imagesList:List<String> = listOf(
            "https://www.neizvestniy-geniy.ru/images/works/photo/2015/09/1471901_1.jpg",
            "https://get.wallhere.com/photo/William-Adolphe-Bouguereau-Dante-Alighieri-painting-Dante's-Inferno-The-Divine-Comedy-oil-painting-1676331.jpg"
        )
    }
}