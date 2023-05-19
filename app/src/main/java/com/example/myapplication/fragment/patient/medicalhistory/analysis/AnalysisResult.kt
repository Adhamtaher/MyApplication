package com.example.myapplication.fragment.patient.medicalhistory.analysis

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAnalysisResultBinding
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class AnalysisResult : Fragment() {

    private lateinit var binding: FragmentAnalysisResultBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalysisResultBinding.inflate(inflater, container, false)

        binding.imageView1.setOnClickListener {
            binding.imageView45.visibility = View.VISIBLE
        }
        binding.analysisresult.setOnTouchListener { _, event ->
            val imageView = binding.imageView45
            val imageRect = Rect()
            imageView.getGlobalVisibleRect(imageRect)

            if (!imageRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                imageView.visibility = View.GONE
            }
            false
        }
        binding.imageView2.setOnClickListener {
            val uri = Uri.parse("https://docs.google.com/document/d/1er8avOFqmEb5thwdLLUBFAVHr7ha0VbknVk42qagOiE/edit?usp=share_link")
            val request = DownloadManager.Request(uri)

            // Set the destination directory and filename for the downloaded file
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "My report.docx")

            // Set the title and description for the notification that appears during the download
            request.setTitle("Downloading Word document")
            request.setDescription("Please wait while your file is being downloaded.")

            // Get a reference to the system's DownloadManager and enqueue the request
            val downloadManager = requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            downloadManager.enqueue(request)

            // Show a toast message indicating that the download has started
            Toast.makeText(context, "Download started", Toast.LENGTH_SHORT).show()
        }


        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
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