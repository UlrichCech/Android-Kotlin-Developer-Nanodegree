package com.udacity.shoestore.login.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.login.model.LoginViewModel
import com.udacity.shoestore.main.ui.MainActivity


/**
 * The fragment for handling the login process.
 */
class LoginFragment : Fragment() {

    private lateinit var viewModel : LoginViewModel

    private lateinit var binding: LoginFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.signInPressed.observe(viewLifecycleOwner, {
            if (it) {
                navigateToWelcome()
            }
        })
        viewModel.signUpPressed.observe(viewLifecycleOwner, {
            if (it) {
                navigateToWelcome()
            }
        })
        // optimized the Login-Screen for hiding the keyboard
        binding.signInButton.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                hideKeyboard(view)
            }
        }
        binding.signUpButton.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                hideKeyboard(view)
            }
        }
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        clearBackStack()
        return binding.root
    }

    private fun navigateToWelcome() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        NavHostFragment.findNavController(this).navigate(action)
        viewModel.onSignInComplete()
        viewModel.onSignUpComplete()
    }


    fun hideKeyboard(view: View) {
        // Hide the keyboard
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun clearBackStack() {
        val manager: FragmentManager = requireActivity().supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first: FragmentManager.BackStackEntry = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}