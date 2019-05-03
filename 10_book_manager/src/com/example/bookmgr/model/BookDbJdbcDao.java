package com.example.bookmgr.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookDbJdbcDao implements BookDbDao {
	private static Logger logger = LogManager.getLogger(BookDbJdbcDao.class);
	
	private DbConnectionInfo connInfo = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	public BookDbJdbcDao(DbConnectionInfo connInfo) {
		this.connInfo = connInfo;
		try {
			logger.info("Load MySQL JDBC driver class...");
			Class.forName(connInfo.getDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void connect() {
		try {
			logger.info("Connect to MySQL DB server...");
			conn = DriverManager.getConnection(connInfo.getUrl(), connInfo.getUser(), connInfo.getPasswd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void disconnect() {
		try {
			logger.info("Disconnect from MySQL DB server...");
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
			stmt = conn.prepareStatement(sb.toString());
			ResultSet rs = stmt.executeQuery();
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
		
		String sql = "insert into " + connInfo.getDbTable() + " (code, title, writer, price) values (?, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getCode());
			stmt.setString(2, book.getTitle());
			stmt.setString(3,book.getWriter());
			stmt.setInt(4, book.getPrice());
			result = stmt.executeUpdate();
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
		
		String sql = "delete from " + connInfo.getDbTable() + " where code = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, code);
			result = stmt.executeUpdate();
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
		
		String sql = "update " + connInfo.getDbTable() + " set title=?, writer=?, price=? where code=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2,book.getWriter());
			stmt.setInt(3, book.getPrice());
			stmt.setString(4, book.getCode());
			result = stmt.executeUpdate();
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
