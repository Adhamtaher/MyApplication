package com.example.myapplication.fragment.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.activity.MainActivity
import com.example.myapplication.activity.MainPagePatient
import com.example.myapplication.common.State
import com.example.myapplication.databinding.FragmentRegisterBinding
import com.example.myapplication.fragment.main.domain.RegisterationViewModel
import com.example.myapplication.fragment.main.domain.UserInfo
import kotlinx.coroutines.launch

class Register : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    val viewModel by viewModels<RegisterationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        observerUserRegistrationState()
        binding.register.setOnClickListener {
            val userInfo = UserInfo(
                fullName = binding.name.text.toString(),
                email = binding.mail.text.toString(),
                phone = binding.Phone.text.toString(),
                password = binding.password.text.toString(),
                passwordConfirmation = binding.ChangePass.text.toString(),
                birthDay = binding.Birthday.text.toString(),
                address = binding.address.text.toString(),
                city = binding.city.text.toString(),
            )
            viewModel.registerUser(userInfo)
        }

        binding.bkLogin.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }

        return binding.root
    }

    private fun observerUserRegistrationState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.registrationSharedFlow.collect{
                    binding.progress.isVisible = false
                    binding.register.visibility = View.VISIBLE
                    when(it){
                        is State.Error -> handleError(it.message)
                        is State.Loading -> {
                            binding.progress.isVisible = true
                            binding.register.visibility = View.INVISIBLE
                        }
                        is State.Success -> startActivity(Intent(requireContext(), MainPagePatient::class.java))
                    }
                }
            }
        }
    }

    private fun handleError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}