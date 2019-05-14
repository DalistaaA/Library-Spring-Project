package com.sgic.rlp.dao;

import java.util.List;

import com.sgic.rlp.models.SubClassification;

public interface SubClassificationDao {
	
	public abstract void createSubClassification(SubClassification subClassification);

	public abstract SubClassification getSubClassificationByID(int subclassificationId);

	public abstract void deleteSubClassificationById(int subclassificationId);

	public abstract void updateSubClassificationById(SubClassification subClassification);

	public abstract List<SubClassification> findAllSubClassification();
}
