package com.udacity.shoestore.main.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {


    companion object {
        var initialized = false
        val shoeList = MutableLiveData<MutableList<Shoe>>()
    }


    init {
        if (! initialized) {
            shoeList.value = mutableListOf(
                Shoe("Fast Runners", 47.1, "Adidas", "shoes for runners"),
                Shoe("Lone Riders", 45.7, "Nike", "shoes for the lone riders"),
                Shoe("Flip Flops", 38.0, "CompanyA", "Some normal shoes"),
                Shoe("Sandals-C", 44.7, "Birkenstock", "Nice sandals from Birkenstock"),
                Shoe("K-2", 46.0, "K-Swiss", "A nice shoe from switzerland"),
                Shoe("X-treme Walking", 45.2, "Adidas", "Shoe for extreme walking"),
                Shoe("X-Runners", 44.5, "Adidas", "Adidas' brand nur runner shoe"),
                Shoe("Lone Riders 2", 45.7, "Nike", "Nike's brand new riders shoe"),
                Shoe("Flip Flops B", 39.0, "CompanyA", "Some normal shoes"),
                Shoe("Sandals-A", 38.5, "Birkenstock", "Other nice sandals from Birkenstock"),
                Shoe("K-5", 45.0, "K-Swiss", "Another nice shoe from switzerland"),
                Shoe("X-treme Jumping", 45.0, "Adidas", "Shoe for extreme jumps"),
            )
            initialized = true
        }
    }

    fun add(newShoe : Shoe) {
        shoeList.value?.add(newShoe)
        shoeList.postValue(shoeList.value)
    }

}