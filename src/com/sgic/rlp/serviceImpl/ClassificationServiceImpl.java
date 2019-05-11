package com.sgic.rlp.serviceImpl;

import java.util.List;

import com.sgic.rlp.dao.ClassificationDao;
import com.sgic.rlp.models.Classification;
import com.sgic.rlp.service.ClassificationService;

public class ClassificationServiceImpl implements ClassificationService {

	
	private ClassificationDao classificationDao;
	
	
	public ClassificationDao getClassificationDao() {
		return classificationDao;
	}

	public void setClassificationDao(ClassificationDao classificationDao) {
		this.classificationDao = classificationDao;
	}

	@Override
	public void addClassification(Classification classification) {
		classificationDao.createClassification(classification);
		
	}

	@Override
	public Classification fetchClassificationByID(int classificationId) {
		return classificationDao.getClassificationByID(classificationId);
	}

	@Override
	public void deleteClassificationById(int classificationId) {
		classificationDao.deleteClassificationById(classificationId);
		
	}

	@Override
	public void updateClassificationByName(String newClassificationName, int classificationId) {
		classificationDao.updateClassificationByName(newClassificationName, classificationId);
		
	}

	@Override
	public List<Classification> findAllClassificationInfo() {
		return classificationDao.findAllClassification();
	}

}
