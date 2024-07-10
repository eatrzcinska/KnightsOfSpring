package com.clockworkjava.knigthsofspring.controllers;


import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.service.KnightService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    //metody w kontrolerach muszą pzekazywać model i widok bo on je łączy
    @RequestMapping("/knights")
    //nie jest dobrze jak repozytorium czyli baza danych komunikuje sie bezposrednio z widokiem, dobrze jest utworzyc service
    public String getKnights(Model model) throws ExecutionControl.NotImplementedException {
        List<Knight> allKnights = knightService.getAllKnights();
       model.addAttribute("knights", allKnights); //do tego knights sie odwołujemy w modelu jakodo zmienn
       model.addAttribute("hello", "joł men");

        return "knights.html";
    }
}
