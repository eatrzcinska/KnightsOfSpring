package com.clockworkjava.knigthsofspring.domain;

public class Quest {

    private int id;
    private String description;

    //@Qualifier("lacelot") - to jest adnotacja która mówi którego konkretnie beana wstawic np do argumentu konstruktora
    //np public Castle(@Qualifier(value = "lacelot") Knight knight) - gdy mamy dwoch rycerzy
    //z kolei prz wstrzykiwaniu do pola normalnie pod adnotacja @Autowired
    //a tam gdzie te beany opisujemy czyli w klasie @configuration można też np użyć @Bean(name = "lancelot")
    //i pod spodem @Primary co bedzie oznaczalo, ze to wezmie domyslnie

   public Quest(String description){
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return description;
    }
}
