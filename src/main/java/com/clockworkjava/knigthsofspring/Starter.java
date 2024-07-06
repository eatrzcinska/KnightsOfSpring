package com.clockworkjava.knigthsofspring;

import com.clockworkjava.knigthsofspring.domain.Knight;
import com.clockworkjava.knigthsofspring.domain.Quest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Knight lancelot = new Knight("Lanceot", 19, new Quest("żyj"));
        Knight hugo = new Knight("Hugo", 15);

        System.out.println(lancelot);
        System.out.println(hugo);

        Quest zadanie = new Quest("zgnij");
        hugo.setQuest(zadanie);
        System.out.println(hugo);
    }
}
