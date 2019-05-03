package com.example.bookmgr.control;

import java.util.List;

import com.example.bookmgr.model.Book;
import com.example.bookmgr.model.BookDbDao;
import com.example.bookmgr.model.BookDbJdbcDao;
import com.example.bookmgr.model.DbConnectionInfo;

public class BookMgrService {

	private BookDbDao dao = null;
	
	public BookMgrService(DbConnectionInfo connInfo) {
		dao = new BookDbJdbcDao(connInfo);
	}
	
	public List<Book> getBookList() {
		return dao.getBooks("all");
	}
	
	public Book searchBook(String code) {
		Book book = null;
		
		if (code != null || code != "") {
			List<Book> list = dao.getBooks(code);
			if (list != null) {
				book = list.get(0);
			}
		}
		
		return book;
	}
	
	public int insertBook(Book book) {
		int result = -1;
		
		if (book != null) {
			result = dao.insertBook(book);
		}
		
		return result;
	}
	
	public int deleteBook(String code) {
		int result = -1;
		
		if (code != null && code != "") {
			result = dao.deleteBook(code);
		}
		
		return result;
	}
	
	public int updateBook(Book book) {
		int result = -1;
		
		if (book != null) {
			result = dao.updateBook(book);
		}
		
		return result;
	}	
}
