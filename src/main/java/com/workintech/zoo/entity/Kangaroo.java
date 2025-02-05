package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kangaroo {
    private long id;
    private String name;
    private double height;
    private double weight;
    private double sleepHour;
    private String gender;
    private boolean isAggressive;
}
