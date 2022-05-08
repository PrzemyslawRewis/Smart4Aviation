package com.example.smart4aviation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * class representing one cargo entity json object
 * @param flightId index of flight provide relation between cargo and flight entities
 * @param baggage Arraylist of Baggage objects
 * @param cargo Arraylist of Cargo objects
 */
public class CargoEntity {

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    int flightId;
    @JsonProperty("baggage")
    public ArrayList<Baggage> getBags() {
        return baggage;
    }

    public void setBags(ArrayList<Baggage> bags) {
        this.baggage = bags;
    }

    ArrayList <Baggage> baggage;
    @JsonProperty("cargo")
    public ArrayList<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(ArrayList<Cargo> cargo) {
        this.cargo = cargo;
    }

    ArrayList <Cargo> cargo;

    @Override
    public String toString() {
        return "CargoEntity" +
                "flightId=" + flightId +
                ", bags=" + baggage +
                ", cargo=" + cargo;
    }
}
