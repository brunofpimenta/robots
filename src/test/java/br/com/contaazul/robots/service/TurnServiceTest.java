package br.com.contaazul.robots.service;

import br.com.contaazul.robots.exception.InvalidCommandException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnServiceTest {

    @Autowired
    private TurnService turnService;

    @Test
    public void turnRightFromNorth() {
        String direction = turnService.turn("N", 'R');

        assertEquals("E", direction);
    }

    @Test
    public void turnRightFromEast() {
        String direction = turnService.turn("E", 'R');

        assertEquals("S", direction);
    }

    @Test
    public void turnRightFromSouth() {
        String direction = turnService.turn("S", 'R');

        assertEquals("W", direction);
    }

    @Test
    public void turnRightFromWest() {
        String direction = turnService.turn("W", 'R');

        assertEquals("N", direction);
    }

    @Test
    public void turnLeftFromNorth() {
        String direction = turnService.turn("N", 'L');

        assertEquals("W", direction);
    }

    @Test
    public void turnLeftFromWest() {
        String direction = turnService.turn("W", 'L');

        assertEquals("S", direction);
    }

    @Test
    public void turnLeftFromSouth() {
        String direction = turnService.turn("S", 'L');

        assertEquals("E", direction);
    }

    @Test
    public void turnLeftFromEast() {
        String direction = turnService.turn("E", 'L');

        assertEquals("N", direction);
    }

    @Test(expected = InvalidCommandException.class)
    public void turnForWrongSide() {
        turnService.turn("E", 'A');
    }

}
