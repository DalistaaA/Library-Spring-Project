package com.sgic.rlp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sgic.rlp.dao.BookDao;
import com.sgic.rlp.models.Book;
import com.sgic.rlp.models.Classification;

public class BookDaoImpl implements BookDao{

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void createBook(Book book) {
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			String SQL ="INSERT INTO book(`book_id`,`book_name`,`published_date`,`sub_classification_id` ) VALUES (?,?,?,?)";
			ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getPublishedDate());
			ps.setInt(4, book.getSubClassificationId());
			
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("Book is created ....");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	}

	@Override
	public Book getBookByID(int bookId) {
		return null;
	}

	@Override
	public void deleteBookById(int bookId) {
		
	}

	@Override
	public List<Book> findAllBook() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			connection = dataSource.getConnection();
			
			String SQL ="SELECT * FROM book";
			ps = connection.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setPublishedDate(rs.getString("published_date"));
				book.setSubClassificationId(rs.getInt("sub_classification_id"));
				bookList.add(book);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public void updateBookById(Book book) {
		
	}
	
}
