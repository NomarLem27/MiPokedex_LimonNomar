package limon.nomar.composepokedex_LimonNomar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import limon.nomar.composepokedex_LimonNomar.domain.Pokemon
import limon.nomar.composepokedex_LimonNomar.dummy.returnOnePokemon
import limon.nomar.composepokedex_LimonNomar.utilities.getColorType

@Composable
fun PokemonGridItem(
    pokemon: Pokemon,
    onNavigationDetail:(id:Int)->Unit
){

    val colors = getColorType(pokemon)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onNavigationDetail(pokemon.number)
        }
    ) {

        Box {

            Image(
                painter = painterResource(pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.size(100.dp)
            )

            Row(
                modifier = Modifier
                    .size(30.dp)
                    .background(colors.first, shape = RoundedCornerShape(40.dp))
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){

                Text(
                    text = "#${pokemon.number}",
                    color = colors.second,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = pokemon.name,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonGridItemPreview(){
    PokemonGridItem(
        returnOnePokemon(),
        onNavigationDetail = {}
    )
}