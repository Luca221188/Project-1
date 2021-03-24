package com.example.shoesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoesapp.databinding.FragmentInstructionScreenBinding


class InstructionScreen : Fragment() {
    //Hard to figure out
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInstructionScreenBinding>(inflater, R.layout.fragment_instruction_screen, container, false)

        binding.instructionBtn.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_instructionScreen_to_shoeList)
        }

        return binding.root
    }
}