package com.ifi.trainer_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifi.trainer_api.bo.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, String> {
	List<Trainer> findAll();
	Optional<Trainer> findById(String name);
	Trainer save (Trainer trainer);
	void deleteById(String name);
}