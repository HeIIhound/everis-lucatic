package com.spring;

import com.spring.config.*;
import com.spring.controller.*;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebAppInitializer.class})

public class UnitaryTest {
	
	@Autowired
    private LoginController LoginController;
	
	@Test
    public void pruebatest(){       
        assertEquals(10, LoginController.operacion(5));   
    }

}