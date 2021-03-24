package com.example.shoesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoesapp.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWelcomeScreenBinding>(inflater, R.layout.fragment_welcome_screen, container, false)

        binding.welcomeBtn.setOnClickListener { v: View ->
            Navigation.findNavController(v).navigate(R.id.action_welcomeScreen_to_instructionScreen)
        }

        return binding.root
    }
}