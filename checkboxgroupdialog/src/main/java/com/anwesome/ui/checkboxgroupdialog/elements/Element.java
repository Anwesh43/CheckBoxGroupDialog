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
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        canvas.restore();
    }
    public void update() {;

    }
    public boolean stopUpdating() {
        return false;
    }
    public void startUpdating() {

    }
    public void setDimension(float x,float y,float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}
