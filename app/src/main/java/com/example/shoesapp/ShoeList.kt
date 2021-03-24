package com.example.shoesapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.shoesapp.databinding.FragmentShoeListBinding
import com.example.shoesapp.model.Shoe

class ShoeList : Fragment() {
    private lateinit var viewModel: MyViewModel
    private lateinit var binding: FragmentShoeListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        viewModel.shoes.observe(viewLifecycleOwner, {shoeListUpdated ->
            shoeListUpdated.forEach {
                addShoe(it)
            }
        })

        binding.fabBtn.setOnClickListener{v ->
            Navigation.findNavController(v).navigate(R.id.action_shoeList_to_newShoeDetailsScreen)
        }


        return binding.root
    }

    private fun addShoe(shoe: Shoe) {
        val customView = MyCustomView(this.context!!)
        customView.setShoeName(shoe.name)
        customView.setShoeSize(shoe.size)
        customView.setCompany(shoe.company)
        customView.setDescription(shoe.description)
        customView.setImage(shoe.images[0])

        binding.myLinearLayout.addView(customView)
    }
}