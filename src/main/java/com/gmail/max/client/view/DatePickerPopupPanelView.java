package com.gmail.max.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

public class DatePickerPopupPanelView extends Composite {
    interface DatePickerPopupPanelViewUiBinder extends UiBinder<HTMLPanel, DatePickerPopupPanelView> {
    }

    private static DatePickerPopupPanelViewUiBinder ourUiBinder = GWT.create(DatePickerPopupPanelViewUiBinder.class);

    public DatePickerPopupPanelView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
    @UiField
    PopupPanel popupPanel;

    @UiField
    DatePicker datePicker;

    public void show(int x, int y, TextBox dataTextBox){
        datePicker.addValueChangeHandler(event -> {
            Date date=event.getValue();
            dataTextBox.setText(DateTimeFormat.getFormat("yyyy-MM-dd").format(date));
            popupPanel.hide();
        });
        popupPanel.setPopupPosition(x,y);
        popupPanel.show();
    }




}