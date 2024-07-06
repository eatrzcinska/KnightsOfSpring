package com.clockworkjava.knigthsofspring.domain;

public class Knight {

    private String name;
    private int age;
    private Quest quest;

    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        //this.quest = new Quest("uratuj ksiezniczke"); //tworzenie zadania przez słówko new w konstruktorze
        this.quest = quest;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest){
        this.quest = quest;
    }

    public String toString() {
        return "Rycerz o imieniu " + name + " wiek: " + age + " zadanie: " + quest;
    }
}
