package br.com.contaazul.robots.interpreter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandInterpreterTest {

    @Autowired
    private CommandInterpreter commandInterpreter;

    @Test
    public void interpretOneCommandM() {
        String coordinate = commandInterpreter.interpret("M");

        assertEquals("0,1,N", coordinate);
    }

    @Test
    public void interpretOneCommandL() {
        String coordinate = commandInterpreter.interpret("L");

        assertEquals("0,0,W", coordinate);
    }

    @Test
    public void interpretOneCommandR() {
        String coordinate = commandInterpreter.interpret("R");

        assertEquals("0,0,E", coordinate);
    }
}
