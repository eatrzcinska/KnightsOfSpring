package com.clockworkjava.knigthsofspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mapowanie requestu na logikę biznesowa a nastepnie na dostarczenie odpowiedniego modelu
public class HelloController {

    @RequestMapping("/hello")
    public String hellolo(){
        return "hello.html";
    }
}

