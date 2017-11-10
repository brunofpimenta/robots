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

    public String interpret(String command) {
        String position = "0,0";
        String direction = "N";

        if ("M".equals(command)) {
            position = moveService.move(direction, position);
        }

        if ("L".equals(command) || "R".equals(command)) {
            direction = turnService.turn(direction, command);
        }

        return String.format("%s,%s", position, direction);
    }

}
