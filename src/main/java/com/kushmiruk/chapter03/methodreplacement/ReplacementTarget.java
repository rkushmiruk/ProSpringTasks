package com.kushmiruk.chapter03.methodreplacement;

public class ReplacementTarget {
    public String formatMessage(String msg) {
        return "<h1>" + msg + "<h1>";
    }

    public String formatMessage(Object msg) {
        return "<h1>" + msg + "<h1>";
    }
}
