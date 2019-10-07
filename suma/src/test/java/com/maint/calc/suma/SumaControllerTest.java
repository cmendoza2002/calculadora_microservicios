package com.maint.calc.suma;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SumaControllerTest extends TestCase {

    @Autowired
    SumaController sumaController;

    @Test
    public void sumar() {
        assertEquals(4.0,sumaController.sumar(2.0,2.0).getBody(),0.0001);
    }

}