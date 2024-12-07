package com.klef.jfsd.exam;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/vehicles")

public class ClientDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create sample data for Vehicle, Car, and Truck
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car car = new Car();
        car.setId(1);
        car.setName("Sedan");
        car.setType("Car");
        car.setMaxSpeed(160);
        car.setColor("Red");
        car.setNumberOfDoors(4);
        vehicles.add(car);
        
        Truck truck = new Truck();
        truck.setId(2);
        truck.setName("Freightliner");
        truck.setType("Truck");
        truck.setMaxSpeed(120);
        truck.setColor("Blue");
        truck.setLoadCapacity(15.5);
        vehicles.add(truck);

        // Display Vehicle Details in HTML format
        out.println("<html><body>");
        out.println("<h1>Vehicle Details</h1>");
        for (Vehicle v : vehicles) {
            out.println("<h2>" + v.getType() + "</h2>");
            out.println("<p>ID: " + v.getId() + "</p>");
            out.println("<p>Name: " + v.getName() + "</p>");
            out.println("<p>Max Speed: " + v.getMaxSpeed() + " km/h</p>");
            out.println("<p>Color: " + v.getColor() + "</p>");

            if (v instanceof Car) {
                Car c = (Car) v;
                out.println("<p>Number of Doors: " + c.getNumberOfDoors() + "</p>");
            } else if (v instanceof Truck) {
                Truck t = (Truck) v;
                out.println("<p>Load Capacity: " + t.getLoadCapacity() + " tons</p>");
            }
            out.println("<hr>");
        }
        out.println("</body></html>");
    }
}
