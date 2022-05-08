package com.example.smart4aviation;


/**
 * class representing one json cargo object
 * @param id id of baggage
 * @param weight weight of baggage
 * @param weightUnit unit of weight (kg or lb)
 * @param pieces number of pieces of baggage
 */

public class Cargo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    int weight;

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    String weightUnit;

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    int pieces;


    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", weight=" + weight +
                ", weightUnit='" + weightUnit + '\'' +
                ", pieces=" + pieces +
                '}';
    }
}
