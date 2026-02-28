package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonNeighbor(
    position: String, // "left" o "right"
    image: Int,
    name: String,
    number: Int
) {
    val arrowIcon = if (position == "left") Icons.Default.ArrowBack else Icons.Default.ArrowForward

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (position == "left") Arrangement.Start else Arrangement.End,
        modifier = Modifier.width(150.dp)
    ) {
        if (position == "left") {
            Icon(
                imageVector = arrowIcon,
                contentDescription = "previous arrow",
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = name,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "$name N.º ${String.format("%04d", number)}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        } else {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = name,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "$name N.º ${String.format("%04d", number)}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                imageVector = arrowIcon,
                contentDescription = "next arrow",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}