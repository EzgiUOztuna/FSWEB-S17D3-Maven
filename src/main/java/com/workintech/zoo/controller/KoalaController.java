package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

public class KoalaController {
    public Map<Long, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
        koalas.put(1L, new Koala(1L, "koala", 5.0, 12.0, "female" ));
    }
}
