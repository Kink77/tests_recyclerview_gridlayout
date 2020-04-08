package com.example.testrecyclerview

import android.content.res.Configuration
import android.graphics.Rect
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyRecyclerViewAdapter
    private val gridLayoutManager: GridLayoutManager by lazy {
        GridLayoutManager(this, getNumberOfColumnsForGridLayout())
    }
    private val gridLayoutItemDecoration: GridLayoutItemDecoration =
        GridLayoutItemDecoration(0, 0)

    private val seed = arrayOf(
        R.drawable.country,
        R.drawable.documentary,
        R.drawable.electronic,
        R.drawable.folk
    )

    private val randomizer = Random(305992)

    private val data: IntArray =
        IntArray(13) { _ -> seed[randomizer.nextInt(IntRange(0, seed.size - 1))] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recycler_view.layoutManager = gridLayoutManager

        adapter = MyRecyclerViewAdapter(this, data.toTypedArray())
        recycler_view.adapter = adapter

        updateGridLayoutItemDecoration()
        recycler_view.addItemDecoration(gridLayoutItemDecoration)
        updateRecyclerViewPadding()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updateOrientationConfigs()
    }

    private fun getNumberOfColumnsForGridLayout(): Int {
        return resources.getInteger(R.integer.gridlayout_columns)
    }

    private fun getHorizontalGutterPxForGridLayout(): Int {
        return resources.getInteger(R.integer.gridlayout_horizontal_gutter).fromDPToPixel()
    }

    private fun getVerticalGutterPxForGridLayout(): Int {
        return resources.getInteger(R.integer.gridlayout_vertical_gutter).fromDPToPixel()
    }

    private fun getRecyclerViewPaddingPx(): Rect {
        return Rect(
            resources.getInteger(R.integer.recyclerview_left_padding).fromDPToPixel(),
            resources.getInteger(R.integer.recyclerview_top_padding).fromDPToPixel(),
            resources.getInteger(R.integer.recyclerview_right_padding).fromDPToPixel(),
            resources.getInteger(R.integer.recyclerview_bottom_padding).fromDPToPixel()
        )
    }

    private fun updateRecyclerViewPadding() {
        val padding = getRecyclerViewPaddingPx()
        recycler_view.setPadding(padding.left, padding.top, padding.right, padding.bottom)
    }

    private fun updateGridLayoutItemDecoration() {
        val horizontalGutter = getHorizontalGutterPxForGridLayout()
        if (horizontalGutter != gridLayoutItemDecoration.horizontalGutter) {
            gridLayoutItemDecoration.horizontalGutter = horizontalGutter
        }
        val verticalGutter = getVerticalGutterPxForGridLayout()
        if (verticalGutter != gridLayoutItemDecoration.verticalGutter) {
            gridLayoutItemDecoration.verticalGutter = verticalGutter
        }
    }

    private fun updateGridLayoutSpanCount() {
        gridLayoutManager.spanCount = getNumberOfColumnsForGridLayout()
    }

    private fun updateOrientationConfigs() {
        updateGridLayoutSpanCount()
        updateGridLayoutItemDecoration()
        updateRecyclerViewPadding()
        recycler_view.invalidateItemDecorations()
    }
}
