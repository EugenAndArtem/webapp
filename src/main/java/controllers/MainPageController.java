package controllers;

import model.Flight;
import model.InnerFlight;
import model.Route;
import model.RouteImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Eugen on 28.02.2016.
 */
@Controller
public class MainPageController{
    private ArrayList<Flight> getFlights(){
        Route route;
        ArrayList<Flight> flights=new ArrayList<Flight>();
        for(int i=0;i<10;i++){
            route=new RouteImpl("From Point "+i,"To Point "+i);
            flights.add(new InnerFlight(i,"Plane "+i,"Start Time "+i,"Finish Time "+i,route));

        }
        return flights;
    }
    @RequestMapping({"/index","/"})
    public String handleRequest(Model model){
        ArrayList<Flight> flights=getFlights();
        System.out.println("XXX");
        model.addAttribute("flights",flights);
        return "index";
    }

}
