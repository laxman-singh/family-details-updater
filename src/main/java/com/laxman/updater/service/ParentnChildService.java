package com.laxman.updater.service;

import java.util.List;

import com.laxman.updater.model.ParentDetails;

/**
 * 
 * @author "Laxman Singh ~ laxman.1390@gmail.com"
 *
 */
public interface ParentnChildService {
	
	List<ParentDetails> getAllParentChildDetails();
	void saveParentnChildDetail(ParentDetails parentDetails);
	void updateParentnChildDetail(ParentDetails parentDetails);
	void deleteParentnChildDetail(Integer id);
}
