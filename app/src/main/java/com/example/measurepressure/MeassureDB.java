package com.example.measurepressure;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "MeassureDB",foreignKeys = @ForeignKey(entity = UserDB.class,parentColumns = "ID",childColumns = "ID",onDelete = CASCADE))
public class MeassureDB {

    @PrimaryKey(autoGenerate = true)
    public long ID;

    private int meassureUP;

    private int meassureDOWN;

    private int Pulse;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getMeassureUP() {
        return meassureUP;
    }

    public void setMeassureUP(int meassureUP) {
        this.meassureUP = meassureUP;
    }

    public int getMeassureDOWN() {
        return meassureDOWN;
    }

    public void setMeassureDOWN(int meassureDOWN) {
        this.meassureDOWN = meassureDOWN;
    }

    public int getPulse() {
        return Pulse;
    }

    public void setPulse(int pulse) {
        Pulse = pulse;
    }
}
