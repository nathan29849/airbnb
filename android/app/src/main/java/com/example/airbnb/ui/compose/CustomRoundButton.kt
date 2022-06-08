package com.example.airbnb.ui.compose

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.example.airbnb.R
import com.example.airbnb.databinding.CustomRoundButtonBinding

class CustomRoundButton : LinearLayout {
    lateinit var binding: CustomRoundButtonBinding

    constructor(context: Context?) : super(context) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
        getAttrs(attrs)

    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
        getAttrs(attrs, defStyleAttr)
    }

    private fun init(context: Context?) {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.custom_round_button,
            this,
            false
        )
        addView(binding.root)
    }

    private fun getAttrs(attrs: AttributeSet?) {
        // attrs 를 참조함
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRoundButton)
        setTypeArray(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet?, defStyle: Int) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CustomRoundButton, defStyle, 0)
        setTypeArray(typedArray)
    }

    //디폴트 설정
    private fun setTypeArray(typedArray: TypedArray) {

        val backgroundLayout = typedArray.getResourceId(R.styleable.CustomRoundButton_bgDrawable, R.drawable.custom_button_background)
        binding.llCustomButtonContainer.setBackgroundResource(backgroundLayout)

        val imgResId = typedArray.getResourceId(R.styleable.CustomRoundButton_imgColor,R.drawable.ic_baseline_menu_24)
        binding.ivCustomButtonIcon.setBackgroundResource(imgResId)

        val textColor = typedArray.getColor(R.styleable.CustomRoundButton_textColor,0)
        binding.tvCustomButtonText.setTextColor(textColor)

        val text = typedArray.getText(R.styleable.CustomRoundButton_text)
        binding.tvCustomButtonText.text = text

        typedArray.recycle()
    }
}