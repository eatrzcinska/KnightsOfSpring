package com.clockworkjava.knigthsofspring.components;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
//@Scope("prototype") i tak pokaze caly czas ta sama godzine bo nasz cotroller jest singletonem
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) //"session" dla kazdej sesji
public class TimeComponent {

    private LocalDateTime time = LocalDateTime.now();

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
