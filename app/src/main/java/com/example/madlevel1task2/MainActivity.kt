package com.example.madlevel1task2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madlevel1task2.ui.theme.MadLevel1Task2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadLevel1Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListScreen()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        },
        content = { ScreenContent() },
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ScreenContent() {


    // Constant to hold the list of touristic places.
    val places = arrayListOf<Place>()
    places.addAll(generatePlaces())


    // ArrayList to hold the reminder data entered by the user.

    Column(
        Modifier
            .fillMaxHeight()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {



        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        )
        {
            items (items = places, itemContent = { item ->
                Text(
                    text = item.placeOfInterest,
                    Modifier.padding(8.dp)
                )
            })
        }






        Row(
            modifier = Modifier
                .weight(1f, false)

        ) {
            OutlinedTextField(
                value = String (),
                // below line is used to add placeholder ("hint") for our text field.
                placeholder = { Text(text = "todo") },
                onValueChange = {

                },
                label = { Text("to do"  ) }
            )
        }
    }
}

private fun generatePlaces(): ArrayList<Place> {
    return arrayListOf(
        Place("Amsterdam", "Dam", R.drawable.amsterdam_dam),
        Place("Amsterdam", "Weesperplein", R.drawable.amsterdam_weesperplein),
        Place("Rotterdam", "Euromast", R.drawable.rotterdam_euromast),
        Place("Den Haag", "Binnenhof", R.drawable.den_haag_binnenhof),
        Place("Utrecht", "Dom", R.drawable.utrecht_dom),
        Place("Groningen", "Martinitoren", R.drawable.groningen_martinitoren),
        Place("Maastricht", "Vrijthof", R.drawable.maastricht_vrijthof),
        Place("New York", "Vrijheidsbeeld", R.drawable.new_york_vrijheidsbeeld),
        Place("San Francisco", "Golden Gate", R.drawable.san_francisco_golden_gate),
        Place("Yellowstone", "Old Faithful", R.drawable.yellowstone_old_faithful),
        Place("Yosemite", "Half Dome", R.drawable.yosemite_half_dome),
        Place("Washington", "White House", R.drawable.washington_white_house),
        Place("Ottawa", "Parliament Hill", R.drawable.ottawa_parliament_hill),
        Place("Londen", "Tower Bridge", R.drawable.london_tower_bridge),
        Place("Brussel", "Manneken Pis", R.drawable.brussel_manneken_pis),
        Place("Berlijn", "Reichstag", R.drawable.berlijn_reichstag),
        Place("Parijs", "Eiffeltoren", R.drawable.parijs_eiffeltoren),
        Place("Barcelona", "Sagrada Familia", R.drawable.barcelona_sagrada_familia),
        Place("Rome", "Colosseum", R.drawable.rome_colosseum),
        Place("Napels", "Pompeii", R.drawable.pompeii),
        Place("Kopenhagen", "", R.drawable.kopenhagen),
        Place("Oslo", "", R.drawable.oslo),
        Place("Stockholm", "", R.drawable.stockholm),
        Place("Helsinki", "", R.drawable.helsinki),
        Place("Moskou", "Rode Plein", R.drawable.moskou_rode_plein),
        Place("Beijing", "Verboden Stad", R.drawable.beijing_verboden_stad),
        Place("Kaapstad", "Tafelberg", R.drawable.kaapstad_tafelberg),
        Place("Rio de Janeiro", "Copacabana", R.drawable.rio_de_janeiro_copacabana),
        Place("Sydney", "Opera", R.drawable.sydney_opera),
        Place("Hawaii", "Honolulu", R.drawable.hawaii),
        Place("Alaska", "Denali", R.drawable.alaska_denali)
    )
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MadLevel1Task2Theme {
     ListScreen()
    }
}