package com.example.affirmation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Country(
    @StringRes val nameResourceId: Int,
    @StringRes val capitalResourceId: Int,
    @StringRes val codeResourceId: Int,
    @DrawableRes val flagResourceId: Int
)

