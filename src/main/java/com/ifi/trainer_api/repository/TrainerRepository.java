package com.ifi.trainer_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifi.trainer_api.bo.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {
	List<Trainer> findAll();
	Trainer findById(String id);
	Trainer save (Trainer trainer);
}