package com.example.measurepressure;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MeassureDAO {
    @Insert
    void AddMeasure(MeassureDB measureDB);

    @Delete
    void DeleteMeasure(MeassureDB measureDB);

    @Query("SELECT usertable.name,usertable.age,usertable.avatarURI,usertable.weight," +
            "measuretable.Upper,measuretable.Lower,measuretable.Pulse " +
            "FROM measuretable" +
            " JOIN usertable ON usertable.id = measuretable.userid " +
            " WHERE usertable.id = :id_in")
    List<UsersWithMeasures> getAllMeasuresWithUsers(int id_in);

    @Query("SELECT * FROM measuretable")
    List<MeassureDB> getMeasures();
}
