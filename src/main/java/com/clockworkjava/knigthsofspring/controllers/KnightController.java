package com.clockworkjava.knigthsofspring.controllers;


import com.clockworkjava.knigthsofspring.components.TimeComponent;
import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.PlayerInfo;
import com.clockworkjava.knigthsofspring.domain.repository.PlayerInfoRepository;
import com.clockworkjava.knigthsofspring.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInfoRepository playerInfoRepository;

    //metody w kontrolerach muszą pzekazywać model i widok bo on je łączy
    @RequestMapping("/knights")
    //nie jest dobrze jak repozytorium czyli baza danych komunikuje sie bezposrednio z widokiem, dobrze jest utworzyc service
    public String getKnights(Model model) {
        PlayerInfo playerInfo = playerInfoRepository.getFirst();
        List<Knight> allKnights = knightService.getAllKnights();
        model.addAttribute("knights", allKnights); //do tego knights sie odwołujemy w modelu jakodo zmienn
        model.addAttribute("hello", "joł men"); //nazwa atrybutu - jest wpisywana w tymeleafa z <p th:text = "${hello}"
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinfo", playerInfo);
        return "knights.html";
    }

    @RequestMapping("/knight")
    public String showKnight(@RequestParam("id") Integer id, Model model) {
        PlayerInfo playerInfo = playerInfoRepository.getFirst();
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("playerinfo", playerInfo);
        model.addAttribute("timecomponent", timeComponent);
        return "knight.html";
    }

    @RequestMapping("/createknight")
    public String createKnight(Model model) {
        PlayerInfo playerInfo = playerInfoRepository.getFirst();
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinfo", playerInfo);
        return "knightform.html";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnights(@Valid Knight knight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "knightform";
        } else {
            knightService.addKnight(knight);
            return "redirect:/knights"; //tu musi być odnośnik do strony a nie do pliku html ktory sie wyswietla podczas ładowania strony. plik jest w metodzie get
        }
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights"; //tu musi być odnośnik do strony a nie do pliku html ktory sie wyswietla podczas ładowania strony. plik jest w metodzie get
    }
}
