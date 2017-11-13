package br.com.contaazul.robots.controller;

import br.com.contaazul.robots.interpreter.CommandInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/mars")
public class MarsController {

    private CommandInterpreter commandInterpreter;

    @Autowired
    public MarsController(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    @PostMapping("{commands}")
    public ResponseEntity<String> move(@PathVariable("commands") String commands) {

        String coordinate = commandInterpreter.interpret(commands);

        return ResponseEntity.ok(String.format("(%s)", coordinate));
    }

}
