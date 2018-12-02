package com.example.measurepressure;

import android.arch.persistence.room.ColumnInfo;

public class UsersWithMeasures {

    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "weight")
    private int Weight;
    @ColumnInfo(name = "upper")
    private int Upper;
    @ColumnInfo(name = "lower")
    private int Lower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getUpper() {
        return Upper;
    }

    public void setUpper(int upper) {
        Upper = upper;
    }

    public int getLower() {
        return Lower;
    }

    public void setLower(int lower) {
        Lower = lower;
    }

    public int getPulse() {
        return Pulse;
    }

    public void setPulse(int pulse) {
        Pulse = pulse;
    }

    @ColumnInfo(name = "pulse")
    private int Pulse;
}
