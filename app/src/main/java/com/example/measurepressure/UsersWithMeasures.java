package com.example.measurepressure;

import android.arch.persistence.room.ColumnInfo;

public class UsersWithMeasures {

    @ColumnInfo(name = "name")
    private String Name;
    @ColumnInfo(name = "weight")
    private int Weight;
    @ColumnInfo(name = "upper")
    private int Upper;
    @ColumnInfo(name = "lower")
    private int Lower;
    @ColumnInfo(name = "age")
    private String age;
    @ColumnInfo(name = "pulse")
    private int Pulse;
    @ColumnInfo(name = "avatarURI")
    private String avatarURI;

    public String getAvatarURI() {
        return avatarURI;
    }

    public void setAvatarURI(String avatarURI) {
        this.avatarURI = avatarURI;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
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

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
}
