package com.example.smart4aviation;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CargoDatabaseTest {
    CargoDatabase c = new CargoDatabase();

    CargoDatabaseTest() throws IOException {
    }

    @Test
    void inputWorksOK() {

        StringBuilder inputOK = new StringBuilder();
        inputOK.append("CargoDatabase{Db=[CargoEntityflightId=0, bags=[baggage{id=0, weight=815, weightUnit='lb', pieces=176}, baggage{id=1, weight=250, weightUnit='lb', pieces=980}, ");
        inputOK.append("baggage{id=2, weight=568, weightUnit='lb', pieces=728}, baggage{id=3, weight=959, weightUnit='kg', pieces=337}, baggage{id=4, weight=637, weightUnit='kg', pieces=201}], ");
        inputOK.append("cargo=[Cargo{id=0, weight=537, weightUnit='lb', pieces=354}, Cargo{id=1, weight=412, weightUnit='lb', pieces=416}, Cargo{id=2, weight=700, weightUnit='kg', pieces=487}], ");
        inputOK.append("CargoEntityflightId=1, bags=[baggage{id=0, weight=634, weightUnit='kg', pieces=855}, baggage{id=1, weight=327, weightUnit='lb', pieces=790}, ");
        inputOK.append("baggage{id=2, weight=247, weightUnit='kg', pieces=169}, baggage{id=3, weight=862, weightUnit='kg', pieces=355}, ");
        inputOK.append("baggage{id=4, weight=218, weightUnit='kg', pieces=921}, baggage{id=5, weight=861, weightUnit='lb', pieces=856}, ");
        inputOK.append("baggage{id=6, weight=683, weightUnit='lb', pieces=6}, baggage{id=7, weight=828, weightUnit='kg', pieces=900}], ");
        inputOK.append("cargo=[Cargo{id=0, weight=817, weightUnit='kg', pieces=276}, Cargo{id=1, weight=34, weightUnit='lb', pieces=148}, ");
        inputOK.append("Cargo{id=2, weight=921, weightUnit='lb', pieces=739}, Cargo{id=3, weight=782, weightUnit='lb', pieces=764}, ");
        inputOK.append("Cargo{id=4, weight=581, weightUnit='kg', pieces=445}], CargoEntityflightId=2, bags=[baggage{id=0, weight=524, weightUnit='kg', pieces=640}, ");
        inputOK.append("baggage{id=1, weight=932, weightUnit='kg', pieces=60}, baggage{id=2, weight=360, weightUnit='kg', pieces=878}, baggage{id=3, weight=160, weightUnit='kg', pieces=494}, ");
        inputOK.append("baggage{id=4, weight=386, weightUnit='lb', pieces=584}, baggage{id=5, weight=28, weightUnit='lb', pieces=891}, baggage{id=6, weight=160, weightUnit='kg', pieces=654}, ");
        inputOK.append("baggage{id=7, weight=298, weightUnit='lb', pieces=270}], cargo=[Cargo{id=0, weight=724, weightUnit='kg', pieces=110}, Cargo{id=1, weight=11, weightUnit='kg', pieces=382}, ");
        inputOK.append("Cargo{id=2, weight=427, weightUnit='lb', pieces=40}], CargoEntityflightId=3, bags=[baggage{id=0, weight=35, weightUnit='lb', pieces=55}, baggage{id=1, weight=518, weightUnit='lb', pieces=81}, ");
        inputOK.append("baggage{id=2, weight=918, weightUnit='lb', pieces=589}, baggage{id=3, weight=971, weightUnit='kg', pieces=433}, baggage{id=4, weight=484, weightUnit='kg', pieces=590}, baggage{id=5, weight=608, weightUnit='kg', pieces=670}, ");
        inputOK.append("baggage{id=6, weight=154, weightUnit='lb', pieces=315}], cargo=[Cargo{id=0, weight=379, weightUnit='kg', pieces=694}, Cargo{id=1, weight=743, weightUnit='kg', pieces=616}, ");
        inputOK.append("Cargo{id=2, weight=471, weightUnit='kg', pieces=422}, Cargo{id=3, weight=812, weightUnit='lb', pieces=854}], CargoEntityflightId=4, bags=[baggage{id=0, weight=499, weightUnit='kg', pieces=498}, ");
        inputOK.append("baggage{id=1, weight=578, weightUnit='lb', pieces=457}, baggage{id=2, weight=904, weightUnit='kg', pieces=258}, baggage{id=3, weight=244, weightUnit='kg', pieces=564}, baggage{id=4, weight=902, weightUnit='kg', pieces=849}, ");
        inputOK.append("baggage{id=5, weight=908, weightUnit='lb', pieces=742}, baggage{id=6, weight=62, weightUnit='lb', pieces=573}], cargo=[Cargo{id=0, weight=107, weightUnit='lb', pieces=796}, Cargo{id=1, weight=273, weightUnit='lb', pieces=806}, ");
        inputOK.append("Cargo{id=2, weight=492, weightUnit='kg', pieces=88}, Cargo{id=3, weight=823, weightUnit='lb', pieces=665}, Cargo{id=4, weight=864, weightUnit='lb', pieces=950}]]}");
        assertEquals(inputOK.toString(),c.toString());
    }

    @Test
    void cargoWeightReturnerShouldReturnResult(){
        StringBuilder resultOK = new StringBuilder("Cargo weight for requested flight is: 700 kg + 949 lb");
        assertEquals(resultOK.toString(),c.cargoWeightReturner(0));
    }
    @Test
    void cargoWeightReturnerShouldReturnError(){
        StringBuilder resultOK = new StringBuilder("Flight does not exist in database or your input is incorrect");
        assertEquals(resultOK.toString(),c.cargoWeightReturner(-1));
    }

    @Test
    void baggageWeightReturnerShouldReturnResult() {
        StringBuilder resultOK = new StringBuilder("Baggage weight for requested flight is: 1596 kg + 1633 lb");
        assertEquals(resultOK.toString(),c.baggageWeightReturner(0));
    }
    @Test
    void baggageWeightReturnerShouldReturnError() {
        StringBuilder resultOK = new StringBuilder("Flight does not exist in database or your input is incorrect");
        assertEquals(resultOK.toString(),c.baggageWeightReturner(-1));
    }

    @Test
    void totalWeightReturnerShouldReturnResult() {
        StringBuilder resultOK = new StringBuilder("Total weight for requested flight is: 2296 kg + 2582 lb");
        assertEquals(resultOK.toString(),c.totalWeightReturner(0));
    }
    @Test
    void totalWeightReturnerShouldReturnError() {
        StringBuilder resultOK = new StringBuilder("Flight does not exist in database or your input is incorrect");
        assertEquals(resultOK.toString(),c.baggageWeightReturner(-1));
    }
    @Test
    void howManyBaggagesDepartingOrArrivingtest() throws IOException {
        FlightDatabase f2 = new FlightDatabase();
        f2.arrivalIdReturnerSecondRequest(IATA.ANC,"2019-12-09");
        ArrayList<Integer> id= new ArrayList<Integer>();
        id = f2.arrivalIdReturnerSecondRequest(IATA.valueOf("MIT"),"2014-12-30");
        assertEquals(4852,c.howManyBaggagesDepartingOrArriving(id));
    }


}