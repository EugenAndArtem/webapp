package model;

import java.util.Map;

/**
 * Created by Eugen on 25.03.2016.
 */
public class InnerFlightWrapper {
    private Flight flight;
    private Map<String,String> errors;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public InnerFlightWrapper() {

    }
}
