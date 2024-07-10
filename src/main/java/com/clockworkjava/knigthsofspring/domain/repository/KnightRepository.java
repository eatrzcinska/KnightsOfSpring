package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;
import jakarta.annotation.PostConstruct;
import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;

public interface KnightRepository {

    void createKnight(String name, int age);
    Collection <Knight> getAllKnights() throws ExecutionControl.NotImplementedException;
    void deleteKnight(String name);
    Knight getKnight(String knightName) throws ExecutionControl.NotImplementedException;
    void build();
}
