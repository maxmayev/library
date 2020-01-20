package com.gmail.max.client.service;

import com.gmail.max.shared.Book;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;
import java.util.Date;

public interface LibraryControllerAsync {

    void getBooks(AsyncCallback<ArrayList<Book>> async);

    void addBook(int id, String title, String author, Date date, AsyncCallback<Book> async);

    void deleteBookByID(int id, AsyncCallback<Book> async);
}
