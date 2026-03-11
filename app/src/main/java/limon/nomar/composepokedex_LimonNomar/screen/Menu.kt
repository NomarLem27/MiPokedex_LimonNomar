package limon.nomar.composepokedex_LimonNomar.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import limon.nomar.composepokedex_LimonNomar.components.PokemonGridItem
import limon.nomar.composepokedex_LimonNomar.domain.Pokemon
import limon.nomar.composepokedex_LimonNomar.dummy.showAllPokemons


@Composable
fun PokedexMenuScreen(
    pokemonList: List<Pokemon>,
    onNavigationDetail: (id: Int) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 24.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(pokemonList) { pokemon ->

            PokemonGridItem(
                pokemon = pokemon,
                onNavigationDetail = onNavigationDetail
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexMenuScreenPreview() {
    PokedexMenuScreen(
        pokemonList = showAllPokemons(),
        onNavigationDetail = {}
    )
}