package com.kushmiruk.prospring.chapter04.springprofile;

import java.util.ArrayList;
import java.util.List;

public class HighSchoolFoodProvider implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("French Fries"));
        lunchSet.add(new Food("hamburger"));
        return lunchSet ;
    }
}
