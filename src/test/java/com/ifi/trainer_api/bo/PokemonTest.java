package com.ifi.trainer_api.bo;

import javax.persistence.Embeddable;

import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonTest {

    @Test
    public void pokemon_shouldBeAnEmbeddable(){
        assertNotNull(Pokemon.class.getAnnotation(Embeddable.class)); 
    }

}