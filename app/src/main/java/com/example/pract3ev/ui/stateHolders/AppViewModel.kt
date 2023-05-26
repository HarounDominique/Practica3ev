package com.example.pract3ev.ui.stateHolders

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel(){
    private var _show by  mutableStateOf(false)
    val show get() = _show

    private var _text by  mutableStateOf("")
    val text get() = _text

    private var _call by  mutableStateOf(false)
    val call get() = _call

    var _tfError by mutableStateOf(false)
    val tfError get() = _tfError

    fun onTextFieldChange (newText: String){
        _text = newText
    }

    fun changeCallState() {
        _call = !_call
    }

    fun changeTfErrorState(){
        _tfError = !_tfError
    }

    fun onSingUpClick() {
        _show = !_show
    }

}