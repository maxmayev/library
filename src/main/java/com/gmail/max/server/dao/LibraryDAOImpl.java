package com.gmail.max.server.dao;

import com.gmail.max.shared.Book;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LibraryDAOImpl implements LibraryDAO{

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
    private static final Logger logger = LogManager.getLogger(LibraryDAOImpl.class);


    static final String LOGIN = "library";
    static final String PASSWORD = "1111";

    Connection connection;
    Statement statement;




    @Override
    public ArrayList<Book> getBooksFromDB() {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,LOGIN,PASSWORD);
            statement = connection.createStatement();

            String sql = "select * from book";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                Date publishingDate = resultSet.getDate("publishing_date");

                books.add(new Book (id, name, author, publishingDate));
                logger.info("Get book name : {}" , name);
            }
        } catch (ClassNotFoundException e) {
            logger.error("Error", e);
            return null;
        } catch (SQLException e) {
            logger.error("Error", e);
            return null;
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return books;
    }

    @Override
    public Book addNewBook(int id,String title, String author, Date date) {
        Book book = new Book(id,title,author,date);
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,LOGIN,PASSWORD);
            statement = connection.createStatement();
            SimpleDateFormat stringDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            String sql = String.format("INSERT INTO library.book (`name`, `author`, `publishing_date`) VALUES ('%s', '%s', '%s');",title,author,stringDate.format(date));

            statement.executeUpdate(sql);
            logger.info("Added book name : {}" , title);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return book;
    }

    @Override
    public Book removeBook(int id) {
        Book book = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,LOGIN,PASSWORD);
            statement = connection.createStatement();

            String sql = String.format("select * from book where id=%d;",id);

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int num = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                Date publishingDate = resultSet.getDate("publishing_date");
                book = new Book (num, name, author, publishingDate);
            }


                String sql2 = String.format("delete from book where id=%d;",id);
                statement.executeUpdate(sql2);
            logger.info("Added book id : {}" , id);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return book;
    }
}
