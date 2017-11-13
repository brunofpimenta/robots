package br.com.contaazul.robots.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsControllerTest {

    @Autowired
    private MarsController marsController;

    @Test
    public void moveWithOneCommandM() {
        ResponseEntity<String> responseEntity = marsController.move("M");

        assertEquals("(0,1,N)", responseEntity.getBody());
    }

    @Test
    public void moveWithManyCommands() {
        ResponseEntity<String> responseEntity = marsController.move("RMLMM");

        assertEquals("(1,2,N)", responseEntity.getBody());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCommands() {
        marsController.move("AAA");
    }

}
