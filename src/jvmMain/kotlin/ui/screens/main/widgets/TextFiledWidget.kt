package ui.screens.main.widgets

import Tables.R.RUnit
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.screens.main.MainScreenAccuracies
import ui.screens.main.MainScreenEvent
import ui.screens.main.MainScreenState
import ui.screens.main.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun RLCTextFields(onRChanged: (Float) -> Unit,
                  onLChanged: (Float) -> Unit,
                  onCChanged: (Float) -> Unit
                  ){
    var textFiled_R by remember { mutableStateOf(TextFieldValue("")) }
    var textFiled_C by remember { mutableStateOf(TextFieldValue("")) }
    var textFiled_L by remember { mutableStateOf(TextFieldValue("")) }
    var expanded by remember { mutableStateOf(false) }
    var selectedId by remember { mutableStateOf(0) }

    Card(){
        Column(modifier = Modifier.padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Введите значения R L C", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(2.dp))
            OutlinedTextField(value = textFiled_R,
                singleLine = true,
                label = {Text(text = "Сопротивление R")},
                onValueChange = { value -> textFiled_R = value
                    val output = value.text.toFloatOrNull()
                    if(output==null){
                        onRChanged(1.0f)
                    }else{
                        onRChanged(value.text.toFloat())
                    }
                },
                modifier = Modifier.padding(2.dp)
            )
            OutlinedTextField(value = textFiled_L,
            singleLine = true,
            label = {Text(text = "Индуктивность L")},
            onValueChange = { value -> textFiled_L = value
                val output = value.text.toFloatOrNull()
                if(output==null){
                    onLChanged(1.0f)
                }else{
                    onLChanged(value.text.toFloat())
                }
            },
            modifier = Modifier.padding(2.dp)

            )
            OutlinedTextField(value = textFiled_C,
                singleLine = true,
                label = {Text(text = "Емкость C")},
                onValueChange = { value -> textFiled_C = value
                    val output = value.text.toFloatOrNull()
                    if(output==null){
                        onCChanged(1.0f)
                    }else{
                        onCChanged(value.text.toFloat())
                    }
                                },
                modifier = Modifier.padding(2.dp)

            )
        }
    }
}