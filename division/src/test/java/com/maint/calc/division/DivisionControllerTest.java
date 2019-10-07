package com.maint.calc.division;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DivisionControllerTest {

    @Autowired
    DivisionController divisionController;

    @Test
    public void dividir() {
        assertEquals(3.0,divisionController.dividir(6.0,2.0).getBody(),0.0001);
    }
}