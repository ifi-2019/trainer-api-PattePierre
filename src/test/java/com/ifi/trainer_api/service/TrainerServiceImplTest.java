package com.ifi.trainer_api.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.repository.TrainerRepository;

public class TrainerServiceImplTest {

    @Test
    public void getAllTrainers_shouldCallTheRepository() {
        TrainerRepository trainerRepo = mock(TrainerRepository.class);
        TrainerService trainerService = new TrainerServiceImpl(trainerRepo);

        trainerService.getAllTrainers();

        verify(trainerRepo).findAll();
    }

    @Test
    public void getTrainer_shouldCallTheRepository() {
    	TrainerRepository trainerRepo = mock(TrainerRepository.class);
    	TrainerService trainerService = new TrainerServiceImpl(trainerRepo);

        trainerService.getTrainer("Ash");

        verify(trainerRepo).findById("Ash");
    }

    @Test
    public void createTrainer_shouldCallTheRepository() {
    	TrainerRepository trainerRepo = mock(TrainerRepository.class);
        TrainerService trainerService = new TrainerServiceImpl(trainerRepo);

        Trainer ash = new Trainer();
        trainerService.createTrainer(ash);

        verify(trainerRepo).save(ash);
    }

}