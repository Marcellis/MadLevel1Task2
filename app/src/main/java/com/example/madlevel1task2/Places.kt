package com.example.madlevel1task2

import androidx.annotation.DrawableRes

data class Place(
    val cityName: String,
    val placeOfInterest: String,
    @DrawableRes val imageResId: Int
)
