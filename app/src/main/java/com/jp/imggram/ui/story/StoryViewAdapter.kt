package com.jp.imggram.ui.story

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StoryViewAdapter<T>(
    data: List<T>?,
    private val itemClickListener: ((Int, T?) -> Unit)? = null,
    internal val creator: (ViewGroup, Int) -> StoryViewHolder<T>,
    private val viewType: ((T?) -> Int)?
) : RecyclerView.Adapter<StoryViewHolder<T>>() {

    private var data: List<T>? = null

    init {
        if (data != null) {
            this.data = data
        }
    }

    fun getItem(position: Int) = data?.get(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder<T> {
        return creator(parent, viewType)
    }

    override fun onBindViewHolder(holder: StoryViewHolder<T>, position: Int) {
        holder.bind(data?.get(position))
        itemClickListener?.let {
            holder.itemView.setOnClickListener { it(holder.layoutPosition, data?.get(position)) }
        }
    }

    override fun getItemCount(): Int {
        return if (data != null) {
            data!!.size
        } else 0
    }

    fun setData(newData: ArrayList<T>?) {
        if (newData != null) {
            data = newData
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (viewType != null) {
            return viewType.invoke(data?.get(position))
        }
        return super.getItemViewType(position)
    }
}
