package com.gmail.max.client.view;

import com.gmail.max.client.activity.AbstractMainTableActivity;
import com.gmail.max.client.activity.AbstractMainTableView;
import com.gmail.max.client.activity.MainTableActivityImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

public class DialogBoxView extends DialogBox{
    interface DialogBoxViewUiBinder extends UiBinder<Widget, DialogBoxView> {
    }

    private static DialogBoxViewUiBinder ourUiBinder = GWT.create(DialogBoxViewUiBinder.class);

    public DialogBoxView() {
        setWidget(ourUiBinder.createAndBindUi(this));
    }

    private  AbstractMainTableActivity activityMain = MainTableViewImpl.getActivity();

    @UiField
    DialogBox addDialog;

    @UiField
    TextBox titleTextBox;

    @UiField
    TextBox authorTextBox;

    @UiField
    TextBox dateTextBox;

    @UiField
    Button addDialogButton;

    @UiField
    DatePickerPopupPanelView datePicker;

    public void setVisible(){
        addDialog.setAutoHideEnabled(true);
        addDialog.setAnimationEnabled(true);
        addDialog.setGlassEnabled(true);
        addDialog.center();
        addDialog.show();
        addDialogButton.setFocus(true);
    }

    @UiHandler("addDialogButton")
    public void addDialogButtonClick(ClickEvent event){
        addDialog.hide(true);
        String title = titleTextBox.getText();
        String author = authorTextBox.getText();
        Date date = new Date(dateTextBox.getText());
        activityMain.onBookAdd(5,title,author,date);
    }

    @UiHandler("titleTextBox")
    public void titleEnterPressed(KeyDownEvent e){
        enterKeyPressed(e);
    }
    @UiHandler("authorTextBox")
    public void authorEnterPressed(KeyDownEvent e){
        enterKeyPressed(e);
    }
    @UiHandler("dateTextBox")
    public void dateEnterPressed(KeyDownEvent e){
        enterKeyPressed(e);
    }

    private void enterKeyPressed(KeyDownEvent e) {
        if (e.getNativeKeyCode() == 13) {
            addDialog.hide(true);
            String title = titleTextBox.getText();
            String author = authorTextBox.getText();
            Date date = new Date(dateTextBox.getText());
            activityMain.onBookAdd(5,title,author,date);
        }
    }

    @UiHandler("dateTextBox")
    public void dateTextBoxHandler(ClickEvent e){
        int x=dateTextBox.getAbsoluteLeft();
        int y=dateTextBox.getAbsoluteTop();
        datePicker.show(x,y+20,dateTextBox);
    }

}