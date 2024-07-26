package com.clockworkjava.knigthsofspring.service;

import com.clockworkjava.knigthsofspring.domain.Quest;
import com.clockworkjava.knigthsofspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class QuestFormatter implements Formatter<Quest>{

    @Autowired
    QuestRepository repository;

    @Override
    public Quest parse(String idAsString, Locale locale) throws ParseException {
        Integer id  = Integer.parseInt(idAsString);
        return repository.getQuest(id);
    }

    @Override
    public String print(Quest object, Locale locale) {
        return object.toString();
    }
}
