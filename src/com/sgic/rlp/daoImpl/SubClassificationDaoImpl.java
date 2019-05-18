package com.sgic.rlp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sgic.rlp.dao.SubClassificationDao;
import com.sgic.rlp.models.SubClassification;

public class SubClassificationDaoImpl implements SubClassificationDao {

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void createSubClassification(SubClassification subClassification) {
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			String SQL ="INSERT INTO sub_classification(`sub_classification_id`,`sub_classification_name`,`classification_id`) VALUES (?,?,?)";
			ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, subClassification.getSubclassificationId());
			ps.setString(2, subClassification.getSubclassificationName());
		    ps.setInt(3, subClassification.getClassificationId());
			
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("Sub Classification is created ....");
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
	public SubClassification getSubClassificationByID(int subclassificationId) {
		return null;
	}

	@Override
	public void deleteSubClassificationById(int subclassificationId) {

	}

	@Override
	public void updateSubClassificationById(SubClassification subClassification) {

	}

	@Override
	public List<SubClassification> findAllSubClassification() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<SubClassification> subClassificationList = new ArrayList<SubClassification>();
		
		try {
			connection = dataSource.getConnection();
			
			String SQL ="SELECT * FROM sub_classification";
			ps = connection.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SubClassification subClassification = new SubClassification();
				subClassification.setSubclassificationId(rs.getInt("sub_classification_id"));
				subClassification.setSubclassificationName(rs.getString("sub_classification_name"));
				subClassification.setClassificationId(rs.getInt("classification_id"));
				subClassificationList.add(subClassification);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subClassificationList;
	}

}