package com.gmail.max.client.activity;

import com.gmail.max.shared.Book;
import com.gmail.max.client.service.LibraryController;
import com.gmail.max.client.service.LibraryControllerAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


public class MainTableActivityImpl implements AbstractMainTableActivity {
    private final LibraryControllerAsync libraryControllerAsync = GWT.create(LibraryController.class);
    private AbstractMainTableView view;

    @Override
    public void setView(AbstractMainTableView view) {
        this.view = view;
    }

    @Override
    public void onShowBooks() {
        libraryControllerAsync.getBooks(new AsyncCallback<ArrayList<Book>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.toString());
            }

            @Override
            public void onSuccess(ArrayList<Book> result) {
                 view.fillTable(result);
            }
        });
    }

    @Override
    public void onBookAdd(int id, String title, String author, Date date) {
        libraryControllerAsync.addBook(id, title, author, date, new AsyncCallback<Book>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.toString());
            }

            @Override
            public void onSuccess(Book result) {
                Window.alert("Book with title : " + result.getTitle() + " , author : " +result.getAuthor() + ", publishing date : " +result.getDate().toString()+ " was added");
                onShowBooks();
            }
        });
    }

    @Override
    public void onDeleteBookByID(int id) {
        libraryControllerAsync.deleteBookByID(id, new AsyncCallback<Book>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.toString());
            }

            @Override
            public void onSuccess(Book result) {
                Window.alert("Book with title : " + result.getTitle() + " , author : " +result.getAuthor() + ", publishing date : " +result.getDate().toString()+ " was removed");
                onShowBooks();
            }
        });
    }
}
