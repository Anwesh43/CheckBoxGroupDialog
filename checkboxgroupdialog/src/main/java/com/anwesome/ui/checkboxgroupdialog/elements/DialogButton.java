package com.anwesome.ui.checkboxgroupdialog.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class DialogButton extends View {
    private float scale = 0;
    private Paint paint;
    private String title;
    public DialogButton(Context context,String title,Paint paint) {
        super(context);
        this.paint = paint;
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        canvas.save();
        canvas.translate(w/2,h/2);
        canvas.scale(scale,scale);
        paint.setColor(Color.BLACK);
        canvas.drawRoundRect(new RectF(-w/2,-h/2,w/2,h/2),w/10,h/10,paint);
        paint.setColor(Color.WHITE);
        canvas.drawText(title,-paint.measureText(title)/2,paint.getTextSize()/2,paint);
        canvas.restore();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {

        }
        return true;
    }
    public void updateScale(float factor) {
        scale = factor;
        postInvalidate();
    }
}
