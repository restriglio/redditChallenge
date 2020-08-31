package com.example.reddittest.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.reddittest.model.repositories.MainRepository

class MainViewModel @ViewModelInject constructor(
    repository: MainRepository,
    @Assisted private val stateHandle: SavedStateHandle
) : ViewModel() {

}