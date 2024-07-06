package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface KnightRepository {

    void createKnight(String name, int age);
    void deleteKnight(String name);
    Knight getKnight(String name);
    Collection getAllKnights();
}
