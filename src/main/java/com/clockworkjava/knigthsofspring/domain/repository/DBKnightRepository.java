package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;
import jakarta.annotation.PostConstruct;
import jdk.jshell.spi.ExecutionControl.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    public Collection<Knight> getAllKnights() throws NotImplementedException {
        System.out.println("Uzywam bazy danych");
        throw new NotImplementedException("dd");
    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Knight getKnight(String knightName) throws NotImplementedException {
        System.out.println("Uzywam bazy danych");
        throw new NotImplementedException("dd");
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
}
