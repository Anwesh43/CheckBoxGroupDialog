package com.anwesome.ui.checkboxgroupdialog.elements;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class ButtonElement extends Element {
    private float dir = 0,scale = 0;
    private ButtonClickListener buttonClickListener;
    public void drawElement(Canvas canvas, Paint paint) {
        float h = getSize()/2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#424242"));
        canvas.drawRoundRect(new RectF(0,0,getSize(),h),h/10,h/10,paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        String okText = "OK";
        paint.setTextSize(getSize()/6);
        canvas.drawText(okText,getSize()/2-paint.measureText(okText)/2,paint.getTextSize()/2,paint);
        paint.setColor(Color.parseColor("#99000000"));
        canvas.drawRoundRect(new RectF(0,0,getSize(),h),h/10,h/10,paint);
    }
    public ButtonElement(ButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }
    public void update() {
        scale += dir*0.2f;
        if(scale >= 1) {
            dir = 0;
            if(buttonClickListener!=null) {
                buttonClickListener.onButtonClick();
            }
        }
    }
    protected void startUpdating() {
        if(dir == 0 && scale <= 0) {
            dir = 1;
        }
    }
    public boolean handleTap(float x,float y) {
        boolean conditon =  x>=getX() && x<=getX()+getSize() && y>=getY() && y<=getY()+getSize()/2;
        if(conditon) {
        startUpdating();
        }
        return conditon;
    }
    public interface ButtonClickListener {
        void onButtonClick();
    }
}
