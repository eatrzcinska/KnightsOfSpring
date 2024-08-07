package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.PlayerInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerInfoRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createPlayerInformation(PlayerInfo playerInfo) { //TODO
        em.persist(playerInfo);

    }

    public PlayerInfo getFirst() {
       return em.createQuery("from PlayerInfo", PlayerInfo.class).getResultList().get(0);
    }
}
