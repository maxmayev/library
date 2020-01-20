package com.gmail.max.client.view;

import com.gmail.max.client.Messages;
import com.gmail.max.client.activity.AbstractMainTableActivity;
import com.gmail.max.client.activity.AbstractMainTableView;
import com.gmail.max.client.activity.MainTableActivityImpl;
import com.gmail.max.shared.Book;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;

public class MainTableViewImpl extends Composite implements AbstractMainTableView {
    interface MainTableViewUiBinder extends UiBinder<Widget, MainTableViewImpl> {
    }
    private static MainTableViewUiBinder ourUiBinder = GWT.create(MainTableViewUiBinder.class);

    public Messages messages = GWT.create(Messages.class);

    private static AbstractMainTableActivity activity = new MainTableActivityImpl();


    public static AbstractMainTableActivity getActivity() {
        return activity;
    }

    @UiField
    Button showBooks;

    @UiField
    FlexTable bookTable;

    @UiField
    Button addBooks;

    @UiField
    VerticalPanel verticalPanel;

    @UiField
    HorizontalPanel horizontalPanel;


    public MainTableViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initMainView();
        initMainTable(bookTable);
        activity.setView(this);

    }

    @Override
    public void initMainTable(FlexTable bookTable){
        bookTable.setText(0,0,"ID");
        bookTable.setText(0,1,messages.titleField());
        bookTable.setText(0,2,messages.authorField());
        bookTable.setText(0,3,messages.dateField());
        bookTable.setText(0,4,messages.actionField());
        bookTable.setText(0,5,messages.removeField());
        bookTable.getRowFormatter().addStyleName(0,"headerMainTable");
    }

    @Override
    public void fillTable(ArrayList<Book> bookList) {
        resetTable();
        for (int i = 0; i < bookList.size() ; i++) {
            bookTable.setText(i+1,0,String.valueOf(bookList.get(i).getId()));
            bookTable.setText(i+1,1,String.valueOf(bookList.get(i).getTitle()));
            bookTable.setText(i+1,2,String.valueOf(bookList.get(i).getAuthor()));
            bookTable.setText(i+1,3,String.valueOf(bookList.get(i).getDate()));
            Button dellButton = new Button();
            dellButton.setText("remove");
            dellButton.setTabIndex(bookList.get(i).getId());
            dellButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    activity.onDeleteBookByID(dellButton.getTabIndex());
                }
            });
            bookTable.setWidget(i+1,5,dellButton);
        }
    }

    @Override
    public void resetTable() {
        bookTable.removeAllRows();
        initMainView();
        initMainTable(bookTable);
    }

    @UiHandler({"showBooks"})
    public void showButtonClick(ClickEvent event){
            resetTable();
            activity.onShowBooks();
    }

    @UiHandler("addBooks")
    public void addButtonClick(ClickEvent event){
        new DialogBoxView().setVisible();
    }



    public void initMainView(){
        showBooks.setText(messages.showBooks());
        addBooks.setText(messages.addBooks());
        horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
    }

}