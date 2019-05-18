package com.sgic.rlp.serviceImpl;

import java.util.List;

import com.sgic.rlp.dao.SubClassificationDao;
import com.sgic.rlp.models.SubClassification;
import com.sgic.rlp.service.SubClassificationService;

public class SubClassificationServiceImpl implements SubClassificationService {

	private SubClassificationDao subclassificationDao;	
	
	public SubClassificationDao getSubclassificationDao() {
		return subclassificationDao;
	}

	public void setSubclassificationDao(SubClassificationDao subclassificationDao) {
		this.subclassificationDao = subclassificationDao;
	}

	@Override
	public void addSubClassification(SubClassification subClassification) {
		subclassificationDao.createSubClassification(subClassification);

	}

	@Override
	public SubClassification fetchSubClassificationByID(int subclassificationId) {
		subclassificationDao.getSubClassificationByID(subclassificationId);
		return null;
	}

	@Override
	public void deleteSubClassificationById(int subclassificationId) {
		subclassificationDao.deleteSubClassificationById(subclassificationId);

	}

	@Override
	public void updateSubClassificationById(SubClassification subClassification) {
		subclassificationDao.updateSubClassificationById(subClassification);

	}

	@Override
	public List<SubClassification> findAllSubClassificationInfo() {
		return subclassificationDao.findAllSubClassification();
	}

}
