package model;

import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by Eugen on 26.10.2015.
 */
public class InnerFlight implements Flight ,Serializable {
    public static String TYPE="InnerFlight";
    private int number;
    private String planeName;
    private String startTime;
    private String flightTime;
    private int id;
    private Route route;

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
