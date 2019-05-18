package com.sgic.rlp.serviceImpl;

import java.util.List;

import com.sgic.rlp.dao.AuthorDao;
import com.sgic.rlp.models.Author;
import com.sgic.rlp.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

	private AuthorDao authorDao;
	
	public AuthorDao getAuthorDao() {
		return authorDao;
	}
	
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}
	
	@Override
	public void addAuthor(Author author) {
		authorDao.createAuthor(author);
		
	}

	@Override
	public Author fetchClassificationByID(int authorId) {
		return authorDao.getAuthorByID(authorId);
	}

	@Override
	public void deleteAuthorById(int authorId) {
		authorDao.deleteAuthorById(authorId);
		
	}

	

	@Override
	public List<Author> findAllAuthorsInfo() {// TODO Auto-generated method stub
		return authorDao.findAllAuthor();
	}

	@Override
	public void updateAuthorNAmeById(String AuthorName, int authorId) {
		// TODO Auto-generated method stub
		
	}

}
