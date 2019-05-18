package com.sgic.rlp.models;

public class Book {

	private int bookId;
	private String bookName;
	private String publishedDate;
	private int subClassificationId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getSubClassificationId() {
		return subClassificationId;
	}

	public void setSubClassificationId(int subClassificationId) {
		this.subClassificationId = subClassificationId;
	}

}
