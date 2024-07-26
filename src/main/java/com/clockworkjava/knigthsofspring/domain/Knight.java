package com.clockworkjava.knigthsofspring.domain;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Knight {

    private int id;

    @NotNull
    @Size(min=5, max=25)
    private String name;
    private int age;
    private int level;
    private Quest quest;

    public Knight() {
        this.level = 1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public void setQuest(Quest quest) {
        if(quest!=null){
        quest.setStarted(true);
        }
        this.quest = quest;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + " wiek: " + age + " zadanie: " + quest;
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj) return true;
//        if(obj == null || obj.getClass() != getClass()) return false;
//        Knight knight = (Knight) obj;
//        return knight.age == age;
//    }
}
