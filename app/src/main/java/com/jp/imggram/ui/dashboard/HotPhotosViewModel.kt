package com.jp.imggram.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HotPhotosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is hot photos Fragment"
    }
    val text: LiveData<String> = _text
}