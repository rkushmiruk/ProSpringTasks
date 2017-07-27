package com.kushmiruk.chapter03;

public class BookwormOracle implements Oracle {
    private static final String message = "Encyclopedias are a waste of money - use the Internet";

    @Override
    public String defineMeaningOfLife() {
        return message;
    }
}
