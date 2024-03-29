package com.hongwei.android_view_drawing_sample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View

class DrawingView : View {
    val paint = Paint()

    var progress: Float = 0f

    constructor(context: Context) : super(context) {
        initialize(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initialize(context)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawProgress(canvas!!, progress)
    }

    fun initialize(context: Context) {
        val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getColor(R.color.colorAccent)
        } else {
            Color.BLUE
        }
        paint.color = color
        paint.setAntiAlias(true)
    }

    fun drawProgress(canvas: Canvas, progress: Float) {
        val w = width.toFloat()
        val h = height * progress

        val path = Path()

        val drawingWidth = 20f
        
        path.moveTo(0f, 0f)
        path.lineTo(0f, h)
        path.lineTo(drawingWidth, h)
        path.lineTo(drawingWidth, 0f)
        path.close()

        canvas.drawPath(path, paint)
    }

}