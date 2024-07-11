package com.clockworkjava.knigthsofspring.controllers;


import com.clockworkjava.knigthsofspring.components.TimeComponent;
import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.PlayerInfo;
import com.clockworkjava.knigthsofspring.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInfo playerInfo;

    //metody w kontrolerach muszą pzekazywać model i widok bo on je łączy
    @RequestMapping("/knights")
    //nie jest dobrze jak repozytorium czyli baza danych komunikuje sie bezposrednio z widokiem, dobrze jest utworzyc service
    public String getKnights(Model model) {
        List<Knight> allKnights = knightService.getAllKnights();
        model.addAttribute("knights", allKnights); //do tego knights sie odwołujemy w modelu jakodo zmienn
        model.addAttribute("hello", "joł men"); //nazwa atrybutu - jest wpisywana w tymeleafa z <p th:text = "${hello}"
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinfo", playerInfo);
        return "knights.html";
    }

    @RequestMapping("/knight")
    public String showKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("playerinfo", playerInfo);
        model.addAttribute("timecomponent", timeComponent);
        return "knight.html";
    }

    @RequestMapping("/createknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinfo", playerInfo);
        return "knightform.html";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnights(Knight knight) {
        //knightService.saveKnight(knight.getName(), knight.getAge()); to bylo zle
        knightService.addKnight(knight);
        return "redirect:/knights"; //tu musi być odnośnik do strony a nie do pliku html ktory sie wyswietla podczas ładowania strony. plik jest w metodzie get
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights"; //tu musi być odnośnik do strony a nie do pliku html ktory sie wyswietla podczas ładowania strony. plik jest w metodzie get
    }
}
