package com.example.myapplication.fragment.doctor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPrescriptionBinding

class Prescription : Fragment() {

    private lateinit var binding: FragmentPrescriptionBinding
    private val REQUEST_CODE_IMAGE_PICKER = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentPrescriptionBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_prescription_to_mainPageDoctor)
        }
        binding.submit.setOnClickListener {
            findNavController().navigate(R.id.action_prescription_to_mainPageDoctor)
        }

        binding.upload.setOnClickListener {
            pickImageFromGallery()
        }
        return binding.root
    }
    private fun pickImageFromGallery() {
        // Intent to pick image from gallery
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE_IMAGE_PICKER)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_IMAGE_PICKER && resultCode == Activity.RESULT_OK) {
            // Get the selected image URI
            val imageUri = data?.data

            // Do something with the image URI, such as display it in an ImageView
            binding.imageView41.setImageURI(imageUri)
        }
    }


}





