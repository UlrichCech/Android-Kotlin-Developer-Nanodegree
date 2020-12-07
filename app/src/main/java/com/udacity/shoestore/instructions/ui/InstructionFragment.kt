package com.udacity.shoestore.instructions.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding

/**
 */
class InstructionFragment : Fragment() {

    private lateinit var binding: InstructionFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.instruction_fragment, container,false)
        binding.instructionButton.setOnClickListener {
            navigateToShoelist()
        }
        return binding.root
    }

    private fun navigateToShoelist() {
        val action = InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

}