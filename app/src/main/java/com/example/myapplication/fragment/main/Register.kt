package com.example.myapplication.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentRegisterBinding

class Register : Fragment() {
        private lateinit var binding: FragmentRegisterBinding

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

            binding.register.setOnClickListener {
                if (binding.name.text.isNotEmpty() && binding.mail.text.isNotEmpty() && binding.password.text.isNotEmpty() && binding.ChangePass.text.isNotEmpty() && binding.city.text.isNotEmpty() && binding.address.text.isNotEmpty() && binding.Birthday.text.isNotEmpty() && binding.Phone.text.isNotEmpty() && binding.password.text.contentEquals(binding.ChangePass.text,true)) {
                    Toast.makeText(context, "Signed up successfully", Toast.LENGTH_SHORT).show()
                    //findNavController().navigate(R.id.action_register_to_mainPage)
                }
                else if (binding.password.text.contentEquals(binding.ChangePass.text,false)){
                    Toast.makeText(context, "Password doesn't match", Toast.LENGTH_SHORT).show()
                }
                else if(binding.name.text.isEmpty() && binding.mail.text.isEmpty() && binding.password.text.isEmpty() && binding.ChangePass.text.isEmpty() && binding.city.text.isEmpty() && binding.address.text.isEmpty() && binding.Birthday.text.isEmpty() && binding.Phone.text.isEmpty()){
                    Toast.makeText(context, "Please fill the required fields", Toast.LENGTH_SHORT).show()
                }
                binding.bkLogin.setOnClickListener {
                    findNavController().navigate(R.id.action_register_to_login)
                }
        }

        return binding.root
    }

}