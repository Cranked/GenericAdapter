package com.cranked.generictest.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<in T>(layoutResId: Int,private val items: MutableList<T>,
                              private val bindHolder: View.(T) -> Unit,
                              private val itemClick: T.() -> Unit = {})
    : AbstractAdapter<T>(layoutResId,items) {

    override fun onItemClick(itemView: View, position: Int) {
        items[position].itemClick()
    }

    override fun View.bind(item: T) {
        bindHolder(item)
    }
}

fun <T> RecyclerView.insertInto(items: MutableList<T>,
                                   layoutResId: Int,
                                   bindHolder: View.(T) -> Unit,
                                   itemClick: T.() -> Unit = {},
                                   manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
): GenericAdapter<T> {

    layoutManager = manager
    return GenericAdapter( layoutResId,items, bindHolder, itemClick).apply { adapter = this }
}