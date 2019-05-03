package com.transport.enroute;

public class Favourite {

    private String friendlyName;
    private String stopNumber;

    public Favourite(String name, String number){

        friendlyName = name;
        stopNumber = number;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getStopNumber() {
        return stopNumber;
    }
}
