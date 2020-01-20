package com.gmail.max.client.activity;

import com.gmail.max.shared.Book;
import com.google.gwt.user.client.ui.FlexTable;

import java.util.ArrayList;

public interface AbstractMainTableView {
    void initMainTable(FlexTable flexTable);
    void fillTable (ArrayList<Book> bookList);
    void resetTable();
}
