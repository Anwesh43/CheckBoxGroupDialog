package com.anwesome.ui.checkboxgroupdialog.elements;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class CheckBoxGroupDialog {
    private RelativeLayout relativeLayout;
    private Activity activity;
    private boolean isShown = false;
    private DialogView dialogView;
    private DialogButton dialogButton;
    private ViewAnimationController viewAnimationController;
    private List<CheckBoxElement> checkBoxElements = new ArrayList<>();
    private int w,h;
    public CheckBoxGroupDialog(Activity activity) {
        this.activity = activity;
        this.relativeLayout = new RelativeLayout(activity);
    }
    public void initWH() {
        DisplayManager displayManager = (DisplayManager) activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point dimension = new Point();
            display.getRealSize(dimension);
            w = dimension.x;
            h = dimension.y;
        }
    }
    public void addCheckBox(String title, CheckBoxElement.OnCheckChangeListener onCheckChangeListener) {
        if(!isShown) {
            CheckBoxElement checkBoxElement = new CheckBoxElement(title);
            checkBoxElement.setOnCheckChangeListener(onCheckChangeListener);
            checkBoxElements.add(checkBoxElement);
        }
    }
    public void show(String title,float x,float y) {
        if(!isShown) {
            dialogView = new DialogView(activity,checkBoxElements);
            int dialogButtonH = h/12;
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setTextSize(dialogButtonH/2);
            int dialogButtonW = (int)paint.measureText(title)*2;
            dialogButton = new DialogButton(activity,title,paint);
            relativeLayout.addView(dialogButton,new ViewGroup.LayoutParams(dialogButtonW,dialogButtonH));
            viewAnimationController = new ViewAnimationController(dialogButton,dialogView);
            dialogView.setButtonElement(viewAnimationController);
            dialogButton.setViewAnimationController(viewAnimationController);
            dialogView.setScaleX(0);
            dialogView.setScaleY(0);
            dialogView.setVisibility(View.INVISIBLE);
            relativeLayout.addView(dialogView,new ViewGroup.LayoutParams(4*w/5,4*h/5));
            activity.setContentView(dialogView);
            isShown = true;
        }
    }
}
