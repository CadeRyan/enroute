package com.transport.enroute.JSONObjects;

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

    public static class Journey {

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

        public static class Operator {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("operatortype")
        @Expose
        private Integer operatortype;
        @SerializedName("routes")
        @Expose
        private List<String> routes = null;

        public String getName() {
        return name;
        }

        public void setName(String name) {
        this.name = name;
        }

        public Integer getOperatortype() {
        return operatortype;
        }

        public void setOperatortype(Integer operatortype) {
        this.operatortype = operatortype;
        }

        public List<String> getRoutes() {
        return routes;
        }

        public void setRoutes(List<String> routes) {
        this.routes = routes;
        }

        }

        public static class Stop {

        @SerializedName("stopid")
        @Expose
        private String stopid;
        @SerializedName("displaystopid")
        @Expose
        private String displaystopid;
        @SerializedName("shortname")
        @Expose
        private String shortname;
        @SerializedName("shortnamelocalized")
        @Expose
        private String shortnamelocalized;
        @SerializedName("fullname")
        @Expose
        private String fullname;
        @SerializedName("fullnamelocalized")
        @Expose
        private String fullnamelocalized;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("operators")
        @Expose
        private List<Operator> operators = null;

        public String getStopid() {
        return stopid;
        }

        public void setStopid(String stopid) {
        this.stopid = stopid;
        }

        public String getDisplaystopid() {
        return displaystopid;
        }

        public void setDisplaystopid(String displaystopid) {
        this.displaystopid = displaystopid;
        }

        public String getShortname() {
        return shortname;
        }

        public void setShortname(String shortname) {
        this.shortname = shortname;
        }

        public String getShortnamelocalized() {
        return shortnamelocalized;
        }

        public void setShortnamelocalized(String shortnamelocalized) {
        this.shortnamelocalized = shortnamelocalized;
        }

        public String getFullname() {
        return fullname;
        }

        public void setFullname(String fullname) {
        this.fullname = fullname;
        }

        public String getFullnamelocalized() {
        return fullnamelocalized;
        }

        public void setFullnamelocalized(String fullnamelocalized) {
        this.fullnamelocalized = fullnamelocalized;
        }

        public String getLatitude() {
        return latitude;
        }

        public void setLatitude(String latitude) {
        this.latitude = latitude;
        }

        public String getLongitude() {
        return longitude;
        }

        public void setLongitude(String longitude) {
        this.longitude = longitude;
        }

        public List<Operator> getOperators() {
        return operators;
        }

        public void setOperators(List<Operator> operators) {
        this.operators = operators;
        }

        }
    }
}