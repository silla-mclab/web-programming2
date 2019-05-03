package com.example.bookmgr.model;

import java.util.ArrayList;

public interface BookDbDao {
	public void connect();
	public void disconnect();	
	public ArrayList<Book> getBooks(String code);
	public int insertBook(Book book);
	public int deleteBook(String code);
	public int updateBook(Book book);
}
