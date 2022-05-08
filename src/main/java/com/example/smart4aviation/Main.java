package com.example.smart4aviation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Application implementing solution for below task:
 * Your task is to implement application with two functionalities :
 * 1. For requested Flight Number and date will respond with following :
 * a. Cargo Weight for requested Flight
 * b. Baggage Weight for requested Flight
 * c. Total Weight for requested Flight
 * 2. For requested IATA Airport Code and date will respond with following :
 * a. Number of flights departing from this airport,
 * b. Number of flights arriving to this airport,
 * c. Total number (pieces) of baggage arriving to this airport,
 * d. Total number (pieces) of baggage departing from this airport.
 * @author Przemysław Rewiś
 * @version 0.1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        CargoDatabase cdb = new CargoDatabase();
        FlightDatabase fdb = new FlightDatabase();
        Scanner in =new Scanner(System.in);
        int type = 0;
        int fnumber = 0;
        String date1;
        IATA i;
        while(true)
        {
            System.out.println("Choose functionality 1 or 2: ");
            type = in.nextInt();
            if  (type == 1 || type == 2)
                break;
        }
        switch (type)
        {
            case 1:
                while (true)
                {
                    System.out.println("Enter flight number: ");
                    fnumber=in.nextInt();
                    if (fnumber>= 1000 && fnumber<=9999 )
                        break;
                    else
                        System.out.println("Flight number must be >=1000 and <=9999! ");

                }
                System.out.println("Enter date in format YYYY-MM-ddThh:mm:ssZ: ");
                date1 = in.next();
                int id=fdb.idReturnerFirstRequest(fnumber,date1);
                System.out.println(cdb.baggageWeightReturner(id));
                System.out.println(cdb.cargoWeightReturner(id));
                System.out.println(cdb.totalWeightReturner(id));
                in.close();
                break;
            case 2:
                System.out.println("Enter IATA Airport Code: ");
                i= IATA.valueOf(in.next());
                System.out.println("Enter date in format YYYY-MM-dd: ");
                date1 = in.next();
                ArrayList<Integer> depid = fdb.departureIdReturnerSecondRequest(i,date1);
                if (depid == null)
                {
                    System.out.println("No flights departing in day: "+ date1);
                }
                else
                {
                    System.out.println("Number of flights departing from this airport: "+fdb.howManyFlightsDepartingOrArriving(depid));
                    System.out.println("Total number (pieces) of baggage departing from this airport: " + cdb.howManyBaggagesDepartingOrArriving(depid));
                }
                ArrayList<Integer> arrid = fdb.arrivalIdReturnerSecondRequest(i,date1);
                if (arrid == null)
                {
                    System.out.println("No flights arriving in day: " + date1);
                }
                else
                {
                    System.out.println("Number of flights arriving to this airport: "+fdb.howManyFlightsDepartingOrArriving(arrid));
                    System.out.println("Total number (pieces) of baggage arriving to this airport: " + cdb.howManyBaggagesDepartingOrArriving(arrid));
                }
                in.close();
                break;
            default:
                System.out.println("Unexpected error occured restart application!");
                in.close();
                break;
        }



    }
}
