package com.jp.imggram.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jp.imggram.R

class HotPhotosFragment : Fragment() {

    private lateinit var hotPhotosViewModel: HotPhotosViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        hotPhotosViewModel = ViewModelProvider(this).get(HotPhotosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_hot_photos, container, false)
        val textView: TextView = root.findViewById(R.id.text_photos)
        hotPhotosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
