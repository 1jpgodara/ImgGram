package com.jp.imggram.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jp.imggram.R
import com.jp.imggram.databinding.FragmentTopPhotosBinding
import com.jp.imggram.utils.GenericListAdapter
import com.jp.imggram.utils.GenericViewHolder
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TopPhotosFragment : Fragment() {

    private lateinit var topPhotosViewModel: TopPhotosViewModel
    private lateinit var binding: FragmentTopPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_top_photos,
            container,
            false
        )
        topPhotosViewModel = ViewModelProvider(this).get(TopPhotosViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter = GenericListAdapter(creator = { GenericViewHolder })

        with(binding.imagesList) {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            visible()
        }

        topPhotosViewModel.scope.launch {
            topPhotosViewModel.getTopPhotos().collectLatest {
                listAdapter.submitData(it)
            }
        }
    }
}
