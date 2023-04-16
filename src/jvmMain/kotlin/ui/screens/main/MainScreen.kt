package ui.screens.main

import Tables.R.Nominal
import androidx.compose.animation.Crossfade
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.screens.main.widgets.AccuracyDialog
import ui.screens.main.widgets.RLCTextFields

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainScreen(){
    val viewModel = remember { MainScreenViewModel() }

    Scaffold (
        topBar = {
            SmallTopAppBar(
                title = {
                    TabRow(selectedTabIndex = viewModel.viewState.mainScreenTabs.value.id,
                        tabs = {
                            MainScreenTabs.getListOfTabs().forEachIndexed{index, title ->
                                Tab(
                                    selected = viewModel.viewState.mainScreenTabs.value.id == index,
                                    onClick = {
                                        val clickedState = MainScreenTabs.getById(index)
                                        when(clickedState){
                                            MainScreenTabs.Main -> viewModel.obtainEvent(MainScreenEvent.setTabStateToMain)
                                            MainScreenTabs.Info -> viewModel.obtainEvent(MainScreenEvent.setTabStateToInfo)
                                        }
                                    },
                                    text = { Text(text = title, fontSize =18.sp, fontWeight = FontWeight.Bold)}
                                )
                            }
                        })
                }
            )
        },
        content = { padding ->
            Crossfade(viewModel.viewState.mainScreenTabs.value){
                when(viewModel.viewState.mainScreenTabs.value){
                    MainScreenTabs.Main -> {
                        Box(modifier = Modifier.fillMaxSize().padding(padding)){
                            Card(modifier = Modifier.fillMaxSize().padding(8.dp)){
                                Row(modifier = Modifier.fillMaxSize()) {
                                    Column(modifier = Modifier.padding(2.dp).weight(1.3f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
                                    ) {
                                        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center){
                                            when(viewModel.viewState.mainScreenDialogState.value){
                                                MainScreenDialogState.None -> {}
                                                MainScreenDialogState.Accuracy -> {
                                                    AccuracyDialog(
                                                        onDismiss = {
                                                            viewModel.viewState.mainScreenDialogState.value = MainScreenDialogState.None
                                                        },
                                                        onAccuracyPicked = {accuracy ->
                                                            viewModel.viewState.mainScreenAccuracies.value = accuracy.value

                                                        },
                                                        selectedIndex = 0
                                                    )
                                                }
                                            }
                                            RLCTextFields(
                                                onRChanged = {R ->
                                                    viewModel.obtainEvent(MainScreenEvent.setTextFiled_R(R))
                                                },
                                                onLChanged = {L ->
                                                    viewModel.obtainEvent(MainScreenEvent.setTextFiled_L(L))
                                                },
                                                onCChanged = {C ->
                                                    viewModel.obtainEvent(MainScreenEvent.setTextFiled_C(C))
                                                }
                                            )
                                        }
                                    }
                                    Column(modifier = Modifier.padding(2.dp).weight(1f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                                        Text(text = "Значения для R")
                                        Crossfade(viewModel.viewState.textfield_R.value){
                                            Column {
                                                for(nomimalId in Nominal.getListOfE()){
                                                    ElevatedCard(shape = MaterialTheme.shapes.small, modifier = Modifier.padding(3.dp)){
                                                        Row(modifier = Modifier.padding(3.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                                                            Text(text = Nominal.getById(nomimalId).name)
                                                            Text(text = Nominal.getClosestById(nomimalId,viewModel.viewState.textfield_R.value).toString())
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                    }
                                    Column(modifier = Modifier.padding(2.dp).weight(1f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                                        Text(text = "Значения для L")
                                        Crossfade(viewModel.viewState.textfield_L.value){
                                            Column {
                                                for(nomimalId in Nominal.getListOfE()){
                                                    ElevatedCard(shape = MaterialTheme.shapes.small, modifier = Modifier.padding(3.dp)){
                                                        Row(modifier = Modifier.padding(3.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                                                            Text(text = Nominal.getById(nomimalId).name)
                                                            Text(text = Nominal.getClosestById(nomimalId,viewModel.viewState.textfield_L.value).toString())
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                    }
                                    Column(modifier = Modifier.padding(2.dp).weight(1f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                                        Text(text = "Значения для C")
                                        Crossfade(viewModel.viewState.textfield_C.value){
                                            Column {
                                                for(nomimalId in Nominal.getListOfE()){
                                                    ElevatedCard(shape = MaterialTheme.shapes.small, modifier = Modifier.padding(3.dp)){
                                                        Row(modifier = Modifier.padding(3.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                                                            Text(text = Nominal.getById(nomimalId).name)
                                                            Text(text = Nominal.getClosestById(nomimalId,viewModel.viewState.textfield_C.value).toString())
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                    MainScreenTabs.Info ->{
                        

                    }
                }
            }

        }
    )
}