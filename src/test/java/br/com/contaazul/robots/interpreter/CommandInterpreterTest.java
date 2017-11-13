package br.com.contaazul.robots.interpreter;

import br.com.contaazul.robots.exception.InvalidCommandException;
import br.com.contaazul.robots.exception.InvalidPositionException;
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

    @Test
    public void interpretManyCommands() {
        String coordinate = commandInterpreter.interpret("RMLMM");

        assertEquals("1,2,N", coordinate);
    }

    //Testes fornecidos pela Conta Azul

    @Test
    public void interpretManyCommands_ContaAzul_1() {
        String coordinate = commandInterpreter.interpret("MMRMMRMM");

        assertEquals("2,0,S", coordinate);
    }

    @Test
    public void interpretManyCommands_ContaAzul_2() {
        String coordinate = commandInterpreter.interpret("MML");

        assertEquals("0,2,W", coordinate);
    }

    @Test
    public void interpretManyCommands_ContaAzul_3() {
        String coordinate = commandInterpreter.interpret("MML");

        assertEquals("0,2,W", coordinate);
    }

    @Test(expected = InvalidCommandException.class)
    public void interpretManyCommands_ContaAzul_4() {
        commandInterpreter.interpret("AAA");
    }

    @Test(expected = InvalidPositionException.class)
    public void interpretManyCommands_ContaAzul_5() {
        commandInterpreter.interpret("MMMMMMMMMMMMMMMMMMMMMMMM");
    }
}
