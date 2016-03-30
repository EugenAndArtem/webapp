package controllers;

import model.*;
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
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Eugen on 04.03.2016.
 */
@Controller
public class EditController {

    private ArrayList<Flight> getFlights() {
        RouteImpl route;
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 10; i++) {
            route = new RouteImpl("From Point " + i, "To Point " + i);
            flights.add(new InnerFlight(i, "Plane " + i, "Start Time " + i, "Finish Time " + i));

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
    @RequestMapping(value="/saveFlight",headers="Accept=application/json",method=RequestMethod.POST)
    @ResponseBody
    public InnerFlightWrapper validateFlight(@Valid @RequestBody final InnerFlight flight, BindingResult bindingResult){
        System.out.println("/saveFlight");
        InnerFlightWrapper wrap=new InnerFlightWrapper();
        if(bindingResult.hasErrors()){
            Map<String,String> map=new TreeMap<String, String>();
            map.put("0",bindingResult.getAllErrors().get(0).toString());
            wrap.setErrors(map);

            return wrap;
        }
        else {
            System.out.println("!!!");
            System.out.println(flight);
            wrap.setFlight(flight);
            return wrap;
        }

    }
}
