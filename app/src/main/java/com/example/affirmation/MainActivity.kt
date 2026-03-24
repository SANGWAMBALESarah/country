package com.example.affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.affirmation.data.CountryDataSource
import com.example.affirmation.model.Country
import com.example.affirmation.ui.theme.AffirmationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountryListApp()
                }
            }
        }
    }
}

@Composable
fun CountryListApp() {
    CountryList(countryList = CountryDataSource().loadCountries())
}

@Composable
fun CountryList(countryList: List<Country>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(countryList) { country ->
            CountryItem(country)
        }
    }
}



@Composable
fun CountryItem(country: Country, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(dimensionResource(R.dimen.padding_small))) {
        Row {
            Box {
                Image(
                    painter = painterResource(country.flagResourceId),
                    contentDescription = stringResource(country.nameResourceId),
                    modifier = Modifier
                        .size(width = dimensionResource(R.dimen.image_size), height = dimensionResource(R.dimen.image_size))
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = stringResource(country.nameResourceId),
                    fontSize = dimensionResource(R.dimen.text_size_title).value.sp,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                )
                Row {
                    Text(
                        text = stringResource(country.capitalResourceId),
                        fontSize = dimensionResource(R.dimen.text_size_body).value.sp,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium))
                    )
                    Text(
                        text = " • " + stringResource(country.codeResourceId),
                        fontSize = dimensionResource(R.dimen.text_size_body).value.sp,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCountryList() {
    AffirmationTheme {
        CountryListApp()
    }
}
