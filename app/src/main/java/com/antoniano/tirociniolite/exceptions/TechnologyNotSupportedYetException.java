package com.antoniano.tirociniolite.exceptions;

public class TechnologyNotSupportedYetException extends RuntimeException {

    public TechnologyNotSupportedYetException(String technology) {
        super(technology + " is not supported yet or invalid");
    }
}
