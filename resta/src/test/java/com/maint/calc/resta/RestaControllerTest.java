package com.maint.calc.resta;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaControllerTest {

    @Autowired
    RestaController restaController;

    @Test
    public void restar() {
        assertEquals(4.0,restaController.restar(6.0,2.0).getBody(),0.0001);
    }
}