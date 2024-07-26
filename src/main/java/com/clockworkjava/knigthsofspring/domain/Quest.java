package com.clockworkjava.knigthsofspring.domain;

public class Quest {

    private int id;
    private String description;
    private int reward = 100;
    private int length = 30000;
    private boolean started = false;
    private boolean finished = false;

    //@Qualifier("lacelot") - to jest adnotacja która mówi którego konkretnie beana wstawic np do argumentu konstruktora
    //np public Castle(@Qualifier(value = "lacelot") Knight knight) - gdy mamy dwoch rycerzy
    //z kolei prz wstrzykiwaniu do pola normalnie pod adnotacja @Autowired
    //a tam gdzie te beany opisujemy czyli w klasie @configuration można też np użyć @Bean(name = "lancelot")
    //i pod spodem @Primary co bedzie oznaczalo, ze to wezmie domyslnie

   public Quest(int id, String description){
        this.description = description;
        this.id = id;
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
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
