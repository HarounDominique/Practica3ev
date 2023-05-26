package com.example.pract3ev.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.example.pract3ev.ui.stateHolders.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    text: String,
    error: Boolean,
    show: Boolean,
    call: Boolean,
    changeTfErrorState: () -> Unit,
    onPhoneClick: () -> Unit,
    onSingUpClick: () -> Unit,
    onTextFieldChange:(String) -> Unit,
    modifier: Modifier) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Plataforma de no-terroristas",
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic)

        if (text=="hola"){
            changeTfErrorState()}

        OutlinedTextField(
            value= text ,
            onValueChange = {onTextFieldChange(it)},
            label = { Text(text = if (error)"Error: Palabra prohibida" else "Nombre") },
            isError = if (error)true else false)



        OutlinedTextField(value= text , onValueChange ={ onTextFieldChange(it)}, label = { Text(text = "Apellidos") })
        OutlinedTextField(value= text , onValueChange ={ onTextFieldChange(it)}, label = { Text(text = "Arma favorita") })
        Button(onClick = { onSingUpClick () },
        ) {
            Text(text = "Registrate")

        }
    }
    RegisterDialog(show = show, onDismiss = {onSingUpClick()}, onConfirm = {onSingUpClick()})
    EmercyCallDialog(call = call, onDismiss = {onPhoneClick()}, onConfirm = {onPhoneClick()})
}