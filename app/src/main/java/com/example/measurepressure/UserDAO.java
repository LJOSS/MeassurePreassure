package com.example.measurepressure;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void AddUser(UserDB userDB);

    @Delete
    void DeleteUser(UserDB userDB);

    @Query("SELECT * FROM UserDB")
    List<UserDB> getUsers();

}
