package model;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;
import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by Eugen on 26.10.2015.
 */
public class InnerFlight implements Flight ,Serializable {
    public static String TYPE="InnerFlight";
    @NotNull
    private int number;
    @NotNull
    private String planeName;
    @NotNull
    private String startTime;
    @NotNull
    private String flightTime;

    public static String getTYPE() {
        return TYPE;
    }

    @NotNull
    @Size(min=0)
    private int id;
    private Route route=null;
    public InnerFlight() {
    }
    public InnerFlight( int number,String planeName,String startTime,String flightTime,Route route){

        this.number=number;
        this.planeName=planeName;
        this.startTime=startTime;
        this.flightTime=flightTime;
        this.route=route;
    }
    public int getId(){
        return id;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoute(Route route) {
        this.route = route;
    }



    public int getNumber(){
        return number;
    }

    public String getType(){
        return TYPE;
    }

    public String getPlaneName(){
        return planeName;
    }

    public String getStartTime(){
        return startTime;
    }

    public String getFlightTime(){
        return flightTime;
    }

    @Transient public Route getRoute(){
        return route;
    }
    public String toJson(){
        return null;
    }
    public String toString(){
        return "Inner Flight "+Integer.toString(number) +" " + planeName + " from " + route.getFromPoint() + " to " + route.getToPoint() + " starts at " + startTime +
                " and arrives at " + flightTime;
    }

}
