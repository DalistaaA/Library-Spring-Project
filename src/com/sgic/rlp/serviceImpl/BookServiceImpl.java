package com.sgic.rlp.serviceImpl;

import java.util.List;

import com.sgic.rlp.dao.BookDao;
import com.sgic.rlp.models.Book;
import com.sgic.rlp.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;
		
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook(Book book) {
		bookDao.createBook(book);
	}

	@Override
	public Book fetchBookByID(int bookId) {
		return bookDao.getBookByID(bookId);
	}

	@Override
	public void deleteBookById(int bookId) {
		bookDao.deleteBookById(bookId);
	}

	@Override
	public void updateBookById(Book book) {
		bookDao.updateBookById(book);
	}

	@Override
	public List<Book> findAllBooksInfo() {
		return bookDao.findAllBook();
	}

}
