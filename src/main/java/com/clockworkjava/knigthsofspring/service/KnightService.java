package com.clockworkjava.knigthsofspring.service;

import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.PlayerInfo;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import com.clockworkjava.knigthsofspring.domain.repository.PlayerInfoRepository;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    PlayerInfoRepository playerInfoRepository;

    public List<Knight> getAllKnights() {

        ArrayList<Knight> sprawdzenie = new ArrayList(knightRepository.getAllKnights());
        for (Knight rycerz : sprawdzenie) {
            System.out.println(rycerz.getName() + " " + rycerz.getAge() + " " + rycerz.getId() + " " + rycerz.getLevel());
        }
        return sprawdzenie;
    }

    public void saveKnight(String name, int age) {
        knightRepository.createKnight(name, age);
    }

    public Knight getKnight(int id) {
        return knightRepository.getKnightByid(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void addKnight(Knight knight) {
        knightRepository.addKnight(knight);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectReward() {
        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isFinished();
            } else {
                return false;
            }
        };
        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate).mapToInt(
                knight -> knight.getQuest().getReward()).sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight ->
                knight.setQuest(null));

        return sum;
    }

    @Transactional
    public void getMyGold(){
        List<Knight> knightList = getAllKnights();
        knightList.forEach(knight -> {
                    if(knight.getQuest() != null){
                        boolean completed = knight.getQuest().isFinished();
                        if(completed){
                            questRepository.update(knight.getQuest());
                        }
                    }
                }
        );

        PlayerInfo first = playerInfoRepository.getFirst();
        int currentGold = first.getGold();
        playerInfoRepository.getFirst().setGold(currentGold + collectReward());

    }
}
