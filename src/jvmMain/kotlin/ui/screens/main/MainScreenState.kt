package ui.screens.main


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainScreenTabs(val id: Int,val tag: String,val icon: ImageVector) : MutableState<MainScreenTabs> {
    Main(0,"Главная",Icons.Filled.Home),
    Info(1,"Информация",Icons.Filled.Info);

    companion object{
        fun getListOfTabs():List<String>{
            val list : MutableList<String> = mutableListOf()
            MainScreenTabs.values().map { list.add(it.tag) }
            return list
        }
        fun getById(id :Int ): MainScreenTabs {
            var state : MainScreenTabs = MainScreenTabs.Main
            MainScreenTabs.values().map {
                if(it.id == id){
                    state = it
                }
            }
            return state
        }
    }

    override var value: MainScreenTabs
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun component1(): MainScreenTabs {
        TODO("Not yet implemented")
    }

    override fun component2(): (MainScreenTabs) -> Unit {
        TODO("Not yet implemented")
    }
}
enum class MainScreenAccuracies(val id: Int,val tag: String): MutableState<MainScreenAccuracies> {
    Five(0, "5%"),
    Ten(1, "10%"),
    Fifteen(1, "15%"),
    Twenty(1, "20%"),
    TwentyFive(1, "25%");

    companion object {
        fun getListOfAccuracies(): List<String> {
            val list: MutableList<String> = mutableListOf()
            MainScreenAccuracies.values().map { list.add(it.tag) }
            return list
        }

        fun getById(id: Int): MainScreenAccuracies {
            var state: MainScreenAccuracies = MainScreenAccuracies.Five
            MainScreenAccuracies.values().map {
                if (it.id == id) {
                    state = it
                }
            }
            return state
        }
    }
    override var value: MainScreenAccuracies
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun component1(): MainScreenAccuracies {
        TODO("Not yet implemented")
    }

    override fun component2(): (MainScreenAccuracies) -> Unit {
        TODO("Not yet implemented")
    }
}
enum class MainScreenDialogState{
    None,Accuracy
}

data class MainScreenState(
    var textfield_R: MutableState<Float> =  mutableStateOf(1.0f),
    var textfield_L: MutableState<Float> =  mutableStateOf(1.0f),
    var textfield_C: MutableState<Float> =  mutableStateOf(1.0f),
    var selectedRUnit: MutableState<Int> = mutableStateOf(1),
    var mainScreenTabs: MutableState<MainScreenTabs> =  mutableStateOf(MainScreenTabs.Main),
    var mainScreenAccuracies: MutableState<MainScreenAccuracies> = mutableStateOf(MainScreenAccuracies.Five),
    var mainScreenDialogState: MutableState<MainScreenDialogState> = mutableStateOf(MainScreenDialogState.None)
)