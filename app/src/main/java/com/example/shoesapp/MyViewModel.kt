package com.example.shoesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoesapp.model.Shoe

//ViewModel for ShoeList and NewShoeDetailsScreen
class MyViewModel: ViewModel() {
    private val _shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        Log.i("ViewModel CREATED", "CREATED VIEWMODEL")
        setShoeList()
    }

    private fun setShoeList() {
        _shoes.value = mutableListOf(
            Shoe("Converse", 15.0, "All Stars", "A great classic on your feet!", mutableListOf("converse")),
            Shoe("Timberland boots", 14.0, "Timberland", "For real adventurers!", mutableListOf("timber")),
            Shoe("Skates", 13.0, "Vans", "Best street shoes!", mutableListOf("vans2"))
        )
    }

    fun addShoe(shoeToAdd: Shoe) {
        _shoes.value?.add(shoeToAdd)
    }
}