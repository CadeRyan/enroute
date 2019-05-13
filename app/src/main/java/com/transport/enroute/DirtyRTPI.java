package com.transport.enroute;

import java.util.ArrayList;
import java.util.List;

public class DirtyRTPI {

    private List<String> routes = new ArrayList<>();
    private List<String> dueTimes = new ArrayList<>();

    public List<String> getRoutes(){
        return routes;
    }

    public void setRoutes(List<String> newRoutes){
        routes = newRoutes;
    }

    public String getRoute(int i){
        return routes.get(i);
    }

    public void addRoute(String newRoute){
        routes.add(newRoute);
    }

    public List<String> getDueTimes(){
        return dueTimes;
    }

    public void setDueTimes(List<String> newDueTimes){
        dueTimes = newDueTimes;
    }

    public String getDuetime(int i){
        return dueTimes.get(i);
    }

    public void addDuetime(String newDuetime){
        dueTimes.add(newDuetime);
    }
}
