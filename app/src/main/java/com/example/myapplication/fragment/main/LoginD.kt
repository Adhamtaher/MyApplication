package com.example.myapplication.fragment.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.activity.MainPageDoctor
import com.example.myapplication.activity.MainPagePatient
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentLoginDBinding

class LoginD : Fragment() {

    private lateinit var binding: FragmentLoginDBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginDBinding.inflate(inflater, container, false)

        binding.login.setOnClickListener {
            if(binding.username.text.isNotEmpty()&&binding.password.text.isNotEmpty()){
                Toast.makeText(context, "Logged in successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, MainPageDoctor::class.java)
                startActivity(intent)
                //val action = LoginDirections.actionLoginToMainPage(binding.username.text.toString())
                //findNavController().navigate(action)
            }
            else{
                Toast.makeText(context, "Please fill the required fields", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}