package limon.nomar.composepokedex_LimonNomar.utilities



import androidx.compose.ui.graphics.Color
import limon.nomar.composepokedex_LimonNomar.domain.Pokemon
import limon.nomar.composepokedex_LimonNomar.ui.theme.Bug
import limon.nomar.composepokedex_LimonNomar.ui.theme.DarkGray
import limon.nomar.composepokedex_LimonNomar.ui.theme.Dragon
import limon.nomar.composepokedex_LimonNomar.ui.theme.Electric
import limon.nomar.composepokedex_LimonNomar.ui.theme.Fairy
import limon.nomar.composepokedex_LimonNomar.ui.theme.Fight
import limon.nomar.composepokedex_LimonNomar.ui.theme.Fire
import limon.nomar.composepokedex_LimonNomar.ui.theme.Flying
import limon.nomar.composepokedex_LimonNomar.ui.theme.Ghost
import limon.nomar.composepokedex_LimonNomar.ui.theme.Grass
import limon.nomar.composepokedex_LimonNomar.ui.theme.Ground
import limon.nomar.composepokedex_LimonNomar.ui.theme.Normal
import limon.nomar.composepokedex_LimonNomar.ui.theme.OffWhite
import limon.nomar.composepokedex_LimonNomar.ui.theme.Poison
import limon.nomar.composepokedex_LimonNomar.ui.theme.Psych
import limon.nomar.composepokedex_LimonNomar.ui.theme.Rock
import limon.nomar.composepokedex_LimonNomar.ui.theme.Water


fun getColorType(pokemon: Pokemon): Pair<Color, Color> {

    val type = pokemon.type.split("/")[0]

    var color: Color = Normal
    var dark = true
    when(type){

        "normal" -> color = Normal

        "electric" -> {
            color = Electric
            dark = false
        }

        "water" -> color = Water

        "fire" -> color = Fire

        "fairy" -> {
            color = Fairy
            dark = false
        }

        "grass" -> color = Grass

        "ghost" -> color = Ghost

        "bug" -> color = Bug

        "poison" -> color = Poison

        "ground" -> color = Ground

        "rock" -> color = Rock

        "flying" -> {
            color = Flying
            dark = false
        }

        "fight" -> color = Fight

        "psych" -> color = Psych

        "dragon" -> color = Dragon
    }

    return Pair(color, if (dark) OffWhite else DarkGray)
}