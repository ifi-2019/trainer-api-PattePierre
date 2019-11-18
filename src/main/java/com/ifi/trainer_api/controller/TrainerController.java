package com.ifi.trainer_api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.service.TrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("/")
    Iterable<Trainer> getAllTrainers(){
        return this.trainerService.getAllTrainers();
    }

    @GetMapping("/{name}")
    Trainer getTrainer(@PathVariable String name){
        return this.trainerService.getTrainer(name); 
    }
    
    @PostMapping(path="/",consumes = "application/json")
    void createTrainer(@RequestBody Trainer trainer) {
    	this.trainerService.createTrainer(trainer);
    }
    
    @DeleteMapping("/{name}")
    void deleteTrainer(@PathVariable String name) {
    	this.trainerService.deleteTrainer(name);
    }

}