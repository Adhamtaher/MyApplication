package com.example.myapplication.fragment.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.activity.MainPagePatient
import com.example.myapplication.common.State
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.fragment.main.login.LoginInfo
import com.example.myapplication.fragment.main.login.LoginViewModel
import kotlinx.coroutines.launch


class Login : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        observerUserLoginState()
        binding.login.setOnClickListener {
            val loginInfo = LoginInfo(
                fullName = binding.username.text.toString(),
                password = binding.password.text.toString(),

                )
            viewModel.loginUser(loginInfo)
        }
        binding.bkRegister.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }

        return binding.root
    }

    private fun observerUserLoginState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loginSharedFlow.collect {
                    binding.progress.isVisible = false
                    binding.login.visibility = View.VISIBLE
                    when (it) {
                        is State.Error -> handleError(it.message)
                        is State.Loading -> {
                            binding.progress.isVisible = true
                            binding.login.visibility = View.INVISIBLE
                        }

                        is State.Success -> startActivity(
                            Intent(
                                requireContext(),
                                MainPagePatient::class.java
                            )
                        )
                    }
                }
            }
        }
    }

    private fun handleError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}