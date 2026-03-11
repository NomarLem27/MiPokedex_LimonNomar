package limon.nomar.composepokedex_LimonNomar.navigations


import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Register

@Serializable
object PokemonList

@Serializable
data class PokemonDetail(val id: Int)