package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class KnightRepository {

    Map<String, Knight> knightMap = new HashMap<>();

    public KnightRepository() {
    }

    public void createKnight(String name, int age) {
        knightMap.put(name, new Knight(name, age));
    }

    public void deleteKnight(String name) {
        knightMap.remove(name);
    }

    public Knight getKnight(String knightName) {
        return knightMap.get(knightName);
    }

    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knightMap +
                '}';
    }
}
