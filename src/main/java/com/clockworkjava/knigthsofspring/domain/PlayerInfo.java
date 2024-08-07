package com.clockworkjava.knigthsofspring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS) //"session" dla kazdej sesji
@Entity
public class PlayerInfo {

    public PlayerInfo(){  }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    private int gold = 0;
}
