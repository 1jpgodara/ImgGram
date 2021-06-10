package com.jp.imggram.ui.top

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jp.imggram.data.ImgurRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow

class TopPhotosViewModel : ViewModel() {
    private val repository = ImgurRepository()

    private val job = Job()
    val scope = CoroutineScope(job + Dispatchers.IO)

    private var phtoos: Flow<PagingData<String>>? = null

    fun getTopPhotos(): Flow<PagingData<String>> {
        val lastResult = phtoos
        if (lastResult != null) return lastResult
        val newResult: Flow<PagingData<String>> = repository.getTopImages().cachedIn(scope)
        phtoos = newResult
        return newResult
    }

    override fun onCleared() {
        super.onCleared()
        scope.coroutineContext.cancelChildren()
    }
}

