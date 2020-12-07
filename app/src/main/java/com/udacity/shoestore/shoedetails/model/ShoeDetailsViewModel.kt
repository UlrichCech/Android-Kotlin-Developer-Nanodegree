package com.udacity.shoestore.shoedetails.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.main.model.Shoe

class ShoeDetailsViewModel : ViewModel() {

    var name = MutableLiveData("")

    var company = MutableLiveData("")

    var size = MutableLiveData("")

    var description = MutableLiveData("")

    private val _saveButtonPressed = MutableLiveData(false)
    val saveButtonPressed : LiveData<Boolean>
        get() = _saveButtonPressed


    var newShoe = Shoe("", 0.0, "", "")


    fun saveNewShow() {
        newShoe = Shoe(name.value?.toString() ?: "",
            size.value?.toDouble() ?: 0.0,
            company.value?.toString() ?: "",
            description.value?.toString() ?: "")
        _saveButtonPressed.value = true
    }

    fun onSaveComplete() {
        _saveButtonPressed.value = false
    }

}