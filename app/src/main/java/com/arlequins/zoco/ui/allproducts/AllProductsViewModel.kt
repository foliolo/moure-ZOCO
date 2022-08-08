package com.arlequins.zoco.ui.allproducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllProductsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is all products Fragment"
    }
    val text: LiveData<String> = _text
}