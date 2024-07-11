package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;
import jakarta.annotation.PostConstruct;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Repository rezygnujemy z dodania adnotacji w tym miejscu, robimy to w klasie Main config poprzez metodę tak żeby w
// adnotacji Qualifier okreslic który bean jest potrzebny
public class DBKnightRepository implements KnightRepository {

    Map<String, Knight> knightMap = new HashMap<>();

    public DBKnightRepository() {
    }

    @Override
    public void createKnight(String name, int age) {
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("Uzywam bazy danych");
        return null;
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Optional<Knight> getKnight(String knightName) {
        System.out.println("Uzywam bazy danych");
        return null;
    }

    @Override
    @PostConstruct
    public void build() {
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public String toString() {
        System.out.println("Uzywam bazy danych");
        return null;
    }

    @Override
    public Knight getKnightByid(int id) {
        return null;
    }

    @Override
    public void addKnight(Knight knight) {
    }
}
