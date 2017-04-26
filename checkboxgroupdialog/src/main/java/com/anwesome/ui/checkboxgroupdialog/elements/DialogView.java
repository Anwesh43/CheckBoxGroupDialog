package com.anwesome.ui.checkboxgroupdialog.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class DialogView extends View {
    private int time = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private List<CheckBoxElement> checkBoxElements = new ArrayList<>();
    private ButtonElement buttonElement;
    private DialogAnimationController dialogAnimationController;
    public DialogView(Context context,List<String> titles) {
        super(context);
        initCheckBoxes(titles);
        buttonElement = new ButtonElement(new ButtonElement.ButtonClickListener() {
            @Override
            public void onButtonClick() {
                setVisibility(INVISIBLE);
            }
        });
    }
    public void initCheckBoxes(List<String> titles) {
        for(String title:titles) {
            checkBoxElements.add(new CheckBoxElement(title));
        }
        dialogAnimationController = new DialogAnimationController(this,checkBoxElements);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        int w = canvas.getWidth(),h = canvas.getHeight();
        if(time == 0) {
            int y = h/30,gap = h/15;
            for(CheckBoxElement checkBoxElement:checkBoxElements) {
                checkBoxElement.setDimension(w/10,y,4*w/5);
                y+=(3*gap/2);
            }
            buttonElement.setDimension(w/3,h-h/9,w/4);
        }
        for(CheckBoxElement checkBoxElement:checkBoxElements) {
            checkBoxElement.draw(canvas,paint);
        }
        buttonElement.draw(canvas,paint);
        time++;
        dialogAnimationController.animate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX(), y = event.getY();
            if(buttonElement.handleTap(x,y)) {
                dialogAnimationController.addToAnimQueue(buttonElement);
            }
            for(CheckBoxElement checkBoxElement:checkBoxElements) {
                if(checkBoxElement.handleTap(x,y)) {
                    dialogAnimationController.addToAnimQueue(checkBoxElement);
                }
            }
        }
        return true;
    }
}
