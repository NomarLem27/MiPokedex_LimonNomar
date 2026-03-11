package limon.nomar.composepokedex_LimonNomar.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import limon.nomar.composepokedex_LimonNomar.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PokemonNavButton(
    position: String,
    image: Int,
    name: String,
    number: Int
) {
    Column(
        horizontalAlignment = if (position == "left") Alignment.Start else Alignment.End,
        modifier = Modifier.padding(12.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = name,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(80.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (position == "left") {
                Icon(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = "Anterior",
                    modifier = Modifier.size(28.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "$name N.º ${number.toString().padStart(4, '0')}",
                    fontSize = 12.sp
                )
            } else {
                Text(
                    text = "$name N.º ${number.toString().padStart(4, '0')}",
                    fontSize = 12.sp
                )
                Spacer(Modifier.width(4.dp))
                Icon(
                    painter = painterResource(R.drawable.arrow_right),
                    contentDescription = "Siguiente",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}