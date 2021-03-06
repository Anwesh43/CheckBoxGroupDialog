package com.anwesome.ui.checkboxgroupdialog.elements;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class CheckBoxElement extends Element{
    private String title;
    private float dir = 0,scale = 0f;
    public CheckBoxElement(String title) {
        this.title = title;
    }
    public void update() {
        scale+=dir*0.2f;
        if(scale > 1 || scale < 0) {
            dir = 0;
            if(scale > 1) {
                scale = 1;
            }
            if(scale < 0) {
                scale = 0;
            }
        }
    }
    public void startUpdating() {
        dir = scale <= 0?1:-1;
    }
    protected void drawElement(Canvas canvas,Paint paint) {
        float r = getSize()/20;
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(r/6);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(r,r,r,paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#3F51B5"));
        canvas.save();
        canvas.translate(r,r);
        canvas.scale(scale,scale);
        canvas.drawCircle(0,0,r,paint);
        canvas.restore();
        paint.setColor(Color.BLACK);
        String adjustedTitle = adjustString(paint);
        paint.setTextSize(getSize()/8);
        canvas.drawText(adjustedTitle,3*getSize()/5-paint.measureText(adjustedTitle)/2,getSize()/25+paint.getTextSize()/2,paint);

    }
    private String adjustString(Paint paint) {
        String msg = "";
        for(int i=0;i<title.length();i++) {
            char ch = title.charAt(i);
            if(paint.measureText(msg+ch) > 3*getSize()/5) {
                msg += "..";
                break;
            }
            else {
                msg += ch;
            }
        }
        return msg;
    }
    public void setDimension(float x,float y,float size) {
        super.setDimension(x,y,size);
    }
    public boolean handleTap(float x,float y) {
        boolean condition = x>=getX() && x<=getX()+getSize()/10 && y>=getY() && y<=getY()+getSize()/10;
        if(condition) {
            startUpdating();
        }
        return condition;
    }
    public int hashCode() {
        return (int)(getY())+title.hashCode();
    }
    public boolean stopUpdating() {
        boolean condition = dir == 0;
        if(condition && onCheckChangeListener!=null) {
            if(scale >= 1) {
                onCheckChangeListener.onCheck();
            }
            else {
                onCheckChangeListener.onUnCheck();
            }
        }
        return condition;
    }
    public String getTitle() {
        return title;
    }
    public void setOnCheckChangeListener(OnCheckChangeListener onCheckChangeListener) {
        this.onCheckChangeListener = onCheckChangeListener;
    }
    private OnCheckChangeListener onCheckChangeListener;
    public interface OnCheckChangeListener {
        void onCheck();
        void onUnCheck();
    }
}
