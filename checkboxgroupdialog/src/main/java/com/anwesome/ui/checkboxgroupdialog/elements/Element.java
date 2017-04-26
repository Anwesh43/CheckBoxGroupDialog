package com.anwesome.ui.checkboxgroupdialog.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class Element {
    private float x,y,size;
    public float getSize() {
        return size;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        drawElement(canvas,paint);
        canvas.restore();
    }
    protected void drawElement(Canvas canvas,Paint paint) {

    }
    public void update() {;

    }
    public boolean stopUpdating() {
        return false;
    }
    protected void startUpdating() {

    }
    public void setDimension(float x,float y,float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}
