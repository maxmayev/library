package com.gmail.max.client.activity;

import java.util.Date;

public interface AbstractMainTableActivity {
    void setView(AbstractMainTableView view);

    void onShowBooks();

    void onBookAdd(int id, String title, String author, Date date);

    void onDeleteBookByID(int id);
}
