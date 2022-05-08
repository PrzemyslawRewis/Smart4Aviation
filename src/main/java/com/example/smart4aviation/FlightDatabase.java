package com.example.smart4aviation;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class representing database of  flights
 * @param db ArrayList of flights (package access)
 */

public class FlightDatabase {


    ArrayList<Flight> db;
    FlightDatabase() throws IOException
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        db = objectMapper.readValue(
                new File("./Flight.json"),
                new TypeReference<ArrayList<Flight>>() {
                });
    }

    /**
     *
     * @param flightNumber number of flight
     * @param date date of flight
     * @return (-1 if input is incorrect or flight not exists) or id of requested flight
     */
    int idReturnerFirstRequest(int flightNumber, String date)
    {

       for (Flight flight : db)
       {
           if (flight.getFlightNumber() == flightNumber && flight.getDepartureDate().equals(date))
               return flight.getFlightId();
       }
        return -1;
    }

    /**
     *
     * @param code code of the airport
     * @param date day in format YYYY-MM-DD
     * @return list ids of flights arriving to airport during requested day or null if not exists or bad input
     */
    ArrayList<Integer> arrivalIdReturnerSecondRequest(IATA code, String date)
    {
        String flightdate;
        ArrayList<Integer> flightArrivalId = new ArrayList<Integer>();
        for (Flight flight : db)
        {

            flightdate = flight.getDepartureDate();
            flightdate = flightdate.substring(0,10);
            if(flight.getArrivalAirportIATACode().equals(code) && date.equals(flightdate))
                flightArrivalId.add(flight.getFlightId());
        }
        if(flightArrivalId.isEmpty())
            return null;
        else
            return flightArrivalId;
    }
    /**
     *
     * @param code code of the airport
     * @param date day in format YYYY-MM-DD
     * @return list ids of flights departing from airport during requested day or null if not exists or bad input
     */
    ArrayList<Integer> departureIdReturnerSecondRequest(IATA code, String date)
    {
        String flightdate;
        ArrayList<Integer> flightDepartureId = new ArrayList<Integer>();
        for (Flight flight : db)
        {
            flightdate = flight.getDepartureDate();
            flightdate = flightdate.substring(0,10);
            if(flight.getDepartureAirportIATACode()==code && date.equals(flightdate))
                flightDepartureId.add(flight.getFlightId());
        }
        if(flightDepartureId.isEmpty())
            return null;
        else
            return flightDepartureId;
    }

    /**
     *
     * @param ids
     * @return number of flights arriving or departing from airport during requested day
     */
    int howManyFlightsDepartingOrArriving(ArrayList<Integer> ids)
    {
        return ids.size();
    }

}