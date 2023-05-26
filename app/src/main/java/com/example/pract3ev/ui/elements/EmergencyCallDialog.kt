package com.example.pract3ev.ui.elements

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun EmercyCallDialog(call : Boolean,
             onDismiss:() -> Unit,
             onConfirm:() -> Unit,){
    if(call) {
        AlertDialog(title = { Text(text = "7773-2232-1110") },
            text = { Text(text = "LLamando a tu madre. Pronto vendrá a buscarte") },
            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Huír")
                }
            }
        )
    }
}