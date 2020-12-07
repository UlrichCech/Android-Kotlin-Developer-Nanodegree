package com.udacity.shoestore.shoelist.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import com.udacity.shoestore.databinding.ShoelistItemTemplateBinding
import com.udacity.shoestore.main.model.ShoeListViewModel


/**
 * The fragment for managing the shoe-list.
 */
class ShoeListFragment : Fragment() {

    private lateinit var viewModel : ShoeListViewModel

    private lateinit var binding: ShoelistFragmentBinding

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.application_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoelist_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        ShoeListViewModel.shoeList.observe(viewLifecycleOwner, {
            showShoeList(inflater)
        })
        binding.floatingActionButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    fun showShoeList(inflater: LayoutInflater) {
        if (binding.shoelistLinear.childCount > 0) {
            binding.shoelistLinear.removeAllViews()
        }
        ShoeListViewModel.shoeList.value?.forEach { shoe ->
            val itemBinding : ShoelistItemTemplateBinding =
                DataBindingUtil.inflate(
                    inflater, R.layout.shoelist_item_template,
                    binding.shoelistLinear, false
                )
            itemBinding.shoeItemNameView.text = shoe.name
            itemBinding.shoeItemSizeView.text = shoe.size.toString()
            itemBinding.shoeItemCompanyView.text = shoe.company
            itemBinding.shoeItemDescriptionView.text = shoe.description
            binding.shoelistLinear.addView(itemBinding.root)
        }
    }

}