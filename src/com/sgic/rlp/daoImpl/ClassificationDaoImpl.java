package com.sgic.rlp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sgic.rlp.dao.ClassificationDao;
import com.sgic.rlp.models.Classification;

public class ClassificationDaoImpl implements ClassificationDao{

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void createClassification(Classification classification) {
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			String SQL ="INSERT INTO classification(`classification_id`,`classification_name` ) VALUES (?,?)";
			ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, classification.getClassificationId());
			ps.setString(2, classification.getClassificationName());
			
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("Classification is created ....");
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
	public Classification getClassificationByID(int classificationId) {
		Connection connection = null;
		PreparedStatement ps = null;
		
		Classification classificatonlistById = null;
		
		try {
			connection = dataSource.getConnection();
			
			String SQL ="SELECT classification_id, classification_name FROM classification classification_id = '"+classificationId+"'";
			ps = connection.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				classificatonlistById = new Classification();
				classificatonlistById.setClassificationId(rs.getInt("classification_id"));
				classificatonlistById.setClassificationName(rs.getString("classification_name"));
			} 
		}
			catch (Exception e) {
			// TODO: handle exception
		}
		return classificatonlistById;
	}	

	@Override
	public void deleteClassificationById(int classificationId) {
		/*try{  
			Connection connection = null;
			PreparedStatement ps = null;
			connection = dataSource.getConnection();
			
			String SQL ="DELETE FROM classification where classificationId='" + classificationId+ "'";
			ps = connection.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
		}*/
		
	}

	@Override
	public List<Classification> findAllClassification() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Classification> classificationList = new ArrayList<Classification>();
		
		try {
			connection = dataSource.getConnection();
			
			String SQL ="SELECT classification_id, classification_name FROM classification";
			ps = connection.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Classification classification = new Classification();
				classification.setClassificationId(rs.getInt("classification_id"));
				classification.setClassificationName(rs.getString("classification_name"));
				classificationList.add(classification);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classificationList;
	}

	@Override
	public void updateClassificationById(Classification classification) {
		
		Connection connection = null;
		PreparedStatement ps = null;
				
		try {
			connection = dataSource.getConnection();
			
			String SQL ="UPDATE classification SET classification_name = '"+classification.getClassificationName()+"' WHERE classification_id='"+ classification.getClassificationId() +"'";
			ps = connection.prepareStatement(SQL);			
			ps.executeQuery();
			
		}
			catch (Exception e) {
				e.printStackTrace();
		}
		
	}

}
