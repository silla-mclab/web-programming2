package com.example.bookmgr.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDbJdbcOrigDao implements BookDbDao {
	private DbConnectionInfo connInfo = null;
	private Connection conn = null;
	private Statement stmt = null;
	
	public BookDbJdbcOrigDao(DbConnectionInfo connInfo) {
		this.connInfo = connInfo;
		try {
			Class.forName(connInfo.getDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void connect() {
		try {
			conn = DriverManager.getConnection(connInfo.getUrl(), connInfo.getUser(), connInfo.getPasswd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void disconnect() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Book> getBooks(String code) {
		ArrayList<Book> books = null;
		
		connect();
		
		StringBuilder sb = new StringBuilder("select * from ");
		sb.append(connInfo.getDbTable());
		if (!code.equals("all")) {
			sb.append(" where code = ");
			sb.append(code);
			sb.append(";");
		}

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sb.toString());
			if (rs.isBeforeFirst()) {
				books = new ArrayList<Book>();
				while (rs.next()) {
					Book book = new Book();
					
					book.setCode(rs.getString("code"));
					book.setTitle(rs.getString("title"));
					book.setWriter(rs.getString("writer"));
					book.setPrice(rs.getInt("price"));
					
					books.add(book);
				}
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return books;
	}

	@Override
	public int insertBook(Book book) {
		int result = 0;
		
		connect();
		
		String sql = String.format("insert into %s (code, title, writer, price) values ('%s', '%s', '%s', %d);", 
						connInfo.getDbTable(), book.getCode(), book.getTitle(), book.getWriter(), book.getPrice());
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		finally {
			disconnect();
		}
		
		return result;
	}

	@Override
	public int deleteBook(String code) {
		int result = 0;
		
		connect();
		
		String sql = String.format("delete from %s where code = '%s';", connInfo.getDbTable(), code);
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		finally {
			disconnect();
		}
		
		return result;	
	}

	@Override
	public int updateBook(Book book) {
		int result = 0;
		
		connect();
		
		String sql = String.format("update %s set title='%s', writer='%s', price=%d where code='%s';",
						connInfo.getDbTable(), book.getTitle(), book.getWriter(), book.getPrice(), book.getCode());
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		finally {
			disconnect();
		}
		
		return result;
	}

}
