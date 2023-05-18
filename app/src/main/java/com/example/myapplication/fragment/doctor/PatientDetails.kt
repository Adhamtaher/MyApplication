package com.example.myapplication.fragment.doctor

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPatientDetailsBinding
import com.example.myapplication.databinding.FragmentPrescriptionBinding
import kotlin.math.max
import kotlin.math.min

class PatientDetails : Fragment() {
    private lateinit var binding: FragmentPatientDetailsBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPatientDetailsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.mediaclreportbtn.setOnClickListener {
            binding.lmdimage.visibility = View.VISIBLE
        }
        binding.labanalysisbutton.setOnClickListener {
            binding.lla.visibility = View.VISIBLE
        }
        binding.radiationimgbtn.setOnClickListener {
            binding.lr.visibility = View.VISIBLE
        }
        binding.patientDetails.setOnTouchListener { _, event ->
            val imageView = binding.lmdimage
            val imageView2 = binding.lla
            val imageView3 = binding.lr
            val imageRect = Rect()
            imageView.getGlobalVisibleRect(imageRect)

            if (!imageRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                imageView.visibility = View.GONE
                imageView2.visibility = View.GONE
                imageView3.visibility = View.GONE
            }
            false
        }

        return binding.root
    }

    fun View.contains(x: Int, y: Int): Boolean {
        val location = IntArray(2)
        getLocationOnScreen(location)
        val left = location[0]
        val top = location[1]
        val right = left + width
        val bottom = top + height
        return x >= left && x <= right && y >= top && y <= bottom
    }

}




