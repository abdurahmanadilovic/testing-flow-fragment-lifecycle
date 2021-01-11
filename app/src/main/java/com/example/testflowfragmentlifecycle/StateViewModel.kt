package com.example.testflowfragmentlifecycle

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Abdurahman Adilovic on 1/11/21.
 */

class StateViewModel : ViewModel() {

    val state = MutableStateFlow(1)
    val state2 = state.asSharedFlow()

    fun inc() {
        state.value = state.value + 1
    }
}