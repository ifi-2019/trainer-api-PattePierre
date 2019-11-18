package com.ifi.trainer_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ifi.trainer_api.bo.Pokemon;
import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.repository.TrainerRepository;

@SpringBootApplication 
public class TrainerApi {

    public static void main(String... args){ 
        SpringApplication.run(TrainerApi.class, args);
    }
    
    @Bean 
    @Autowired 
    public CommandLineRunner demo(TrainerRepository repository) { 
        return (args) -> { 
            Trainer ash = new Trainer("Ash");
            Pokemon pikachu = new Pokemon(25, 18);
            List<Pokemon> listeAsh = new ArrayList<Pokemon>();
            listeAsh.add(pikachu);
            ash.setTeam(listeAsh);

            Trainer misty = new Trainer("Misty");
            Pokemon staryu = new Pokemon(120, 18);
            Pokemon starmie = new Pokemon(121, 21);
            List<Pokemon> listeMisty = new ArrayList<Pokemon>();
            listeMisty.add(staryu);
            listeMisty.add(starmie);
            misty.setTeam(listeMisty);

            // save a couple of trainers
            repository.save(ash); 
            repository.save(misty);
        };
    }

}
