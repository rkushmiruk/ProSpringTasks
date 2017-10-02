package com.kushmiruk.prospring.chapter03.beanfactory;

public class BookwormOracle implements Oracle {
   private static final String MESSAGE = "Encyclopedia are a waste of money - use the Internet";

    @Override
    public String defineMeaningOfLife() {
        return MESSAGE;
    }
}
