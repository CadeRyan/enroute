package com.example.enrouteandroid.CustomObjects;

public class FavouriteObject {

    String name;
    String address;
    int identifier;

    FavouriteObject(String name_, int identifier_){

        name = name_;
        identifier = identifier_;
    }

    FavouriteObject(String name_, int identifier_, String address_){

        name = name_;
        identifier = identifier_;
        address = address_;
    }
}
