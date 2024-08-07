package com.clockworkjava.knigthsofspring.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private int reward = 100;
    protected int lengthInSec = 10;
    private boolean started = false;
    private boolean finished = false;
    protected LocalDateTime startDate;

    //@Qualifier("lacelot") - to jest adnotacja która mówi którego konkretnie beana wstawic np do argumentu konstruktora
    //np public Castle(@Qualifier(value = "lacelot") Knight knight) - gdy mamy dwoch rycerzy
    //z kolei prz wstrzykiwaniu do pola normalnie pod adnotacja @Autowired
    //a tam gdzie te beany opisujemy czyli w klasie @configuration można też np użyć @Bean(name = "lancelot")
    //i pod spodem @Primary co bedzie oznaczalo, ze to wezmie domyslnie

   public Quest(String description){
        this.description = description;
        this.id = id;
    }

    public Quest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLength() {
        return lengthInSec;
    }

    public void setLength(int length) {
        this.lengthInSec = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
       if(started){
           startDate = LocalDateTime.now();
       }
        this.started = started;
    }

    public boolean isFinished() {
        if (this.finished) {
            return this.finished;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime timeToFinish = this.startDate.plusSeconds(this.lengthInSec);
            boolean isAfter = now.isAfter(timeToFinish);
            if (isAfter) {
                this.finished = true;
            }
            return isAfter;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
