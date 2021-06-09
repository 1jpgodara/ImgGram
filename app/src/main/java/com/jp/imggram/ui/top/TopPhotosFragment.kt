package com.jp.imggram.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jp.imggram.R

class TopPhotosFragment : Fragment() {

    private lateinit var topPhotosViewModel: TopPhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_top_photos, container, false)

        topPhotosViewModel = ViewModelProvider(this).get(TopPhotosViewModel::class.java)
        topPhotosViewModel.text.observe(viewLifecycleOwner) {

        }

        return root
    }
}
