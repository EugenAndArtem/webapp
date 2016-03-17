package model;


import java.io.Serializable;

/**
 * Created by Eugen on 25.10.2015.
 */
public class RouteImpl implements Route,Serializable {
    private int id;
    private String fromPoint;
    private String toPoint;

    public RouteImpl(String from, String to) {
        fromPoint = from;
        toPoint = to;
    }

    public String getFromPoint() {
        return fromPoint;
    }
    public int getId(){
        return id;
    }

    public String getToPoint() {
        return toPoint;
    }

    public RouteImpl() {
    }

    public void setFromPoint(String fromPoint) {

        this.fromPoint = fromPoint;
    }

    public void setToPoint(String toPoint) {
        this.toPoint = toPoint;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String toJson() {
        return null;

    }

    public String toString(){
        return "Route from " + fromPoint + " to " + toPoint;
    }


}
