package model;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Eugen on 26.10.2015.
 */
public class InnerFlight implements Flight,Serializable {
    //public static String TYPE="InnerFlight";
    @Min(0)
    private int number;
    @NotNull
    private String planename;
    @NotNull
    private String starttime;
    @NotNull
    private String flighttime;
    @NotNull
    private RouteImpl route;

    public RouteImpl getRoute() {
        return route;
    }

    public void setRoute(RouteImpl route) {
        this.route = route;
    }
    //    public static String getTYPE() {
//        return TYPE;
//    }


    private int id;

    public InnerFlight() {
    }
    public InnerFlight(int number, String planename, String starttime, String flighttime){

        this.number=number;
        this.planename = planename;
        this.starttime = starttime;
        this.flighttime = flighttime;
    }
    public int getId(){
        return id;
    }

    public void setPlanename(String planename) {
        this.planename = planename;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setFlighttime(String flighttime) {
        this.flighttime = flighttime;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getNumber(){
        return number;
    }

//    public String getType(){
//        return TYPE;
//    }

    public String getPlanename(){
        return planename;
    }

    public String getStarttime(){
        return starttime;
    }

    public String getFlighttime(){
        return flighttime;
    }

    public String toJson(){
        return null;
    }
    public String toString(){
        return "Inner Flight "+Integer.toString(number) +" " + planename + " from "  + " starts at " + starttime +
                " and arrives at " + flighttime;
    }

}
