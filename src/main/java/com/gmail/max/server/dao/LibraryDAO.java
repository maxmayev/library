package com.gmail.max.server.dao;

import com.gmail.max.shared.Book;

import java.util.ArrayList;
import java.util.Date;

public interface LibraryDAO {
    ArrayList<Book> getBooksFromDB();
    Book addNewBook(int id, String title, String author, Date date);
    Book removeBook(int id);
}
