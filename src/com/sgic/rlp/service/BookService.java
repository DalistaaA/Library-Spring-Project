package com.sgic.rlp.service;

import java.util.List;

import com.sgic.rlp.models.Book;;

public interface BookService {

	public abstract void addBook(Book book);

	public abstract Book fetchBookByID(int bookId);

	public abstract void deleteBookById(int bookId);

	public abstract void updateBookById(Book book);

	public abstract List<Book> findAllBooksInfo();
}
