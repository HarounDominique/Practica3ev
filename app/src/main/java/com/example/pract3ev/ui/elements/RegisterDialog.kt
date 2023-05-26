package com.example.pract3ev.ui.elements

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun RegisterDialog(show : Boolean,
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