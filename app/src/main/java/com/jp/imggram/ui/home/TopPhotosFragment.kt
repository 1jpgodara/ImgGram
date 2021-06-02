package com.jp.imggram.ui.home

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
        topPhotosViewModel =
                ViewModelProvider(this).get(TopPhotosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_top_photos, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        topPhotosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}