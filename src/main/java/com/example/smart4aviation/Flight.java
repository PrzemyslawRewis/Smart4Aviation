package com.example.smart4aviation;


/**
 * class representing flight
 * @param flightId index of flight
 * @param flightNumber number of flight
 * @param departureAirportIATACode International Air Transport Association code of departure airport
 * @param arrivalAirportIATACode International Air Transport Association code of arrival airport
 * @param departureDate date of departure format (YYYY-MM-ddThh:mm:ssZ) stored as String
 *
 */

public class Flight {

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    private int flightId;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    private int flightNumber;

    public IATA getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(IATA departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    private IATA departureAirportIATACode;

    public IATA getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(IATA arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    private IATA arrivalAirportIATACode;


    private String departureDate;

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    public String getDepartureDate() {
        return departureDate;
    }


    @Override
    public String toString() {
        return "Flight" +
                "flightId=" + flightId +
                ", flightNumber=" + flightNumber +
                ", departureAirportIATACode=" + departureAirportIATACode +
                ", arrivalAirportIATACode=" + arrivalAirportIATACode +
                ", departureDate='" + departureDate + '\'';
    }


}

