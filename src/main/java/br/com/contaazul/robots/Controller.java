package br.com.contaazul.robots;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class Controller {

    @PostMapping(value = "test")
    public String test() {
        return "teste";
    }

}
