package com.example.suitmediatest.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Layout
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.suitmediatest.R

class customButton : AppCompatButton {

    private var txtColor : Int = 0
    private var buttonBackground : Drawable? = null

    constructor(context: Context) :super(context){
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context,attrs, defStyleAttr){
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        background = buttonBackground
        setTextColor(txtColor)
        textSize = 14f
        gravity = Gravity.CENTER
    }

    private fun init(){
        txtColor = ContextCompat.getColor(context, R.color.white)
        buttonBackground = ContextCompat.getDrawable(context, R.drawable.bg_button)
    }

}