package com.clockworkjava.knigthsofspring;

import com.clockworkjava.knigthsofspring.domain.repository.InMemoryRepository;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import com.clockworkjava.knigthsofspring.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {


    @Autowired
    QuestRepository questrepository;

    @Autowired
   // @Qualifier ("inMemoryKnightRepository") jesli definiujemy profilami to juz tego nie trzeba
    KnightRepository knightRepository;

    @Autowired
    QuestService questService;


    @Override
    public void run(String... args) throws Exception {

        questrepository.getRandomQuest();
        questrepository.getRandomQuest();

    }

}

