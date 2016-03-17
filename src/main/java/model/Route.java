package model;

/**
 * Created by Eugen on 25.10.2015.
 */
public interface Route {
    int getId();
    String getFromPoint();
    String getToPoint();
    void setFromPoint(String from);
    void setToPoint(String to);
}
