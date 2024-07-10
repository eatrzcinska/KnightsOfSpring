package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.utils.Ids;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepository {

    List<Quest> questList = new ArrayList<>();
    final static Random randomNumber = new Random();

    public void createQuest(String description) {
        questList.add(new Quest(description));
    }

    public List<Quest> getAll() {
        return questList;
    }

    public void deleteQuest(Quest quest) {
        questList.remove(quest);
    }

    @PostConstruct
    public void init() {
        createQuest("Uratuj ksiezniczke");
        createQuest("Wez udzial w turnieju");
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    //samo (fixedDelay =2000) znaczy ze czeka na zakonczenie dzialania tej metody i dopiero po zakonczeniu czeka 2s na wykonanie kolejny raz tej metody
    // (fixedRate = 2000) te dwie sekundy są liczone od momentu uruchomienia tej metody czyli od inicjalizacji listy, zyli nie czeka na zakonczenie metdy ktora uruchamiamy co jakis czas
   //(initialDelay = 4000)
    public void getRandomQuest() { //TODO what for?
        List<String> descriptionList = new ArrayList<>();
        descriptionList.add("Kill the Dragon");
        descriptionList.add("Fight with the Enemy");
        descriptionList.add("Save the Queen");
        descriptionList.add("Hide the treasure");

        String desc = descriptionList.get(randomNumber.nextInt(descriptionList.size()));
        createQuest(desc);
    }

}
