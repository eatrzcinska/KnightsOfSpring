package com.clockworkjava.knigthsofspring.domain;

public class Quest {

    private String description;

   public Quest(String description){
        this.description = description;
    }


    public String toString(){
        return description;
    }
}
