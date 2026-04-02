package com.example.affirmation.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.affirmation.R
import com.example.affirmation.data.CountryDataSource
import com.example.affirmation.model.Country

@Composable
fun CountryListScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
        ) {
            Text(text = "Retour")
        }
        LazyColumn(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        ) {
            items(CountryDataSource().loadCountries()) { country ->
                CountryItem(country = country)
            }
        }
    }
}

@Composable
fun CountryItem(country: Country, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier.padding(dimensionResource(R.dimen.padding_small))) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
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
                Column(modifier = Modifier.weight(1f)) {
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
                CountryItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded) {
                Text(
                    text = stringResource(country.descriptionResourceId),
                    fontSize = dimensionResource(R.dimen.text_size_body).value.sp,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

/**
 * Composant qui affiche le bouton pour étendre ou réduire les informations.
 */
@Composable
private fun CountryItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}
