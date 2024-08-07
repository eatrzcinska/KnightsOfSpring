package com.clockworkjava.knigthsofspring.domain.repository;

import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.utils.Ids;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    //w tym momencie dzieki tej adnotacji te entity manager zostanie utworzony przez fabrykę i wstrzyknięty
    //do repozytorium przy kazdym nowymzapytaniau do bazy danych
    private EntityManager em; // obiekt tworzony dla kazdej sesji połączenia z bazą danych,
    // na potrzeby głównie jednego zapytania, tworzony przez odpowiednia fabryke z bebechów jpa

    final static Random randomNumber = new Random();
  //  Map<Integer, Quest> quests = new HashMap<>();

    @Transactional //w transakcje opakowujemy kawałek logiki biznesowej ktory musi wykonać się w całości lub w ogole
    public void createQuest(String description) {
        Quest quest = new Quest(description);
        //zeby zapisac questa:
        em.persist(quest);

    }

    public List<Quest> getAll() {
      //  return new ArrayList<>(quests.values());
       return  em.createQuery("from Quest", Quest.class).getResultList();
    }

    @Transactional
    public void deleteQuest(Quest quest) {
        //quests.remove(quest.getId());
        em.remove(quest);
    }
//
//    @PostConstruct
//    public void init() {
//    }
//
//    @Override
//    public String toString() {
//        return "QuestRepository{" +
//                "questList=" + quests +
//                '}';
//    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    //samo (fixedDelay =2000) znaczy ze czeka na zakonczenie dzialania tej metody i dopiero po zakonczeniu czeka 2s na wykonanie kolejny raz tej metody
    // (fixedRate = 2000) te dwie sekundy są liczone od momentu uruchomienia tej metody czyli od inicjalizacji listy, zyli nie czeka na zakonczenie metdy ktora uruchamiamy co jakis czas
    //(initialDelay = 4000)
    @Transactional
    public void getRandomQuest() { //TODO what for?
        List<String> descriptionList = new ArrayList<>();
        descriptionList.add("Kill the Dragon");
        descriptionList.add("Fight with the Enemy");
        descriptionList.add("Save the Queen");
        descriptionList.add("Hide the treasure");

        String desc = descriptionList.get(randomNumber.nextInt(descriptionList.size()));
        createQuest(desc);
    }

    @Transactional
    public void update(Quest quest) {
      //  quests.put(quest.getId(), quest);
        em.merge(quest); //jesli przeslemy obiekt bez ID to utowrzy nowy,jesli z ID to uaktualni

    }

    public Quest getQuest(Integer id) {
      //  return quests.get(id);
        return em.find(Quest.class, id);
    }
}
