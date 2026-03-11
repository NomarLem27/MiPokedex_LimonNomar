package limon.nomar.composepokedex_LimonNomar.navigations


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import limon.nomar.composepokedex_LimonNomar.dummy.getPokemon
import limon.nomar.composepokedex_LimonNomar.dummy.showAllPokemons
import limon.nomar.composepokedex_LimonNomar.screen.LoginScreen
import limon.nomar.composepokedex_LimonNomar.screen.PokedexMenuScreen
import limon.nomar.composepokedex_LimonNomar.screen.PokemonDetailScreen
import limon.nomar.composepokedex_LimonNomar.screen.RegisterScreen
import limon.nomar.composepokedex_LimonNomar.dummy.getNeighbors


@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Login){

        composable<Login>{
            LoginScreen(onLoginSuccess = { navController.navigate(PokemonList){
                popUpTo(Login){inclusive = true}
            }
            },
                onGoToRegister = {navController.navigate(Register)}
            )
        }
        composable <Register>{
            RegisterScreen(onRegisterSuccess = {navController.navigate(PokemonList){
                popUpTo(Login){inclusive = true}
            }
            },
                onGoToLogin = {navController.popBackStack()}
            )
        }
        composable<PokemonList>{
            PokedexMenuScreen(showAllPokemons(), {id -> navController.navigate(route = PokemonDetail(id = id))})
        }
        composable < PokemonDetail>{ backStackEntry ->
            val route: PokemonDetail = backStackEntry.toRoute()
            val pokemon = getPokemon(route.id)
            if (pokemon == null){
                navController.popBackStack()
                return@composable
            }
            val (prev, next) = getNeighbors(route.id)

            PokemonDetailScreen(
                pokemon = pokemon,
                prevPokemon = prev,
                nextPokemon = next,
                onNavigate = {id ->
                    navController.navigate(PokemonDetail(id = id)){
                        popUpTo<PokemonDetail> { inclusive = true}
                    }
                }
            )
        }
    }
}