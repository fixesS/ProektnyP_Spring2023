package ui.screens.main

import EventHandler

class MainScreenViewModel: EventHandler<MainScreenEvent>{

    //private val _viewState = flowOf(MainScreenState())
    //private val _viewState = MutableLiveData(MainScreenState())
    var viewState: MainScreenState = MainScreenState()

    override fun obtainEvent(event: MainScreenEvent) {
        when(event){
            is MainScreenEvent.setTextFiled_R -> setR(event.value)
            is MainScreenEvent.setTextFiled_L -> setL(event.value)
            is MainScreenEvent.setTextFiled_C -> setC(event.value)
            is MainScreenEvent.setRUnit -> setRUnit(event.value)
            MainScreenEvent.setTabStateToMain -> setTabStateToMain()
            MainScreenEvent.setTabStateToInfo -> setTabStateToInfo()
            else -> {}
        }
    }
    private fun setRUnit(id:Int){
        viewState.selectedRUnit.value = id
    }
    private fun setTabStateToMain(){
        viewState.mainScreenTabs.value = MainScreenTabs.Main
    }
    private fun setTabStateToInfo(){
        viewState.mainScreenTabs.value = MainScreenTabs.Info
    }
    private fun setR(R: Float){
        viewState.textfield_R.value = R
    }
    private fun setL(L: Float){
        viewState.textfield_L.value = L
    }
    private fun setC(C:Float){
        viewState.textfield_C.value = C
    }
}