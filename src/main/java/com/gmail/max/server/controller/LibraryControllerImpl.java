package com.gmail.max.server.controller;

import com.gmail.max.shared.Book;
import com.gmail.max.client.service.LibraryController;
import com.gmail.max.server.service.LibraryService;
import com.gmail.max.server.service.LibraryServiceImpl;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;
import java.util.Date;

/**
 * The server side implementation of the RPC service.
 */
//@SuppressWarnings("serial")
public class LibraryControllerImpl extends RemoteServiceServlet implements
        LibraryController {

  private LibraryService libraryService = new LibraryServiceImpl();

  public ArrayList<Book> getBooks() throws IllegalArgumentException {
    return libraryService.getBooksFromDAO();
  }

  public Book addBook(int id,String title,String author, Date date) throws IllegalArgumentException{
    return libraryService.addBookToDAO(id,title,author,date);
  }

  public Book deleteBookByID(int id) throws IllegalArgumentException{
    return libraryService.deleteBookByID(id);
  }
}
