package br.com.contaazul.robots.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoveServiceTest {

    @Autowired
    private MoveService moveService;

    @Test
    public void moveNorth() {
        String newPosition = moveService.move("N", "0,0");

        assertEquals("0,1", newPosition);
    }

    @Test
    public void moveEast() {
        String newPosition = moveService.move("E", "0,0");

        assertEquals("1,0", newPosition);
    }

    @Test
    public void moveSouth() {
        String newPosition = moveService.move("S", "0,1");

        assertEquals("0,0", newPosition);
    }

    @Test
    public void moveWest() {
        String newPosition = moveService.move("W", "1,0");

        assertEquals("0,0", newPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveToNorthOutOfBounds() {
        moveService.move("N", "0,4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveToEastOutOfBounds() {
        moveService.move("E", "4,0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveToSouthOutOfBounds() {
        moveService.move("S", "0,0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveToWestOutOfBounds() {
        moveService.move("W", "0,0");
    }

}
