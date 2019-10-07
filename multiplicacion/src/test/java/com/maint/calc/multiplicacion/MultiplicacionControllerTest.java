package com.maint.calc.multiplicacion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicacionControllerTest {

    @Autowired
    MultiplicacionController multiplicacionController;
    @Test
    public void multiplicar() {
        assertEquals(12.0,multiplicacionController.multiplicar(6.0,2.0).getBody(),0.0001);
    }
}