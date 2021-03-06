package com.sgic.rlp.service;

import java.util.List;

import com.sgic.rlp.models.Classification;

public interface ClassificationService {

	public abstract void addClassification(Classification classification);

	public abstract Classification fetchClassificationByID(int classificationId);

	public abstract void deleteClassificationById(int classificationId);

	public abstract void updateClassificationById(Classification classification);

	public abstract List<Classification> findAllClassificationInfo();
}
