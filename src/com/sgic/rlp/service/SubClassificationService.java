package com.sgic.rlp.service;

import java.util.List;

import com.sgic.rlp.models.SubClassification;

public interface SubClassificationService {
	public abstract void addSubClassification(SubClassification subClassification);

	public abstract SubClassification fetchSubClassificationByID(int subclassificationId);

	public abstract void deleteSubClassificationById(int subclassificationId);

	public abstract void updateSubClassificationById(SubClassification subClassification);

	public abstract List<SubClassification> findAllSubClassificationInfo();
}
