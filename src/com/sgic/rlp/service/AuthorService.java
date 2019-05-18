package com.sgic.rlp.service;

import java.util.List;

import com.sgic.rlp.models.Author;

public interface AuthorService {

	public abstract void addAuthor(Author author);

	public abstract Author fetchClassificationByID(int authorId);

	public abstract void deleteAuthorById(int authorId);

	public abstract void updateAuthorNAmeById(String AuthorName, int authorId);

	public abstract List<Author> findAllAuthorsInfo();
}
