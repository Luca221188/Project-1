package com.example.shoesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.shoesapp.databinding.FragmentNewShoeDetailsScreenBinding
import com.example.shoesapp.model.Shoe
import java.lang.NumberFormatException


class NewShoeDetailsScreen : Fragment() {
    private lateinit var binding: FragmentNewShoeDetailsScreenBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe_details_screen, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        binding.cancelBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_newShoeDetailsScreen_to_shoeList)
        }

        binding.saveBtn.setOnClickListener {
            val shoe = getShoe()
            if (shoe != null) {
                viewModel.addShoe(shoe)
                Navigation.findNavController(it).navigate(R.id.action_newShoeDetailsScreen_to_shoeList)
            }
            else {
                Toast.makeText(this.context, "Attributes missing", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun getShoe(): Shoe? {
        val shoeName: String = binding.editTextShoeName.text.toString()
        var size = 0.0
        val company: String = binding.editTextShoeCompany.text.toString()
        val description: String = binding.editTextShoeDescription.text.toString()

        //catch exception in case user types nothing for "size". catch statement is empty because
        //a Toast message will already be launched in binding.saveBtn.setOnClickListener{...}
        try {
            size = binding.editTextShoeSize.text.toString().toDouble()
        }catch (e: NumberFormatException) {

        }

        if (shoeName.isBlank() || company.isBlank() || description.isBlank() || size == 0.0) {
            return null
        }

        //there's no image to add, so just an "empty list" is returned for images
        return Shoe(shoeName, size, company, description, mutableListOf(""))
    }
}