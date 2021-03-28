package flightreservationsystem.enums;

import javax.swing.*;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private String value;

    public String getValue() {
        return value;
    }

    private Sex(String female) {
    }
}
