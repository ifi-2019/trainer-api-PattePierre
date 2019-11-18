package com.ifi.trainer_api.repository;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifi.trainer_api.bo.Pokemon;
import com.ifi.trainer_api.bo.Trainer;

@DataJpaTest
@RunWith( SpringJUnit4ClassRunner.class )
public class TrainerRepositoryTest {
	

    @Autowired
    private TrainerRepository repository;

    @Test
    public void trainerRepository_shouldExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(TrainerRepository.class)); 
    }

    @Test
    public void trainerRepositoryShouldBeInstanciedBySpring(){
        assertNotNull(repository);
    }

    @Test
    public void testSave(){ 
        Trainer ash = new Trainer("Ash");

        repository.save(ash);

        Trainer saved = repository.findById(ash.getName()).orElse(null);

        assertEquals("Ash", saved.getName());
    }

    @Test
    public void testSaveWithPokemons(){ 
    	Trainer misty = new Trainer("Misty");
    	Pokemon staryu = new Pokemon(120, 18);
        Pokemon starmie = new Pokemon(121, 21);
        List<Pokemon> liste = new ArrayList<Pokemon>();
        liste.add(staryu);
        liste.add(starmie);
        misty.setTeam(liste);

        repository.save(misty);

        Trainer saved = repository.findById(misty.getName()).orElse(null);

        assertEquals("Misty", saved.getName());
        assertEquals(2, saved.getTeam().size());
    }

}
