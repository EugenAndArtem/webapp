package controllers;

import aviaTableX.ServiceFlight;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Eugen on 04.03.2016.
 */
@Controller
public class EditController {

    @Autowired
    private ServiceFlight service;

    public void setService(ServiceFlight service) {
        this.service = service;
    }

    private ArrayList<Flight> getFlights() {
        RouteImpl route;
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 10; i++) {
            route = new RouteImpl("From Point " + i, "To Point " + i);
            flights.add(new FlightImpl(i, "Plane " + i, "Start Time " + i, "Finish Time " + i, route, new Type(0)));

        }
        return flights;
    }

    private Flight getFlight(int id) {
        try {
            if (id >= 0)

                return service.getFlightById(id);
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/editFlight")
    public String getEditView(@RequestParam("id") String sId, Model model) {
        System.out.println("Edit");
        Flight flight = null;
        int id = Integer.parseInt(sId);
        flight = getFlight(id);
        model.addAttribute("flight", flight);
        return "edit";
    }

    @RequestMapping(value = "/saveFlight", headers = "Accept=application/json", method = RequestMethod.POST)
    @ResponseBody
    public InnerFlightWrapper validateFlight(@Valid @RequestBody final FlightImpl flight, BindingResult bindingResult) {
        System.out.println("/saveFlight");
        InnerFlightWrapper wrap = new InnerFlightWrapper();
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new TreeMap<String, String>();
            map.put("0", bindingResult.getAllErrors().get(0).toString());
            wrap.setErrors(map);

            return wrap;
        } else {
            try {
                service.updateFlight(flight);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("!!!");
            System.out.println(flight);
            wrap.setFlight(flight);
            return wrap;
        }

    }

    @RequestMapping(value = "/deleteFlight", headers = "Accept=application/json", method = RequestMethod.GET)
    @ResponseBody
    public InnerFlightWrapper deleteFlight(@RequestBody final Integer id) {
        System.out.println("/deleteFlight");
        Map<String, String> map = new TreeMap<String, String>();
        InnerFlightWrapper wrap = new InnerFlightWrapper();
        Flight flight = null;
        try {
            flight = service.getFlightById(id);
            service.deleteFlight(flight);
            map.put("OK","DELETE SUCCESS");
        } catch (SQLException e)
        {
            map.put("SQL_ERROR",e.getMessage());
            wrap.setErrors(map);
        }
        return wrap;
    }
}
