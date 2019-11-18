package com.ifi.trainer_api.bo;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrainerTest {

    @Test
    public void trainer_shouldBeAnEntity(){
        assertNotNull(Trainer.class.getAnnotation(Entity.class)); 
    }

    @Test
    public void trainerName_shouldBeAnId() throws NoSuchFieldException {
        assertNotNull(Trainer.class.getDeclaredField("name").getAnnotation(Id.class)); 
    }

    @Test
    public void trainerTeam_shouldBeAElementCollection() throws NoSuchFieldException {
        assertNotNull(Trainer.class.getDeclaredField("team").getAnnotation(ElementCollection.class)); 
    }

}