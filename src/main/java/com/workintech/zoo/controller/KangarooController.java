package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

public class KangarooController {
    public Map<Long, Kangaroo> kangaroos;

    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
        kangaroos.put(1L, new Kangaroo(1L, "koala", 2.0, 5.0, 8.0, "female", true ));
    }
}
