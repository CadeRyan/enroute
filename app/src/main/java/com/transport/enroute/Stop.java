package com.transport.enroute;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stop {

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