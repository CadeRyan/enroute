package com.transport.enroute;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Operator {

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