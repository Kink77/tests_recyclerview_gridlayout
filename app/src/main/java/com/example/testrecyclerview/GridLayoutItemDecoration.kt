package com.example.testrecyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridLayoutItemDecoration(var horizontalGutter: Int, var verticalGutter: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val halfHorizontalGutter = horizontalGutter / 2
        val halfVerticalGutter = verticalGutter / 2
        outRect.left = halfVerticalGutter
        outRect.top = halfHorizontalGutter
        outRect.right = halfVerticalGutter
        outRect.bottom = halfHorizontalGutter
    }
}