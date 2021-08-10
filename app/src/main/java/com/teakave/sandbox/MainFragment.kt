package com.teakave.sandbox

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layoutContainer = inflater.inflate(R.layout.fragment_main, container, false)
        setupWindyButton(layoutContainer)
        return layoutContainer
    }

    private fun setupWindyButton(layoutContainer: View) {
        layoutContainer.findViewById<Button>(R.id.button_to_home_screen).setOnClickListener {
            startActivity(Intent(requireContext(), HomeScreenWallpaperActivity::class.java))
        }
    }


}