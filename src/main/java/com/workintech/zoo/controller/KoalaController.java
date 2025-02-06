package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.validations.ZooKoalaValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    public Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
        //koalas.put(1, new Koala(1, "koala", 5.0, 12.0, "female" ));
    }

    @GetMapping
    public List<Koala> find(){
        return this.koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala find(@PathVariable Integer id){
        ZooKoalaValidation.isIdValid(id);
        ZooKoalaValidation.checkKoalaExistence(koalas, id, true);
        return koalas.get(id);
    }

    @PostMapping
    public Koala save(@RequestBody Koala koala){
        ZooKoalaValidation.checkKoalaExistence(koalas, koala.getId(), false);
        ZooKoalaValidation.checkKoalaWeight(koala.getWeight());
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable Integer id, @RequestBody Koala koala){
        ZooKoalaValidation.isIdValid(id);
        ZooKoalaValidation.checkKoalaWeight(koala.getWeight());
        koala.setId(id);
        if(koalas.containsKey(id)){
            koalas.put(id, koala);
            return koalas.get(id);
        } else {
            return save(koala);
        }
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable Integer id){
        ZooKoalaValidation.isIdValid(id);
        ZooKoalaValidation.checkKoalaExistence(koalas, id, true);
        return koalas.remove(id);
    }
}
