package com.example.enrouteandroid.CustomObjects;

public class TrainRTIObject {

    String destination;
    String status;
    String due;

    TrainRTIObject(String destination_, String status_, String due_){

        destination = "To " + destination_;
        status = "Status: " + status_;
        due = due_ + " min";
    }
}
