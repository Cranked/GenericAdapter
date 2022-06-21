package com.cranked.generictest.adapter

import androidx.recyclerview.widget.DiffUtil

internal class DiffUtilCallback<T>(private val oldItems: List<T>,
                                      private val newItems: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}