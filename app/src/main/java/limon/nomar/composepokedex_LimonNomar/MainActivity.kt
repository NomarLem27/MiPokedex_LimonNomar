package limon.nomar.composepokedex_LimonNomar


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import limon.nomar.composepokedex_LimonNomar.domain.Pokemon
import limon.nomar.composepokedex_LimonNomar.navigations.MyApp
import limon.nomar.composepokedex_LimonNomar.ui.theme.ComposePokedex_LimonNomarTheme


val pokemon = Pokemon(
    name = "Pikachu",
    number = 25,
    type = "Electrico",
    description = "SDASDASDASD.",
    height = 0.4f,
    weight = 6.0f,
    fav = true,
    ability = "Estatica",
    image = R.drawable.pikachu
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedex_LimonNomarTheme {
                MyApp()
            }
        }
    }
}