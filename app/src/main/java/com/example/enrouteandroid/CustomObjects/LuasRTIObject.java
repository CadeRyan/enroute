package com.example.enrouteandroid.CustomObjects;

public class LuasRTIObject {

    String destination;
    String dueTime;

    LuasRTIObject(String destination_, String dueTime_){

        destination = "To " + destination_;
        if(dueTime_.equals("DUE")){
            dueTime = dueTime_;
        }
        else {
            dueTime = dueTime_ + "min";
        }
    }
}
