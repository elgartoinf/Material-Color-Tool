package com.jheank16oz.materialcolortool.selectcolor

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.model.ColorItem
import kotlinx.android.synthetic.main.selectcolor_color_item.view.*


class SelectColorViewHolder(itemView: View, private val mCallbacks: Callbacks?) : RecyclerView.ViewHolder(itemView), DividerDecoration.Divided {

    private var mColor: ColorItem? = null

    init {

        itemView.setOnClickListener(View.OnClickListener {
            if (mCallbacks == null || mColor == null) {
                return@OnClickListener
            }
            mColor?.let {
                mCallbacks.onColorClicked(1)
            }
        })

    }



    fun bind(item: ColorItem) {
        mColor = item
        val context = itemView.context
        itemView.name.text =  item.name
        itemView.name.setTextColor(Color.parseColor(item.primaryTextColor))
        itemView.valueHex.setTextColor(Color.parseColor(item.primaryTextColor))
        itemView.setBackgroundColor(Color.parseColor(item.primaryColor))
        itemView.valueHex.text = item.primaryColor

    }
    interface Callbacks {
        /**
         * @param colorId The ID of the color
         */
        fun onColorClicked(colorId: Int)

    }

    companion object {

        fun newInstance(parent: ViewGroup, callbacks: Callbacks): SelectColorViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = inflater.inflate(R.layout.selectcolor_color_item, parent, false)
            return SelectColorViewHolder(itemView, callbacks)
        }
    }
}