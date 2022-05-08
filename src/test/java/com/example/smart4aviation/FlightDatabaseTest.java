package com.example.smart4aviation;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightDatabaseTest {
    FlightDatabase f = new FlightDatabase();

    FlightDatabaseTest() throws IOException {
    }

    @Test
    void inputWorksCorrectly()
    {
        ArrayList<Flight> flightManual = new ArrayList<Flight>();
        Flight f0 = new Flight();
        f0.setFlightId(0);
        f0.setFlightNumber(3620);
        f0.setDepartureAirportIATACode(IATA.valueOf("ANC"));
        f0.setArrivalAirportIATACode(IATA.valueOf("GDN"));
        f0.setDepartureDate("2019-12-09T04:42:54-01:00");
        Flight f1 = new Flight();
        f1.setFlightId(1);
        f1.setFlightNumber(2195);
        f1.setDepartureAirportIATACode(IATA.valueOf("YYZ"));
        f1.setArrivalAirportIATACode(IATA.valueOf("MIT"));
        f1.setDepartureDate("2014-12-30T11:14:34-01:00");
        Flight f2 = new Flight();
        f2.setFlightId(2);
        f2.setFlightNumber(9675);
        f2.setDepartureAirportIATACode(IATA.valueOf("YYT"));
        f2.setArrivalAirportIATACode(IATA.valueOf("MIT"));
        f2.setDepartureDate("2015-03-19T01:24:04-01:00");
        Flight f3 = new Flight();
        f3.setFlightId(3);
        f3.setFlightNumber(7734);
        f3.setDepartureAirportIATACode(IATA.valueOf("ANC"));
        f3.setArrivalAirportIATACode(IATA.valueOf("MIT"));
        f3.setDepartureDate("2016-01-13T01:13:36-01:00");
        Flight f4 = new Flight();
        f4.setFlightId(4);
        f4.setFlightNumber(6085);
        f4.setDepartureAirportIATACode(IATA.valueOf("LAX"));
        f4.setArrivalAirportIATACode(IATA.valueOf("PPX"));
        f4.setDepartureDate("2014-07-08T05:29:36-02:00");
        flightManual.add(f0);
        flightManual.add(f1);
        flightManual.add(f2);
        flightManual.add(f3);
        flightManual.add(f4);
        assertEquals(f.db.get(0).getFlightId(),flightManual.get(0).getFlightId());
        assertEquals(f.db.get(1).getFlightId(),flightManual.get(1).getFlightId());
        assertEquals(f.db.get(2).getFlightId(),flightManual.get(2).getFlightId());
        assertEquals(f.db.get(3).getFlightId(),flightManual.get(3).getFlightId());
        assertEquals(f.db.get(4).getFlightId(),flightManual.get(4).getFlightId());
        assertEquals(f.db.get(0).getFlightNumber(),flightManual.get(0).getFlightNumber());
        assertEquals(f.db.get(1).getFlightNumber(),flightManual.get(1).getFlightNumber());
        assertEquals(f.db.get(2).getFlightNumber(),flightManual.get(2).getFlightNumber());
        assertEquals(f.db.get(3).getFlightNumber(),flightManual.get(3).getFlightNumber());
        assertEquals(f.db.get(4).getFlightNumber(),flightManual.get(4).getFlightNumber());
        assertEquals(f.db.get(0).getDepartureAirportIATACode(), flightManual.get(0).getDepartureAirportIATACode());
        assertEquals(f.db.get(1).getDepartureAirportIATACode(), flightManual.get(1).getDepartureAirportIATACode());
        assertEquals(f.db.get(2).getDepartureAirportIATACode(), flightManual.get(2).getDepartureAirportIATACode());
        assertEquals(f.db.get(3).getDepartureAirportIATACode(), flightManual.get(3).getDepartureAirportIATACode());
        assertEquals(f.db.get(4).getDepartureAirportIATACode(), flightManual.get(4).getDepartureAirportIATACode());
        assertEquals(f.db.get(0).getArrivalAirportIATACode(), flightManual.get(0).getArrivalAirportIATACode());
        assertEquals(f.db.get(1).getArrivalAirportIATACode(), flightManual.get(1).getArrivalAirportIATACode());
        assertEquals(f.db.get(2).getArrivalAirportIATACode(), flightManual.get(2).getArrivalAirportIATACode());
        assertEquals(f.db.get(3).getArrivalAirportIATACode(), flightManual.get(3).getArrivalAirportIATACode());
        assertEquals(f.db.get(4).getArrivalAirportIATACode(), flightManual.get(4).getArrivalAirportIATACode());
        assertEquals(f.db.get(0).getDepartureDate(), flightManual.get(0).getDepartureDate());
        assertEquals(f.db.get(1).getDepartureDate(), flightManual.get(1).getDepartureDate());
        assertEquals(f.db.get(2).getDepartureDate(), flightManual.get(2).getDepartureDate());
        assertEquals(f.db.get(3).getDepartureDate(), flightManual.get(3).getDepartureDate());
        assertEquals(f.db.get(4).getDepartureDate(), flightManual.get(4).getDepartureDate());

    }

    @Test
    void idReturnerFirstRequestTestShouldReturn()
    {
        int fID = f.idReturnerFirstRequest(3620,"2019-12-09T04:42:54-01:00");
        assertEquals(0,fID);
    }
    @Test
    void idReturnerFirstRequestTestShouldReturn404()
    {
        int fID = f.idReturnerFirstRequest(1,"2019-12-09T04:42:54-01:00");
        assertEquals(-1,fID);
    }



}