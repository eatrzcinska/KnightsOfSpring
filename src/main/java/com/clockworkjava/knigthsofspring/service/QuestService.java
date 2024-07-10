package com.clockworkjava.knigthsofspring.service;

import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.domain.repository.InMemoryRepository;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    QuestRepository questRepository;
    @Autowired
   // @Qualifier("inMemoryKnightRepository") jesli definiujemy profilami to juz tego nie trzeba
    KnightRepository knightRepository;

    final static Random rand = new Random();

    public void asignRandomQuest(String knightName) throws ExecutionControl.NotImplementedException { //odcinamy się jak mozemy od konkretych elemntów domenowych czyli zamiast podac Knight w parametrze podajemy imie
        //questRepository.getRandomQuest();
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
        questRepository.deleteQuest(randomQuest);
    }
}
