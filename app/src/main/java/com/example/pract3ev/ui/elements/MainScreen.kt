package com.example.pract3ev.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pract3ev.ui.stateHolders.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    val AppViewModel: AppViewModel = viewModel()
    var text by rememberSaveable{ mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "LLamada de emergencia")},
                actions = {
                    IconButton(onClick = { AppViewModel.changeCallState() }) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = "call momma")
                    }
                },
            )
        },
    ){Paddingvalues->
            RegisterScreen(
                text = AppViewModel.text,
                error = AppViewModel.tfError,
                call =  AppViewModel.call,
                show = AppViewModel.show,
                changeTfErrorState = {AppViewModel.changeTfErrorState()},
                onPhoneClick = {AppViewModel.changeCallState()},
                onSingUpClick = {AppViewModel.onSingUpClick()},
                onTextFieldChange = {AppViewModel.onTextFieldChange(it)},
                modifier = Modifier.padding(Paddingvalues),
            )
        }
    }


