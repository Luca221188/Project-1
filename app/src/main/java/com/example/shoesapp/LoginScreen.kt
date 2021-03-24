package com.example.shoesapp

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoesapp.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginScreenBinding>(inflater, R.layout.fragment_login_screen, container, false)

        binding.registerBtn.setOnClickListener { goToWelcomeScreen(it) }
        binding.loginBtn.setOnClickListener { goToWelcomeScreen(it) }

        return binding.root
    }

    private fun goToWelcomeScreen(v: View) {
        v.findNavController().navigate(R.id.action_loginScreen_to_welcomeScreen)
    }
//Erase the menu for this fragment
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        menu.clear()
//    }

//Hide one or more menu items for this fragment
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.loginScreen).isVisible = false
    }


    //change behaviour of loginScreen option
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.loginScreen) {
//            Toast.makeText(this.context, "U need to log in first", Toast.LENGTH_SHORT).show()
//        }
//        return super.onOptionsItemSelected(item)
//    }
}