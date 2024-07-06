package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Quest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    List<Quest> questList = new ArrayList<>();

    public void createQuest(String description) {
        Quest quest = new Quest(description);
        questList.add(quest);
    }

    public List getAllQuests() {
        return questList;
    }

    public Quest getRandomQuest() {
        questList.add(new Quest("Kill the Dragon"));
        questList.add(new Quest("Fight with the Enemy"));
        questList.add(new Quest("Save the Queen"));
        questList.add(new Quest("Hide the treasure"));

        Random randomNumber = new Random();
        return questList.get(randomNumber.nextInt(questList.size()));
    }

    public void deleteQuest(Quest quest) {
        questList.remove(quest);

    }
}
