package com.example.pract3ev.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pract3ev.ui.stateHolders.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    val AppViewModel: AppViewModel = viewModel()

    var tfError by rememberSaveable{ mutableStateOf(false) }
    var text by rememberSaveable{ mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "LLamada de emergencia")},
                actions = {
                    IconButton(onClick = { AppViewModel.onPhoneClick() }) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = "call momma")
                    }
                },
            )
        },
    ){Paddingvalues->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(Paddingvalues)
            .background(Color.LightGray),
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
            Button(onClick = { AppViewModel.onSingUpClick() },
            ) {
                Text(text = "Registrate")

            }
        }
        RegisterDialog(show = AppViewModel.show, onDismiss = {AppViewModel.onSingUpClick() }, onConfirm = {AppViewModel.onSingUpClick()})
        EmercyCallDialog(call = AppViewModel.call, onDismiss = { AppViewModel.onPhoneClick() }, onConfirm = {AppViewModel.onPhoneClick()})
        }
    }


