package model;

/**
 * Created by Eugen on 25.10.2015.
 */
public interface Flight {
    int getId();
    int getNumber();
   // String getType();
    String getPlanename();
    String getStarttime();
    String getFlighttime();
    RouteImpl getRoute();
    void setId(int id);
    void setNumber(int number);
    void setStarttime(String startTime);
    void setPlanename(String planeName);
    void setFlighttime(String flightTime);
    void setRoute(RouteImpl route);



}
