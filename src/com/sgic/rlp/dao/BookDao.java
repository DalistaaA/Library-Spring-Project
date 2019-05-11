package com.sgic.rlp.dao;

import java.util.List;

import com.sgic.rlp.models.Book;

public interface BookDao {

	public abstract void createBook(Book book);

	public abstract Book getBookByID(int bookId);

	public abstract void deleteBookById(int bookId);

	public abstract void updateBookByName(String newBookName, int bookId);

	public abstract List<Book> findAllBook();
}
