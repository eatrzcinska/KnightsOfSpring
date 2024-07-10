package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository rezygnujemy z dodania adnotacji w tym miejscu, robimy to w klasie Main config poprzez metodę tak żeby w
// adnotacji Qualifier okreslic który bean jest potrzebny
public class InMemoryRepository implements KnightRepository {

    Map<String, Knight> knightMap = new HashMap<>();

    public InMemoryRepository() {
    }

    @Override
    public void createKnight(String name, int age) {
        knightMap.put(name, new Knight(name, age));
    }

    @Override
    public Collection <Knight> getAllKnights(){
        return knightMap.values();
    }

    @Override
    public void deleteKnight(String name) {
        knightMap.remove(name);
    }

    @Override
    public Knight getKnight(String knightName) {
        return knightMap.get(knightName);
    }

    @Override
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
