package com.laxman.updater.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laxman.updater.model.ParentDetails;

/**
 * 
 * @author "Laxman Singh ~ laxman.1390@gmail.com"
 *
 */
@Repository
public interface ParentnChildRepository extends CrudRepository<ParentDetails, Integer> {

	List<ParentDetails> findAll();
	
	/*<S extends ParentDetails> S save(ParentDetails parentDetails);
	
	int updatebyId(int id);
	
	int deleteById(int id);*/
	
}
