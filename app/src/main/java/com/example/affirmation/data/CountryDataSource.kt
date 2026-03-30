package com.example.affirmation.data

import com.example.affirmation.R
import com.example.affirmation.model.Country

class CountryDataSource {

    fun loadCountries(): List<Country> = listOf(
        Country(R.string.country_name_1, R.string.country_capital_1, R.string.country_code_1, R.string.country_description_1, R.drawable.country_flag_1),
        Country(R.string.country_name_2, R.string.country_capital_2, R.string.country_code_2, R.string.country_description_2, R.drawable.country_flag_2),
        Country(R.string.country_name_3, R.string.country_capital_3, R.string.country_code_3, R.string.country_description_3, R.drawable.country_flag_3),
        Country(R.string.country_name_4, R.string.country_capital_4, R.string.country_code_4, R.string.country_description_4, R.drawable.country_flag_4),
        Country(R.string.country_name_5, R.string.country_capital_5, R.string.country_code_5, R.string.country_description_5, R.drawable.country_flag_5),
        Country(R.string.country_name_6, R.string.country_capital_6, R.string.country_code_6, R.string.country_description_6, R.drawable.country_flag_6),
        Country(R.string.country_name_7, R.string.country_capital_7, R.string.country_code_7, R.string.country_description_7, R.drawable.country_flag_7),
        Country(R.string.country_name_8, R.string.country_capital_8, R.string.country_code_8, R.string.country_description_8, R.drawable.country_flag_8),
        Country(R.string.country_name_9, R.string.country_capital_9, R.string.country_code_9, R.string.country_description_9, R.drawable.country_flag_9),
        Country(R.string.country_name_10, R.string.country_capital_10, R.string.country_code_10, R.string.country_description_10, R.drawable.country_flag_10)
    )
}
