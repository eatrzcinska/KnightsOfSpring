package com.clockworkjava.knigthsofspring.utils;

import java.util.Set;

public class Ids {

    public static int generateNewId (Set<Integer> ExistingIds){
        if(ExistingIds.isEmpty()){
            return 0;
        } else {
            Integer id = ExistingIds.stream().max((o1,o2) -> o1.compareTo(o2)).get();
            return id+1;
        }
    }
}
