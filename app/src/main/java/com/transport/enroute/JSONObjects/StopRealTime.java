package com.transport.enroute.JSONObjects;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StopRealTime {

@SerializedName("errorcode")
@Expose
private String errorcode;
@SerializedName("errormessage")
@Expose
private String errormessage;
@SerializedName("numberofresults")
@Expose
private Integer numberofresults;
@SerializedName("stopid")
@Expose
private String stopid;
@SerializedName("timestamp")
@Expose
private String timestamp;
@SerializedName("results")
@Expose
private List<RealtimeResult> realtimeResults = null;

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

public String getStopid() {
return stopid;
}

public void setStopid(String stopid) {
this.stopid = stopid;
}

public String getTimestamp() {
return timestamp;
}

public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

public List<RealtimeResult> getRealtimeResults() {
return realtimeResults;
}

public void setRealtimeResults(List<RealtimeResult> realtimeResults) {
this.realtimeResults = realtimeResults;
}

    public static class RealtimeResult {

    @SerializedName("arrivaldatetime")
    @Expose
    private String arrivaldatetime;
    @SerializedName("duetime")
    @Expose
    private String duetime;
    @SerializedName("departuredatetime")
    @Expose
    private String departuredatetime;
    @SerializedName("departureduetime")
    @Expose
    private String departureduetime;
    @SerializedName("scheduledarrivaldatetime")
    @Expose
    private String scheduledarrivaldatetime;
    @SerializedName("scheduleddeparturedatetime")
    @Expose
    private String scheduleddeparturedatetime;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("destinationlocalized")
    @Expose
    private String destinationlocalized;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("originlocalized")
    @Expose
    private String originlocalized;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("operatortype")
    @Expose
    private String operatortype;
    @SerializedName("additionalinformation")
    @Expose
    private String additionalinformation;
    @SerializedName("lowfloorstatus")
    @Expose
    private String lowfloorstatus;
    @SerializedName("route")
    @Expose
    private String route;
    @SerializedName("sourcetimestamp")
    @Expose
    private String sourcetimestamp;
    @SerializedName("monitored")
    @Expose
    private String monitored;

    public String getArrivaldatetime() {
    return arrivaldatetime;
    }

    public void setArrivaldatetime(String arrivaldatetime) {
    this.arrivaldatetime = arrivaldatetime;
    }

    public String getDuetime() {
    return duetime;
    }

    public void setDuetime(String duetime) {
    this.duetime = duetime;
    }

    public String getDeparturedatetime() {
    return departuredatetime;
    }

    public void setDeparturedatetime(String departuredatetime) {
    this.departuredatetime = departuredatetime;
    }

    public String getDepartureduetime() {
    return departureduetime;
    }

    public void setDepartureduetime(String departureduetime) {
    this.departureduetime = departureduetime;
    }

    public String getScheduledarrivaldatetime() {
    return scheduledarrivaldatetime;
    }

    public void setScheduledarrivaldatetime(String scheduledarrivaldatetime) {
    this.scheduledarrivaldatetime = scheduledarrivaldatetime;
    }

    public String getScheduleddeparturedatetime() {
    return scheduleddeparturedatetime;
    }

    public void setScheduleddeparturedatetime(String scheduleddeparturedatetime) {
    this.scheduleddeparturedatetime = scheduleddeparturedatetime;
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

    public String getDirection() {
    return direction;
    }

    public void setDirection(String direction) {
    this.direction = direction;
    }

    public String getOperator() {
    return operator;
    }

    public void setOperator(String operator) {
    this.operator = operator;
    }

    public String getOperatortype() {
    return operatortype;
    }

    public void setOperatortype(String operatortype) {
    this.operatortype = operatortype;
    }

    public String getAdditionalinformation() {
    return additionalinformation;
    }

    public void setAdditionalinformation(String additionalinformation) {
    this.additionalinformation = additionalinformation;
    }

    public String getLowfloorstatus() {
    return lowfloorstatus;
    }

    public void setLowfloorstatus(String lowfloorstatus) {
    this.lowfloorstatus = lowfloorstatus;
    }

    public String getRoute() {
    return route;
    }

    public void setRoute(String route) {
    this.route = route;
    }

    public String getSourcetimestamp() {
    return sourcetimestamp;
    }

    public void setSourcetimestamp(String sourcetimestamp) {
    this.sourcetimestamp = sourcetimestamp;
    }

    public String getMonitored() {
    return monitored;
    }

    public void setMonitored(String monitored) {
    this.monitored = monitored;
    }

    }
}