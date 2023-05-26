package com.example.pract3ev.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    var show by rememberSaveable{ mutableStateOf(false) }
    var tfError by rememberSaveable{ mutableStateOf(false) }
    var text by rememberSaveable{ mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Cristo Rey")},
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = "call momma")
                    }
                },
            )
        },
    ){Paddingvalues->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(Paddingvalues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Plataforma de no-terroristas",
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic)

            if (text=="hola"){tfError=true}

            OutlinedTextField(
                value= text ,
                onValueChange = {text = it},
                label = { Text(text = if (tfError)"Error: Palabra prohibida" else "Nombre")},
                isError = if (tfError)true else false)



            OutlinedTextField(value="" , onValueChange ={}, label = { Text(text = "Apellidos")})
            OutlinedTextField(value="" , onValueChange ={}, label = { Text(text = "Arma favorita")})
            Button(onClick = { show = !show },
            ) {
                Text(text = "Afíliate 👍")

            }
        }
        MyDialog(show = show, onDismiss = { show = !show }, onConfirm = {show=!show})

        }
    }



@Composable
fun MyDialog(show : Boolean,
    onDismiss:() -> Unit,
    onConfirm:() -> Unit,){
    if(show==true) {
        AlertDialog(title = { Text(text = "Bienvenido") },
            text = { Text(text = "Perteneces a una organización ultra secreta") },
            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Salir a matar")
                }
            }
        )
    }
}