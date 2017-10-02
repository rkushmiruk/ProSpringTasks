package com.kushmiruk.prospring.chapter04.springprofile;

import java.util.ArrayList;
import java.util.List;

public class KindergartenFoodProvider implements FoodProviderService{
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
        return lunchSet ;
    }
}
