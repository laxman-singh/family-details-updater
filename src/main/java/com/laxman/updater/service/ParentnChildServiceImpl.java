package com.laxman.updater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laxman.updater.model.ParentDetails;
import com.laxman.updater.repository.ParentnChildRepository;

/**
 * 
 * @author "Laxman Singh ~ laxman.1390@gmail.com"
 *
 */
@Service
public class ParentnChildServiceImpl implements ParentnChildService {
	
	@Autowired
	private ParentnChildRepository parentnChildRepo;

	@Override
	public List<ParentDetails> getAllParentChildDetails() {
		return parentnChildRepo.findAll();
	}

	@Override
	public void saveParentnChildDetail(ParentDetails parentDetails) {
		parentnChildRepo.save(parentDetails);
	}

	@Override
	public void updateParentnChildDetail(ParentDetails parentDetails) {
		parentnChildRepo.save(parentDetails);
	}

	@Override
	public void deleteParentnChildDetail(Integer id) {
		parentnChildRepo.deleteById(id);;
	}

}
