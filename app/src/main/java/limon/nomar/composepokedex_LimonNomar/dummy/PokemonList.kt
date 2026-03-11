package limon.nomar.composepokedex_LimonNomar.dummy

import limon.nomar.composepokedex_LimonNomar.R
import limon.nomar.composepokedex_LimonNomar.domain.Pokemon


val pokemonList = listOf(

    Pokemon(
        name = "Snorlax",
        number = 143,
        type = "normal",
        description = "Solo se despierta para comer. Puede dormir durante días sin moverse.",
        height = 2.1f,
        weight = 460f,
        fav = true,
        ability = "Inmunidad",
        image = R.drawable.snorlax,
        evolutions = listOf(
            Pokemon(
                "Munchlax",
                446,
                "normal",
                "Guarda comida bajo su pelaje y come constantemente.",
                0.6f,
                105f,
                false,
                "Recogida",
                R.drawable.munchlax
            )
        )
    ),

    Pokemon(
        name = "Dratini",
        number = 147,
        type = "dragon",
        description = "Un Pokémon dragón raro que habita en aguas cristalinas.",
        height = 1.8f,
        weight = 3.3f,
        fav = false,
        ability = "Mudar",
        image = R.drawable.dratini,
        evolutions = listOf(
            Pokemon("Dragonair",148,"dragon","Su aura mística hace cambiar el clima.",4.0f,16.5f,false,"Mudar",R.drawable.dragonair),
            Pokemon("Dragonite",149,"dragon/flying","Es capaz de dar la vuelta al mundo en 16 horas.",2.2f,210f,false,"Foco Interno",R.drawable.dragonite)
        )
    ),

    Pokemon(
        name = "Growlithe",
        number = 58,
        type = "fire",
        description = "Muy leal a su entrenador. Defiende su territorio con valentía.",
        height = 0.7f,
        weight = 19.0f,
        fav = false,
        ability = "Intimidación",
        image = R.drawable.growlithe,
        evolutions = listOf(
            Pokemon("Arcanine",59,"fire","Un Pokémon legendario conocido por su gran velocidad.",1.9f,155f,false,"Intimidación",R.drawable.arcanine)
        )
    ),

    Pokemon(
        name = "Magikarp",
        number = 129,
        type = "water",
        description = "Un Pokémon famoso por ser débil, pero muy resistente.",
        height = 0.9f,
        weight = 10f,
        fav = false,
        ability = "Nado Rápido",
        image = R.drawable.magikarp,
        evolutions = listOf(
            Pokemon("Gyarados",130,"water/flying","Un Pokémon extremadamente violento cuando se enfurece.",6.5f,235f,false,"Intimidación",R.drawable.gyarados)
        )
    ),

    Pokemon(
        name = "Abra",
        number = 63,
        type = "psychic",
        description = "Puede teletransportarse incluso mientras duerme.",
        height = 0.9f,
        weight = 19.5f,
        fav = false,
        ability = "Sincronía",
        image = R.drawable.abra,
        evolutions = listOf(
            Pokemon("Kadabra",64,"psychic","Usa sus poderes psíquicos para atacar.",1.3f,56.5f,false,"Sincronía",R.drawable.kadabra),
            Pokemon("Alakazam",65,"psychic","Su cerebro nunca deja de crecer.",1.5f,48f,false,"Sincronía",R.drawable.alakazam)
        )
    ),

    Pokemon(
        name = "Onix",
        number = 95,
        type = "rock/ground",
        description = "Excava túneles a gran velocidad bajo tierra.",
        height = 8.8f,
        weight = 210f,
        fav = false,
        ability = "Cabeza Roca",
        image = R.drawable.onix,
        evolutions = listOf(
            Pokemon("Steelix",208,"steel/ground","Su cuerpo se endureció tras años bajo tierra.",9.2f,400f,false,"Cabeza Roca",R.drawable.steelix)
        )
    ),

    Pokemon(
        name = "Lapras",
        number = 131,
        type = "water/ice",
        description = "Transporta personas a través del mar en su espalda.",
        height = 2.5f,
        weight = 220f,
        fav = true,
        ability = "Absorbe Agua",
        image = R.drawable.lapras,
        evolutions = listOf()
    ),

    Pokemon(
        name = "Scyther",
        number = 123,
        type = "bug/flying",
        description = "Se mueve extremadamente rápido y corta con sus guadañas.",
        height = 1.5f,
        weight = 56f,
        fav = false,
        ability = "Enjambre",
        image = R.drawable.scyther,
        evolutions = listOf(
            Pokemon("Scizor",212,"bug/steel","Su cuerpo metálico es muy resistente.",1.8f,118f,false,"Experto",R.drawable.scizor)
        )
    ),

    Pokemon(
        name = "Sandshrew",
        number = 27,
        type = "ground",
        description = "Se enrolla como bola para protegerse.",
        height = 0.6f,
        weight = 12f,
        fav = false,
        ability = "Velo Arena",
        image = R.drawable.sandshrew,
        evolutions = listOf(
            Pokemon("Sandslash",28,"ground","Sus púas son extremadamente afiladas.",1.0f,29.5f,false,"Velo Arena",R.drawable.sandslash)
        )
    ),

    Pokemon(
        name = "Horsea",
        number = 116,
        type = "water",
        description = "Dispara tinta para escapar de los enemigos.",
        height = 0.4f,
        weight = 8f,
        fav = false,
        ability = "Nado Rápido",
        image = R.drawable.horsea,
        evolutions = listOf(
            Pokemon("Seadra",117,"water","Nada hacia atrás moviendo sus aletas.",1.2f,25f,false,"Veneno Punto",R.drawable.seadra),
            Pokemon("Kingdra",230,"water/dragon","Puede crear torbellinos gigantes.",1.8f,152f,false,"Nado Rápido",R.drawable.kingdra)
        )
    )
)

fun showAllPokemons(): List<Pokemon>{
    return pokemonList.sortedBy { it.number }
}


val allPokemon: List<Pokemon> by lazy{
    pokemonList + pokemonList.flatMap { it.evolutions }
}

fun returnOnePokemon(): Pokemon{
    return pokemonList.get((0..9).random())
}

fun getPokemon(id:Int): Pokemon? = allPokemon.firstOrNull{it.number == id}

fun getNeighbors(id: Int): Pair<Pokemon?, Pokemon?>{

    val sortedList = pokemonList.sortedBy { it.number }

    val index = sortedList.indexOfFirst { it.number == id }

    if (index == -1) return Pair(null, null)

    val prev = if (index > 0) sortedList[index - 1] else null
    val next = if (index < sortedList.lastIndex) sortedList[index + 1] else null

    return Pair(prev, next)
}