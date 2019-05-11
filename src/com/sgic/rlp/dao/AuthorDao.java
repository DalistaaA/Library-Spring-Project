package com.sgic.rlp.dao;

import java.util.List;

import com.sgic.rlp.models.Author;

public interface AuthorDao {

	public abstract void createAuthor(Author author);

	public abstract Author getAuthorByID(int authorId);

	public abstract void deleteAuthorById(int authorId);

	public abstract void updateAuthorByName(String newAuthornName, int classificationId);

	public abstract List<Author> findAllAuthor();
}
