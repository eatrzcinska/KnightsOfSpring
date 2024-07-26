package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    void deleteKnight(Integer id);

    Optional<Knight> getKnight(String knightName);

    void build();

    Knight getKnightByid(int id);

    void addKnight(Knight knight);

    default void updateKnight(int id, Knight knight) {
        throw new RuntimeException();
    }
}
