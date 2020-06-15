package com.indra.coronaradar.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class SelectableGroupLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), SelectableGroup {

    override fun onChildSelected(view: View) {
        view.isSelected = true
        for (x in 0 until childCount)
            getChildAt(x)?.let {
                if (it != view)
                    it.isSelected = false
            }
    }

}