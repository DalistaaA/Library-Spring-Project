package com.sgic.rlp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.sgic.rlp.dao.AuthorDao;
import com.sgic.rlp.models.Author;

public class AuthorDaoImpl implements AuthorDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void createAuthor(Author author) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();

			String SQL = "INSERT INTO author(`author_id`,`author_name`) VALUES (?,?)";
			ps = connection.prepareStatement(SQL);

			ps.setLong(1, author.getAuthorId());
			ps.setString(2, author.getAuthorName());

			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("Author is created ....");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}

	}

	@Override
	public Author getAuthorByID(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuthorById(int authorId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAuthorByName(String newAuthornName, int classificationId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Author> findAllAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

}
