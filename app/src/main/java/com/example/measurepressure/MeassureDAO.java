package com.example.measurepressure;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MeassureDAO {

    @Insert
    void AddMeassure(MeassureDB meassureDB);

    @Query("SELECT * FROM MeassureDB")
    List<MeassureDB> getMeassures();
}
