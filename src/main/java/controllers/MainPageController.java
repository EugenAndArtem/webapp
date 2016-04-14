package controllers;

import aviaTableX.FlightServiceImpl;
import aviaTableX.ServiceFlight;
import model.Flight;
import model.FlightImpl;
import model.RouteImpl;
import model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Eugen on 28.02.2016.
 */
@Controller
public class MainPageController{

    @Autowired
    private ServiceFlight service;


    public ServiceFlight getService() {
        return service;
    }

    public void setService(FlightServiceImpl service) {
        this.service = service;
    }

    private ArrayList<Flight> getFlights(){
        RouteImpl route;
        ArrayList<Flight> flights=new ArrayList<Flight>();
        try {
            flights=new ArrayList<Flight>(service.getAllFlights());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
    @RequestMapping({"/index"})
    public String handleRequest(Model model){
        ArrayList<Flight> flights=getFlights();
        System.out.println("XXX");
        model.addAttribute("flights",flights);
        return "index";
    }

}
