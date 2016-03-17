package controllers;

import model.Flight;
import model.InnerFlight;
import model.Route;
import model.RouteImpl;
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
import java.util.ArrayList;

/**
 * Created by Eugen on 04.03.2016.
 */
@Controller
public class EditController {

    private ArrayList<Flight> getFlights() {
        Route route;
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 10; i++) {
            route = new RouteImpl("From Point " + i, "To Point " + i);
            flights.add(new InnerFlight(i, "Plane " + i, "Start Time " + i, "Finish Time " + i, route));

        }
        return flights;
    }

    private Flight getFlight(int id){
        ArrayList<Flight> flights=getFlights();
        if(id>=0&id<flights.size())return flights.get(id);
        else return null;
    }
    @RequestMapping(value="/editFlight")
    public String getEditView(@RequestParam("id") String sId, Model model){
        System.out.println("Edit");
        Flight flight = null;
        int id = Integer.parseInt(sId);
        flight=getFlight(id);
        model.addAttribute("flight",flight);
        return "edit";
    }
    @RequestMapping(value="/saveFlight",method= RequestMethod.POST)
    @ResponseBody
    public ResponseEntity validateFlight(@Valid @ModelAttribute(value="flight") InnerFlight flight, BindingResult bindingResult){
        System.out.println("/saveFlight");

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return new ResponseEntity(bindingResult, HttpStatus.BAD_REQUEST);
        }
        else {
            System.out.println("!!!");
            System.out.println(flight);
            return new ResponseEntity(flight,HttpStatus.OK);
        }

    }
}
