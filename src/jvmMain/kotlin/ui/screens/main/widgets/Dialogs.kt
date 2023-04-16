package ui.screens.main.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.screens.main.MainScreenAccuracies

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AccuracyDialog(
    selectedIndex: Int,
    onAccuracyPicked: (MainScreenAccuracies) -> Unit,
    onDismiss: () -> Unit
){
    AlertDialog(
        onDismissRequest = {onDismiss()},
        title = {
            Text(text = "Выберите точнсть")
        },
        text = {
            LazyColumn{
                itemsIndexed(MainScreenAccuracies.getListOfAccuracies()){ index, it ->
                    TypeDialogItem(text = it,index = index, selectedIndex = selectedIndex, onSelectItem = { onAccuracyPicked(MainScreenAccuracies.getById(index)) })
                }
            }
        },
        confirmButton = {onDismiss()},
        dismissButton = {onDismiss()}
    )
}
@Composable
fun TypeDialogItem(
    text : String,
    selectedIndex: Int,
    index: Int,
    onSelectItem: (Int) -> Unit
){

    var selected by remember { mutableStateOf(false) }
    selected = selectedIndex == index

    Card(shape = MaterialTheme.shapes.large,modifier = Modifier
        .fillMaxWidth()
        .padding(3.dp)
        .clip(MaterialTheme.shapes.large)
        .clickable {
            onSelectItem(index)
        }){
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected, onClick = {})
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Normal)
        }

    }
}