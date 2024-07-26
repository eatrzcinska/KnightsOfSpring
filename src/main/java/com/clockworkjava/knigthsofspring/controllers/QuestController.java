package com.clockworkjava.knigthsofspring.controllers;

import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.service.KnightService;
import com.clockworkjava.knigthsofspring.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;
    @Autowired
    QuestService questService;

    @RequestMapping("/assignquest")
    public String assignQuest(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List <Quest> notStartedQuest = questService.getAllNotStartedQuestes();
        model.addAttribute("knight", knight); //do tego knights sie odwołujemy w modelu jakodo zmienn
        model.addAttribute("notstartedquests", notStartedQuest); //do tego knights sie odwołujemy w modelu jakodo zmienn
        return "assignquest";
    }

    @RequestMapping(value = "/assignquest", method = RequestMethod.POST)
    public String saveQuest(Knight knight, Model model) {
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.updateQuest(quest);
        return "redirect:knights";
    }
}
