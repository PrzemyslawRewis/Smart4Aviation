package com.example.smart4aviation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class representing database of cargos
 * @param Db ArrayList of CargoEntity objects (package access)
 */

public class CargoDatabase {
    ArrayList<CargoEntity> Db;
    CargoDatabase() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Db = objectMapper.readValue(
                new File("./Cargo.json"),
                new TypeReference<ArrayList<CargoEntity>>() {
                });
    }

    /**
     * @param flightID index of requested flight
     * @return weight of cargo without unit conversion or error information
     */
    public String cargoWeightReturner(int flightID)
    {
        if(flightID == -1)
        {
            String result = "Flight does not exist in database or your input is incorrect";
            return result;
        }

        CargoEntity cargo = Db.get(flightID);
        int kg=0;
        int lb=0;
        ArrayList<Cargo> c = cargo.getCargo();
        for (Cargo i : c)
        {
            switch (i.getWeightUnit())
            {
                case "kg":
                    kg+=i.getWeight();
                    break;
                case "lb":
                    lb+=i.getWeight();
                    break;
            }
        }
        return "Cargo weight for requested flight is: " + kg + " kg + "+ lb +" lb";

    }

    /**
     *
     * @param flightID index of requested flight
     * @return weight of baggage without unit conversion or error information
     */
    public String baggageWeightReturner(int flightID)
    {
        if(flightID == -1)
        {
            String result = "Flight does not exist in database or your input is incorrect";
            return result;
        }
        CargoEntity cargo = Db.get(flightID);
        int kg=0;
        int lb=0;
        ArrayList<Baggage> c = cargo.getBags();
        for (Baggage i : c)
        {
            switch (i.getWeightUnit())
            {
                case "kg":
                    kg+=i.getWeight();
                    break;
                case "lb":
                    lb+=i.getWeight();
                    break;
            }
        }
        return "Baggage weight for requested flight is: " + kg + " kg + "+ lb +" lb";

    }

    /**
     *
     * @param flightID index of requested flight
     * @return total weight summed cargo and baggage weight without unit conversion or error information
     */
    public String totalWeightReturner(int flightID)
    {
        if(flightID == -1)
        {
            String result = "Flight does not exist in database or your input is incorrect";
            return result;
        }
        CargoEntity cargo = Db.get(flightID);
        int kg=0;
        int lb=0;
        ArrayList<Cargo> c = cargo.getCargo();
        for (Cargo i : c)
        {
            switch (i.getWeightUnit())
            {
                case "kg":
                    kg+=i.getWeight();
                    break;
                case "lb":
                    lb+=i.getWeight();
                    break;
            }
        }
        ArrayList<Baggage> c1 = cargo.getBags();
        for (Baggage i : c1)
        {
            switch (i.getWeightUnit())
            {
                case "kg":
                    kg+=i.getWeight();
                    break;
                case "lb":
                    lb+=i.getWeight();
                    break;
            }
        }
        return "Total weight for requested flight is: " + kg + " kg + "+ lb +" lb";

    }

    /**
     * @param ids ArrayList of ids meeting requirements from request
     * @return number of Baggages departing or arriving from given airport during requested day
     */

    int howManyBaggagesDepartingOrArriving(ArrayList<Integer> ids)
    {
        int baggages = 0;
        for (Integer id: ids)
        {
            CargoEntity cargo = Db.get(id);
            ArrayList<Baggage> c1 = cargo.getBags();
            for (Baggage i : c1)
            {
                baggages+=i.getPieces();
            }
        }
        return baggages;
    }

    @Override
    public String toString() {
        return "CargoDatabase{" +
                "Db=" + Db +
                '}';
    }
}
