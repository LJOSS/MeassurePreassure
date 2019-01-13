package com.example.measurepressure;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.measurepressure.UserDB;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "measuretable")
public class MeassureDB {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "upper")
    private int Upper;
    @ColumnInfo(name = "lower")
    private int Lower;
    @ColumnInfo(name = "pulse")
    private int Pulse;

    @ForeignKey(entity = UserDB.class, parentColumns = "id", childColumns = "Userid", onDelete = CASCADE,onUpdate = CASCADE)
    @ColumnInfo(name = "userid")
    private int Userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
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
}
