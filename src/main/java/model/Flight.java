package model;

/**
 * Created by Eugen on 25.10.2015.
 */
public interface Flight {
    int getId();
    int getNumber();
    String getType();
    String getPlaneName();
    String getStartTime();
    String getFlightTime();
    Route getRoute();
    void setId(int id);
    void setNumber(int number);
    void setStartTime(String startTime);
    void setPlaneName(String planeName);
    void setFlightTime(String flightTime);
    void setRoute(Route route);



}
