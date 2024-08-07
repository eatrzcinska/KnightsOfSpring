package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Knight;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Repository rezygnujemy z dodania adnotacji w tym miejscu, robimy to w klasie Main config poprzez metodę tak żeby w
// adnotacji Qualifier okreslic który bean jest potrzebny
public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager em;

    public DBKnightRepository() {
    }

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        em.persist(knight);
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Collection<Knight> getAllKnights() {

        System.out.println("Uzywam bazy danych");
        return em.createQuery("from Knight", Knight.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        Knight knight = getKnightByid(id);
        em.remove(knight);
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Optional<Knight> getKnight(String knightName) {

        System.out.println("Uzywam bazy danych");
        Knight knight = em.createQuery("from Knight k where k.name=:name", Knight.class).setParameter("name", knightName).getSingleResult();
        return Optional.ofNullable(knight);
    }

    @Override
    @PostConstruct
    public void build() {
        System.out.println("Uzywam bazy danych");
    }


    @Override
    public Knight getKnightByid(int id) {
        return em.find(Knight.class, id);
    }

    @Override
    @Transactional
    public void addKnight(Knight knight) {
        em.persist(knight);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight)  {
        em.merge(knight);
    }
}
