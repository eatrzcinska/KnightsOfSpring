package com.clockworkjava.knigthsofspring;

import com.clockworkjava.knigthsofspring.domain.PlayerInfo;
import com.clockworkjava.knigthsofspring.domain.repository.KnightRepository;
import com.clockworkjava.knigthsofspring.domain.repository.PlayerInfoRepository;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import com.clockworkjava.knigthsofspring.service.QuestService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    PlayerInfoRepository playerInfoRepository;

    @Autowired
    QuestRepository questrepository;

    @Autowired
    // @Qualifier ("inMemoryKnightRepository") jesli definiujemy profilami to juz tego nie trzeba
    KnightRepository knightRepository;

    @Autowired
    QuestService questService;


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        playerInfoRepository.createPlayerInformation(new PlayerInfo());
        knightRepository.build();
        questrepository.getRandomQuest();
        questrepository.getRandomQuest();
        knightRepository.createKnight("Marcin", 36);
        questService.asignRandomQuest("Marcin");
    }

}

