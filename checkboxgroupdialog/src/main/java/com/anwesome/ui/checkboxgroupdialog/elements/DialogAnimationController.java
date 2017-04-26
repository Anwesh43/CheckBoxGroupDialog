package com.anwesome.ui.checkboxgroupdialog.elements;

import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 26/04/17.
 */
public class DialogAnimationController {
    private List<CheckBoxElement> checkBoxElements = new ArrayList<>();
    private View view;
    public DialogAnimationController(View view,List<CheckBoxElement> checkBoxElements) {
        this.view = view;
        this.checkBoxElements = checkBoxElements;
    }
    private ConcurrentLinkedQueue<Element> elements = new ConcurrentLinkedQueue<>();
    private boolean isAnimated = false;
    public void animate() {
        if(isAnimated) {
            for(Element element:elements) {
                element.update();
                if(element.stopUpdating()) {
                    elements.remove(element);
                    if(elements.size() == 0) {
                        isAnimated = false;
                        break;
                    }
                }
            }
            try {
                Thread.sleep(50);
                view.invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    private boolean isFirstElementButton() {
        for(Element element:elements) {
            if(element instanceof ButtonElement) {
                return true;
            }
        }
        return false;
    }
    public void addToAnimQueue(Element element) {
        if(element instanceof ButtonElement && elements.size() == 0 && !isAnimated) {
            isAnimated = true;
            elements.add(element);
            view.postInvalidate();
        }
        else if(!(elements.size() == 1 && isFirstElementButton())) {
            boolean firstCheckBoxElement = elements.size() == 0;
            elements.add(element);
            if(firstCheckBoxElement) {
                isAnimated = true;
                view.postInvalidate();
            }
        }
    }
}
