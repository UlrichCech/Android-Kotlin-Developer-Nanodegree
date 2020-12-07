package com.udacity.shoestore.shoedetails.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailsFragmentBinding
import com.udacity.shoestore.main.model.ShoeListViewModel
import com.udacity.shoestore.shoedetails.model.ShoeDetailsViewModel

/**
 *
 */
class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: ShoedetailsFragmentBinding

    private lateinit var viewModel : ShoeDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.shoedetails_fragment, container, false)
        binding.shoeDetailsViewModel = viewModel
        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener { view: View ->
//            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            view.findNavController().popBackStack(R.id.shoeListFragment, false)
        }
        viewModel.saveButtonPressed.observe(viewLifecycleOwner, {
            if (it) {
                val shoeDetailsViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
                shoeDetailsViewModel.add(viewModel.newShoe)
                NavHostFragment.findNavController(this).popBackStack(R.id.shoeListFragment, false)
                viewModel.onSaveComplete()
            }
        })
        return binding.root
    }

}