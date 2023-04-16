package ui.screens.main


sealed class MainScreenEvent{
    object setTabStateToMain : MainScreenEvent()
    object setTabStateToInfo : MainScreenEvent()
    data class setTextFiled_R(val value: Float): MainScreenEvent()
    data class setTextFiled_L(val value: Float): MainScreenEvent()
    data class setTextFiled_C(val value: Float): MainScreenEvent()
    data class setRUnit(val value: Int): MainScreenEvent()
}
