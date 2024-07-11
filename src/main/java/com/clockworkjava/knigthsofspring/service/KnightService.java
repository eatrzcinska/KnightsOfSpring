package com.clockworkjava.knigthsofspring.service;

import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    public List<Knight> getAllKnights() {

        ArrayList <Knight> sprawdzenie = new ArrayList(knightRepository.getAllKnights());
        for (Knight rycerz:sprawdzenie){
            System.out.println(rycerz.getName() + " " + rycerz.getAge() + " " + rycerz.getId() + " " + rycerz.getLevel());
        }
        return  sprawdzenie;
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
}
