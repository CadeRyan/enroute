package com.transport.enroute;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteInfo {

@SerializedName("errorcode")
@Expose
private String errorcode;
@SerializedName("errormessage")
@Expose
private String errormessage;
@SerializedName("numberofresults")
@Expose
private Integer numberofresults;
@SerializedName("route")
@Expose
private String route;
@SerializedName("timestamp")
@Expose
private String timestamp;
@SerializedName("results")
@Expose
private List<Journey> journeys = null;

public String getErrorcode() {
return errorcode;
}

public void setErrorcode(String errorcode) {
this.errorcode = errorcode;
}

public String getErrormessage() {
return errormessage;
}

public void setErrormessage(String errormessage) {
this.errormessage = errormessage;
}

public Integer getNumberofresults() {
return numberofresults;
}

public void setNumberofresults(Integer numberofresults) {
this.numberofresults = numberofresults;
}

public String getRoute() {
return route;
}

public void setRoute(String route) {
this.route = route;
}

public String getTimestamp() {
return timestamp;
}

public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

public List<Journey> getJourneys() {
return journeys;
}

public void setJourneys(List<Journey> journeys) {
this.journeys = journeys;
}

}