package br.com.contaazul.robots.service;

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
public class RobotServiceTest {

    @Autowired
    private RobotService robotService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void turnRightFromNorth() {
        String direction = robotService.turn("N", "R");

        assertEquals("E", direction);
    }

    @Test
    public void turnRightFromEast() {
        String direction = robotService.turn("E", "R");

        assertEquals("S", direction);
    }

    @Test
    public void turnRightFromSouth() {
        String direction = robotService.turn("S", "R");

        assertEquals("W", direction);
    }

    @Test
    public void turnRightFromWest() {
        String direction = robotService.turn("W", "R");

        assertEquals("N", direction);
    }

    @Test
    public void turnLeftFromNorth() {
        String direction = robotService.turn("N", "L");

        assertEquals("W", direction);
    }

    @Test
    public void turnLeftFromWest() {
        String direction = robotService.turn("W", "L");

        assertEquals("S", direction);
    }

    @Test
    public void turnLeftFromSouth() {
        String direction = robotService.turn("S", "L");

        assertEquals("E", direction);
    }

    @Test
    public void turnLeftFromEast() {
        String direction = robotService.turn("E", "L");

        assertEquals("N", direction);
    }

    @Test
    public void turnForWrongSide() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(containsString("Turn side can only be [L] or [R]"));

        robotService.turn("E", "A");
    }

}
