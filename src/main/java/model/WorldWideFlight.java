package model;



import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by Eugen on 26.10.2015.
 */
public class WorldWideFlight implements Serializable {
        public static String TYPE="WorldWideFlight";
        private int number;
        private String planeName;
        private String startTime;
        private String flightTime;
    private int id;
    Route route;

        public WorldWideFlight( int number,String planeName,String startTime,String flightTime,Route route){
            this.number=number;
            this.planeName=planeName;
            this.startTime=startTime;
            this.flightTime=flightTime;
            this.route=route;
        }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPlanename(String planeName) {
        this.planeName = planeName;
    }

    public void setStarttime(String startTime) {
        this.startTime = startTime;
    }

    public void setFlighttime(String flightTime) {
        this.flightTime = flightTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public static void setTYPE(String TYPE) {

        WorldWideFlight.TYPE = TYPE;
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

        public String getPlanename(){
            return planeName;
        }

        public String getStarttime(){
            return startTime;
        }

        public String getFlighttime(){
            return flightTime;
        }

    @Transient
    public Route getRoute(){
            return route;
        }
        public String toJson(){

            return null;
        }
    public String toString(){
        return "World Flight "+Integer.toString(number) +" " + planeName + " from " + route.getFromPoint() + " to " + route.getToPoint() + " starts at " + startTime +
                " and arrives at " + flightTime;
    }



}
