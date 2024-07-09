package com.clockworkjava.knigthsofspring.service;

import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    QuestRepository questRepository;
    @Autowired
    KnightRepository knightRepository;

    final static Random rand = new Random();

    public void asignRandomQuest(String knightName) { //odcinamy się jak mozemy od konkretych elemntów domenowych czyli zamiast podac Knight w parametrze podajemy imie
        //questRepository.getRandomQuest();
        List<Quest> allQuests = questRepository.getAll();
       Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
    }
}