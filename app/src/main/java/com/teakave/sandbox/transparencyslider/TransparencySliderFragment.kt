package com.teakave.sandbox.transparencyslider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.teakave.sandbox.R

class TransparencySliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutContainer =
            inflater.inflate(R.layout.fragment_transparency_slider, container, false)
        setupTransparencySeekbar(layoutContainer)
        return layoutContainer
    }

    private fun setupTransparencySeekbar(layoutContainer: View) {
        val transparencyImage = layoutContainer.findViewById<ImageView>(R.id.image_transparency)

        val seekbar = layoutContainer.findViewById<SeekBar>(R.id.seekbar_transparency)

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                transparencyImage.alpha = (progress * 0.01).toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        })

        seekbar.progress = 50
    }

}