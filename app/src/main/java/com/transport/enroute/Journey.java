package com.transport.enroute;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Journey {

@SerializedName("operator")
@Expose
private String operator;
@SerializedName("origin")
@Expose
private String origin;
@SerializedName("originlocalized")
@Expose
private String originlocalized;
@SerializedName("destination")
@Expose
private String destination;
@SerializedName("destinationlocalized")
@Expose
private String destinationlocalized;
@SerializedName("lastupdated")
@Expose
private String lastupdated;
@SerializedName("stops")
@Expose
private List<Stop> stops = null;

public String getOperator() {
return operator;
}

public void setOperator(String operator) {
this.operator = operator;
}

public String getOrigin() {
return origin;
}

public void setOrigin(String origin) {
this.origin = origin;
}

public String getOriginlocalized() {
return originlocalized;
}

public void setOriginlocalized(String originlocalized) {
this.originlocalized = originlocalized;
}

public String getDestination() {
return destination;
}

public void setDestination(String destination) {
this.destination = destination;
}

public String getDestinationlocalized() {
return destinationlocalized;
}

public void setDestinationlocalized(String destinationlocalized) {
this.destinationlocalized = destinationlocalized;
}

public String getLastupdated() {
return lastupdated;
}

public void setLastupdated(String lastupdated) {
this.lastupdated = lastupdated;
}

public List<Stop> getStops() {
return stops;
}

public void setStops(List<Stop> stops) {
this.stops = stops;
}

}