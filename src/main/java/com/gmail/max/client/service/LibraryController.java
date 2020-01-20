package com.gmail.max.client.service;

import com.gmail.max.shared.Book;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;
import java.util.Date;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface LibraryController extends RemoteService {
  ArrayList<Book> getBooks() throws IllegalArgumentException;
  Book addBook(int id,String title,String author, Date date) throws IllegalArgumentException;
  Book deleteBookByID(int id) throws IllegalArgumentException;
}
