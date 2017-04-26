## CheckBoxGroupDialog

### Android module to add a checkboxgroup dialog in your app

### Usage

#### Using CheckBoxGroupDialog in Activity

```
    CheckBoxGroupDialog checkBoxGroupDialog = new CheckBoxGroupDialog(this);
```

#### Adding CheckBoxElement to  checkBoxGroupDialog

```
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
```

#### showing the button which on clicked will show the dialog

```
    checkBoxGroupDialog.show();
```

#### Demo

<img src="https://github.com/Anwesh43/CheckBoxGroupDialog/blob/master/screencast/checkboxgroupdialog.gif" width="300px" height="500px"> 
