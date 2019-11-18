package com.ifi.trainer_api.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.service.TrainerService;

@RunWith( SpringJUnit4ClassRunner.class )
public class TrainerControllerTest {

    @Mock
    private TrainerService trainerService;

    @InjectMocks
    private TrainerController trainerController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTrainers_shouldCallTheService() {
        trainerController.getAllTrainers();

        verify(trainerService).getAllTrainers();
    }

    @Test
    public void getTrainer_shouldCallTheService() {
        trainerController.getTrainer("Ash");

        verify(trainerService).getTrainer("Ash");
    }
    
    @Test
    public void postTrainer_shouldCallTheService() {
    	Trainer ash = new Trainer("Ash");
        trainerController.createTrainer(ash);

        verify(trainerService).createTrainer(ash);
    }
    
    @Test
    public void trainerController_shouldBeAnnotated(){
    	RestController controllerAnnotation =
                TrainerController.class.getAnnotation(RestController.class);
        assertNotNull(controllerAnnotation);

        RequestMapping requestMappingAnnotation =
                TrainerController.class.getAnnotation(RequestMapping.class);
        assertArrayEquals(new String[]{"/trainers"}, requestMappingAnnotation.value());
    }

    @Test
    public void getAllTrainers_shouldBeAnnotated() throws NoSuchMethodException {
        Method getAllTrainers =
                TrainerController.class.getDeclaredMethod("getAllTrainers");
        GetMapping getMapping = getAllTrainers.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value());
    }

    @Test
    public void getTrainer_shouldBeAnnotated() throws NoSuchMethodException {
        Method getTrainer =
                TrainerController.class.getDeclaredMethod("getTrainer", String.class);
        GetMapping getMapping = getTrainer.getAnnotation(GetMapping.class);

        PathVariable pathVariableAnnotation = getTrainer.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{name}"}, getMapping.value());

        assertNotNull(pathVariableAnnotation);
    }
    
    @Test
    public void createTrainer_shouldBeAnnotated() throws NoSuchMethodException {
        Method getTrainer =
                TrainerController.class.getDeclaredMethod("createTrainer", Trainer.class);
        PostMapping postMapping = getTrainer.getAnnotation(PostMapping.class);
 
        assertNotNull(postMapping);
        assertArrayEquals(new String[]{"/"}, postMapping.value());
    }
}