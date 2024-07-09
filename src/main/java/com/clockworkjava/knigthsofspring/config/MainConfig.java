package com.clockworkjava.knigthsofspring.config;

import org.springframework.context.annotation.*;

@Configuration
//@ImportResource("classpath:config/castle-cofig.xml") - może zaimportować dodatkową konfigurację dla kontenera który znajduje się w pliku xml
//@PropertySource("classpath:resources/castle.properties")
public class MainConfig {

    // konfiguracja rzez klasę @Configuration , spring wie, ze ta klasa zawiera definicję beanów
    //ta klasa musi znajdować się na sciezce przeszukiwanej w poszukiwaniu componentów javowych
    // tutaj definiujemy za pomocą meod zwracający h danego beana, z adnotacją @Bean

    //w przypadku klas nazwa @Componentów jest brana z nazwy klasy
    //w przypadku klasy konfiguracyjnej nazwa beana jest brana z nazwy metody - chodzi o to jak piszemy ref w xmlu lub modelu to dajemy nazwe meody jaka zwraca danego beana
// można tez dac adnotacje przy @Bean(name = "lancelot") i adnotacje @Primary gdy to domyslna instancja
    //@Qualifier(value = "xcv") - adnotacja w miejscu w ktorym wstrzykujemy beana z podaną jego konkretną nazwę beana

    //z kolei dodajac adnotacje @autowired nad lisą rycerzy powoduje wstrzyknięcie całej listy rycerzy



//    @Bean(name="inMemoryKnightRepository")
//    @Profile("dev")
//    public KnightRepository createInMemoryRepo (){
//        KnightRepository repo = new InMemoryRepository();//to co nasza metoda zwróci będzie traktowane jako bean
//        return repo;
//    }
}