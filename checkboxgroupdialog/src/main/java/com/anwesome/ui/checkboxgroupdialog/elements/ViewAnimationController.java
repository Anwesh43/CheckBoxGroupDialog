package com.anwesome.ui.checkboxgroupdialog.elements;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class ViewAnimationController implements Animator.AnimatorListener,ValueAnimator.AnimatorUpdateListener{
    private DialogButton dialogButton;
    private DialogView dialogView;
    private int dir = 0;
    private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
    public ViewAnimationController(DialogButton dialogButton,DialogView dialogView) {
        this.dialogButton = dialogButton;
        this.dialogView = dialogView;
        startAnim.setDuration(500);
        endAnim.setDuration(500);
        startAnim.addUpdateListener(this);
        startAnim.addListener(this);
        endAnim.addListener(this);
        endAnim.addUpdateListener(this);
    }
    public void start() {
        startAnim.start();
        dir = 1;
        dialogView.setVisibility(View.VISIBLE);
    }
    public void end() {
        endAnim.start();
        dir = -1;
    }
    public void onAnimationEnd(Animator animator) {
        if(dir == -1) {
            dialogView.setVisibility(View.INVISIBLE);
        }
    }
    public void onAnimationRepeat(Animator animator) {

    }
    public void onAnimationCancel(Animator animator) {

    }
    public void onAnimationStart(Animator animator) {

    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float factor = (float)(valueAnimator.getAnimatedValue());
        dialogButton.updateScale(1-factor);
        dialogView.setScaleX(factor);
        dialogView.setScaleY(factor);
    }
}
