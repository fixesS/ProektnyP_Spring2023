package navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ui.screens.main.MainScreen

fun RootComposeBuilder.navigationGraph(){
    screen(name = NavigationTree.Main.name){
        MainScreen()
    }
    screen(name = NavigationTree.Loading.name){

    }
}