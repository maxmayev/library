package com.gmail.max.server.service;

import com.gmail.max.shared.Book;

import java.util.ArrayList;
import java.util.Date;

public interface LibraryService {
    ArrayList<Book> getBooksFromDAO();
    Book addBookToDAO(int id, String title,String author, Date date);
    Book deleteBookByID(int id);
}
