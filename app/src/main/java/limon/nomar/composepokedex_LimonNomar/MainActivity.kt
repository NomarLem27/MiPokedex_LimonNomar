package limon.nomar.composepokedex_LimonNomar

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import components.Ability
import components.Chip
import components.PokemonNeighbor
import domain.Pokemon
import limon.nomar.composepokedex_LimonNomar.ui.theme.ComposePokedexTheme
import limon.nomar.composepokedex_LimonNomar.ui.theme.ElectricYellow
import limon.nomar.composepokedex_LimonNomar.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                ComposePokedexApp()
            }
        }
    }
}
val pokemon = Pokemon(
    "Pikachu",
    25,
    "Electrico",
    "Que lo que, si te acerca te muerde y te electrocuta el pelo",
    0.4f,
    6f,
    true,
    "Electricidad",
    R.drawable.pikachu
)

@Composable
fun PokemonHeader(name: String, number: Int, fav: Boolean){
    Row(Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Column(){
            Text(name)
            Text("#${number}", modifier = Modifier.align(Alignment.End))
        }
        Box{
            Image(painter = painterResource(R.drawable.pokeball),
                contentDescription = "pokeball image", contentScale = ContentScale.Fit,
                modifier = Modifier.size(130.dp).offset(40.dp, 30.dp)
            )
            Image(painter = painterResource(if (fav)R.drawable.star_filled else R.drawable.star_outline),
                contentDescription = if (fav)"yellow star filled" else "yellow star outline",
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
fun PokemonCard(
    name: String,
    weight: Float,
    height: Float,
    description: String,
    ability: String,
    type: String,
    image: Int
) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(image),
            contentDescription = name,
            Modifier.offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )
        Card(
            Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column(Modifier.fillMaxWidth()) {
                Chip(type, ElectricYellow, Modifier.padding(top = 70.dp).align(Alignment.CenterHorizontally))

                Row(
                    modifier = Modifier.fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column {
                        Ability("row", label = "Altura", "${height}m")
                        Ability("row", label = "Peso", "${weight}kg")
                    }
                    Ability("column", label = "Habilidad", value = ability)
                }

                Row(
                    Modifier.fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(25.dp)
                ) {
                    Text(description)
                }


                // 🔽 Bloque actualizado: Pokémon anterior y siguiente 🔽
                Spacer(modifier = Modifier.weight(1f)) // empuja hacia abajo el contenido
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp, top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PokemonNeighbor(
                        position = "left",
                        image = R.drawable.arbok,
                        name = "Arbok",
                        number = 24
                    )
                    PokemonNeighbor(
                        position = "right",
                        image = R.drawable.raichu,
                        name = "Raichu",
                        number = 26
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview(){
    ComposePokedexTheme(){
        PokemonHeader(name = "pikachu", number = 25, fav = true)
    }
}

@PreviewScreenSizes
@Composable
fun ComposePokedexApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                pokemon,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.AccountBox),
}

@Composable
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(Modifier.background(ElectricYellow, RectangleShape)){
        PokemonHeader(pokemon.name,pokemon.number,pokemon.fav)
        PokemonCard(
            name = pokemon.name,
            weight = pokemon.weight,
            height = pokemon.height,
            description = pokemon.description,
            ability = pokemon.ability,
            type = pokemon.type,
            image = pokemon.image
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePokedexTheme {
        Greeting(Pokemon("Pikachu",
            25, "Electrico",
            "Que lo que, si te acelca te muelde y te electrocuta el pelo",
            0.4f,
            6f, true, "Electricidad", R.drawable.pikachu))
    }
}