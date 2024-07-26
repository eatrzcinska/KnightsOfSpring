package com.clockworkjava.knigthsofspring.service;

import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    QuestRepository questRepository;
    @Autowired
   // @Qualifier("inMemoryKnightRepository") jesli definiujemy profilami to juz tego nie trzeba
    KnightRepository knightRepository;

    final static Random rand = new Random();

    public void asignRandomQuest(String knightName) { //odcinamy się jak mozemy od konkretych elemntów domenowych czyli zamiast podac Knight w parametrze podajemy imie
        //questRepository.getRandomQuest();
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuestes() {
//        List <Quest> allNotStartedQuestes = new ArrayList();
//        for(Quest quest: questRepository.getAll()){
//            if(!quest.isStarted()){
//                allNotStartedQuestes.add(quest);
//            }
//        }
//        return allNotStartedQuestes;

        return questRepository.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    public void updateQuest(Quest quest) {
        questRepository.update(quest);
    }
}
