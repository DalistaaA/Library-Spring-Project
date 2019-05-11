package com.sgic.rlp.dao;

import java.util.List;

import com.sgic.rlp.models.Classification;


public interface ClassificationDao {
	public abstract void createClassification(Classification classification);

	public abstract Classification getClassificationByID(int classificationId);

	public abstract void deleteClassificationById(int classificationId);

	public abstract void updateClassificationByName(String newClassificationName, int classificationId);

	public abstract List<Classification> findAllClassification();
}
