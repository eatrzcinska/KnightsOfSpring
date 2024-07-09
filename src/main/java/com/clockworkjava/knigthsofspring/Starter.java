package com.clockworkjava.knigthsofspring;

import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import com.clockworkjava.knigthsofspring.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {


    @Autowired
    QuestRepository questrepository;
    @Autowired
    KnightRepository knightRepository;
    @Autowired
    QuestService questService;


    @Override
    public void run(String... args) throws Exception {
        questService.asignRandomQuest("Lancelot");
        questService.asignRandomQuest("Percival");

        System.out.println(knightRepository);
    }

}

