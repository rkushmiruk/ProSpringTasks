package com.kushmiruk.chapter03.collectioninject.annotation;

import org.springframework.stereotype.Service;

@Service("oracle")
public class BookwormOracle implements Oracle {
   private static final String MESSAGE = "Encyclopedia are a waste of money - use the Internet";

    @Override
    public String defineMeaningOfLife() {
        return MESSAGE;
    }
}
