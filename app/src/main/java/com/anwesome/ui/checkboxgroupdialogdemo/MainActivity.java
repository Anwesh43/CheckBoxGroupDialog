package com.anwesome.ui.checkboxgroupdialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.checkboxgroupdialog.elements.CheckBoxElement;
import com.anwesome.ui.checkboxgroupdialog.elements.CheckBoxGroupDialog;

public class MainActivity extends AppCompatActivity {
    private String options[] = {"Yes","No","More"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBoxGroupDialog checkBoxGroupDialog = new CheckBoxGroupDialog(this);
        for(int i=0;i<options.length;i++) {
            final String option = options[i];
            checkBoxGroupDialog.addCheckBox(option, new CheckBoxElement.OnCheckChangeListener() {
                @Override
                public void onCheck() {
                    Toast.makeText(MainActivity.this, option+" selected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onUnCheck() {
                    Toast.makeText(MainActivity.this, option+" unselected", Toast.LENGTH_SHORT).show();
                }
            });
        }
        checkBoxGroupDialog.show("Is something wrong?",0,400);
    }
}
