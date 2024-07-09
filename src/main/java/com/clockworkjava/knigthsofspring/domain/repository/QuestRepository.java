package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.utils.Ids;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepository {

    //    Map<Integer, Quest> questMap = new HashMap<>();
//
//    public void createQuest(String description) {
//        int id = Ids.generateNewId(questMap.keySet());
//        Quest quest = new Quest(id, description);
//        questMap.put(id, quest);
//    }
//
//    public void deleteQuest(Quest quest) {
//        questMap.remove(quest);
//    }
//
//    public List<Quest> getAllQuests() {
//        return new ArrayList(questMap.values());
//    }
//
//    public void update(Quest quest) {
//        questMap.put(quest.getId(), quest);
//    }
//
//    public Quest getQuest(int id) {
//        return questMap.get(id);
//    }
//
//
//    @PostConstruct
//    public void getRandomQuest() { //TODO what for?
//        List<String> descriptionList = new ArrayList<>();
//        descriptionList.add("Kill the Dragon");
//        descriptionList.add("Fight with the Enemy");
//        descriptionList.add("Save the Queen");
//        descriptionList.add("Hide the treasure");
//
//        Random randomNumber = new Random();
//        String desc = descriptionList.get(randomNumber.nextInt(descriptionList.size()));
//        createQuest(desc);
//    }
    List<Quest> questList = new ArrayList<>();

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

}
