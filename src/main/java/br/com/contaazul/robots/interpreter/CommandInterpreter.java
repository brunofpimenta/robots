package br.com.contaazul.robots.interpreter;

import br.com.contaazul.robots.service.MoveService;
import br.com.contaazul.robots.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandInterpreter {

    private final MoveService moveService;
    private final TurnService turnService;

    @Autowired
    public CommandInterpreter(MoveService moveService, TurnService turnService) {

        this.moveService = moveService;
        this.turnService = turnService;
    }

    public String interpret(String commandList) {
        String position = "0,0";
        String direction = "N";

        return interpret(0, position, direction, commandList.toCharArray());
    }

    private String interpret(int index, String position, String direction, char[] commands) {

        if (index > commands.length - 1) {
            return String.format("%s,%s", position, direction);
        }

        if ('M' == commands[index]) {
            position = moveService.move(direction, position);
            return interpret(++index, position, direction, commands);
        }

        if ('L' == commands[index] || 'R' == commands[index]) {
            direction = turnService.turn(direction, commands[index]);
            return interpret(++index, position, direction, commands);
        }

        throw new IllegalArgumentException("Invalid command [" + commands[index] + "]. The commands allowed are [M], [L] and [R].");
    }

}
