package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.utils.Ids;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepository {

    final static Random randomNumber = new Random();
    Map <Integer, Quest> quests = new HashMap<>();

    public void createQuest(String description) {
        int key = Ids.generateNewId(quests.keySet());
        Quest quest = new Quest(key, description);
        quests.put(key,quest);
    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + quests +
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

    public void update(Quest quest) {
        quests.put(quest.getId(), quest);

    }

    public Quest getQuest(Integer id) {
       return quests.get(id);
    }
}
