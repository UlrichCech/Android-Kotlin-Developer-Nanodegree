package com.udacity.shoestore.welcome.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding
import com.udacity.shoestore.main.ui.MainActivity


/**
 * The fragment for showing the welcome screen.
 */
class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container,false)
        binding.instructionButton.setOnClickListener {
            navigateToInstructions()
        }
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

    private fun navigateToInstructions() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

}