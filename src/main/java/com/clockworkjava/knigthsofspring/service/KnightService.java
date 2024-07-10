package com.clockworkjava.knigthsofspring.service;

import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    public List<Knight> getAllKnights() throws ExecutionControl.NotImplementedException {
        return new ArrayList(knightRepository.getAllKnights());
    }


}
