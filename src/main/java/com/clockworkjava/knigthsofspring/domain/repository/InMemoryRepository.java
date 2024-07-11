package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;

//import javax.annotation.PostConstruct;
import java.util.*;

//@Repository rezygnujemy z dodania adnotacji w tym miejscu, robimy to w klasie Main config poprzez metodę tak żeby w
// adnotacji Qualifier okreslic który bean jest potrzebny
public class InMemoryRepository implements KnightRepository {

    Map<Integer, Knight> knightMap = new HashMap<>();

    public InMemoryRepository() {
    }

    @Override
    public void createKnight(String name, int age) {

        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knightMap.put(newKnight.getId(), newKnight);
    }

    private int getNewId() {
        if (knightMap.isEmpty()) {
            return 0;
        } else {
            Integer integer = Collections.max(knightMap.keySet());
            return integer + 1;
        }
    }

    @Override
    public Collection <Knight> getAllKnights(){
        return knightMap.values();
    }

    @Override
    public void deleteKnight(Integer id) {
        knightMap.remove(id);
    }

    @Override
    public Optional<Knight> getKnight(String knightName) {
        Optional<Knight> knightByName = knightMap.values().stream().filter(knight -> knight.getName().equalsIgnoreCase(knightName)).findAny();
        return knightByName;
    }

    @Override
   // @PostConstruct
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

    @Override
    public Knight getKnightByid(int id) {
        return knightMap.get(id);
    }

    @Override
    public void addKnight(Knight knight) {
        knight.setId(getNewId());
        knightMap.put(knight.getId(), knight);
    }
}
