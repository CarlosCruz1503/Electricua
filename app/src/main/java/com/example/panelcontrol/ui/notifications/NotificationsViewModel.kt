package com.example.panelcontrol.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "La importancia de cuidar la energía"
    }
    val text: LiveData<String> = _text
}