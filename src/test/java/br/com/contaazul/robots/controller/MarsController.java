package br.com.contaazul.robots.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/mars")
public class MarsController {

    @PostMapping
    public String move(@PathVariable("command") String command) {

        return null;
    }

}
