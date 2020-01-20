package com.gmail.max.server.service;

import com.gmail.max.shared.Book;
import com.gmail.max.server.dao.LibraryDAO;
import com.gmail.max.server.dao.LibraryDAOImpl;

import java.util.ArrayList;
import java.util.Date;

public class LibraryServiceImpl implements LibraryService{

    private LibraryDAO libraryDAO = new LibraryDAOImpl();

    @Override
    public ArrayList<Book> getBooksFromDAO() {
        return libraryDAO.getBooksFromDB();
    }

    @Override
    public Book addBookToDAO(int id, String title, String author, Date date) {
        return libraryDAO.addNewBook(id,title,author,date);
    }

    @Override
    public Book deleteBookByID(int id) {
        return libraryDAO.removeBook(id);
    }
}
