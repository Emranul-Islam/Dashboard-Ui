package com.emranul.dashboardui

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class CustomLinearLayoutManager(
    context: Context,
    private val mShrinkDistance: Float = 2f,
    private val mShrinkAmount: Float = 0.15f) :
    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) {


    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        scaleChildren()
    }


    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        return if (orientation == HORIZONTAL){
            super.scrollHorizontallyBy(dx, recycler, state).also { scaleChildren() }

        }else{
            0
        }

    }

    private fun scaleChildren() {

        /**
         *  ekhane amra amader layout er width er size take devide kore
         *  kon jaygay item size boro hobe ta bahir korechi
         * */
        val midpoint = width /3.8f

        /**
         * ar ekhane amra bahir korechi koto toko se boro hoye scroll korbe
         * */
        val d1 = mShrinkDistance * midpoint
        for (i in 0 until childCount) {
            val child = getChildAt(i) as View
            val d = d1.coerceAtMost(abs(midpoint - (getDecoratedRight(child) + getDecoratedLeft(child)) / 2f)
            )
            val scale = 1f - mShrinkAmount * d / d1
            child.scaleX = scale
            child.scaleY = scale
        }
    }


}