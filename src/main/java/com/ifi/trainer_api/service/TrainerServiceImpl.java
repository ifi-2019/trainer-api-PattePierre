package com.ifi.trainer_api.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService { 

 private TrainerRepository trainerRepository;

 public TrainerServiceImpl(TrainerRepository trainerRepository) {
     this.trainerRepository = trainerRepository;
 }

 @Override
 public Iterable<Trainer> getAllTrainers() {
     return this.trainerRepository.findAll();
 }

 @Override
 public Trainer getTrainer(String name) {
	 try {
	     return this.trainerRepository.findById(name).get();
	 } catch (NoSuchElementException e) {
		 return null;
	 }
 }

 @Override
 public Trainer createTrainer(Trainer trainer) {
     return this.trainerRepository.save(trainer);
 }

	@Override
	public void deleteTrainer(String name) {
		this.trainerRepository.deleteById(name);
	}
}