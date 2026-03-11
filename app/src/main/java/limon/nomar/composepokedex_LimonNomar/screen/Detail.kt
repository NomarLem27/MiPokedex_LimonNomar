package limon.nomar.composepokedex_LimonNomar.screen

import androidx.wear.compose.material.Chip
import limon.nomar.composepokedex_LimonNomar.domain.Pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import limon.nomar.composepokedex_LimonNomar.components.Ability
import limon.nomar.composepokedex_LimonNomar.components.Chip
import limon.nomar.composepokedex_LimonNomar.dummy.getPokemon
import limon.nomar.composepokedex_LimonNomar.ui.theme.ComposePokedex_LimonNomarTheme
import limon.nomar.composepokedex_LimonNomar.components.PokemonNavButton
import limon.nomar.composepokedex_LimonNomar.components.PokemonHeader
import limon.nomar.composepokedex_LimonNomar.ui.theme.ElectricYellow
import limon.nomar.composepokedex_LimonNomar.ui.theme.Red
import limon.nomar.composepokedex_LimonNomar.ui.theme.White
import limon.nomar.composepokedex_LimonNomar.utilities.getColorType


@Composable
fun PokemonCard(
    pokemon: Pokemon,
    onNavigate: (Int) -> Unit
) {

    Box(contentAlignment = Alignment.TopCenter) {

        Image(
            painter = painterResource(pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(
                topStart = 25.dp,
                topEnd = 25.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White),
                contentPadding = PaddingValues(bottom = 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {

                    Chip(
                        pokemon.type,
                        ElectricYellow,
                        Modifier.padding(top = 70.dp)
                    )
                }

                item {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Column {

                            Ability("row", "Altura", "${pokemon.height} m")
                            Ability("row", "Peso", "${pokemon.weight} kg")
                        }

                        Ability(
                            "column",
                            "Habilidad",
                            pokemon.ability
                        )
                    }
                }

                item {

                    Text(
                        pokemon.description,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(25.dp)
                    )
                }

                if (pokemon.evolutions.isNotEmpty()) {

                    item {

                        Text(
                            text = "Evoluciones",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Red,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }

                    items(pokemon.evolutions) { evo ->
                        EvolutionItem(evo, onNavigate)
                    }
                }
            }
        }
    }
}


@Composable
fun EvolutionItem(
    evo: Pokemon,
    onNavigate: (Int) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onNavigate(evo.number) }
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(evo.image),
            contentDescription = evo.name,
            modifier = Modifier.size(56.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = evo.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = "#${evo.number.toString().padStart(4, '0')}",
            fontSize = 12.sp,
            color = Red
        )
    }
}


@Composable
fun PokemonBottomNavigation(
    prevPokemon: Pokemon?,
    nextPokemon: Pokemon?,
    onNavigate: (Int) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        prevPokemon?.let {

            Box(
                modifier = Modifier.clickable {
                    onNavigate(it.number)
                }
            ) {

                PokemonNavButton(
                    position = "left",
                    image = it.image,
                    name = it.name,
                    number = it.number
                )
            }

        } ?: Spacer(Modifier.width(1.dp))

        nextPokemon?.let {

            Box(
                modifier = Modifier.clickable {
                    onNavigate(it.number)
                }
            ) {

                PokemonNavButton(
                    position = "right",
                    image = it.image,
                    name = it.name,
                    number = it.number
                )
            }

        } ?: Spacer(Modifier.width(1.dp))
    }
}


@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    prevPokemon: Pokemon? = null,
    nextPokemon: Pokemon? = null,
    onNavigate: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    val colors = getColorType(pokemon)

    Scaffold(

        containerColor = colors.first,

        bottomBar = {

            PokemonBottomNavigation(
                prevPokemon = prevPokemon,
                nextPokemon = nextPokemon,
                onNavigate = onNavigate
            )
        }

    ) { padding ->

        Column(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            PokemonHeader(
                pokemon.name,
                pokemon.number,
                pokemon.fav
            )

            Box(
                modifier = Modifier.weight(1f)
            ) {
                PokemonCard(
                    pokemon = pokemon,
                    onNavigate = onNavigate
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PokemonDetailScreenPreview() {

    ComposePokedex_LimonNomarTheme {

        val bulbasaur = getPokemon(1)
            ?: return@ComposePokedex_LimonNomarTheme

        PokemonDetailScreen(
            pokemon = bulbasaur,
            prevPokemon = null,
            nextPokemon = getPokemon(4),
            onNavigate = {}
        )
    }
}