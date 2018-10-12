package com.example.measurepressure;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.RoomDatabase;

import java.net.URI;
import java.util.Date;

/**
 * Created by Иван on 08.09.2018.
 */
@Entity(tableName = "UserDB")
public class UserDB {

    @PrimaryKey(autoGenerate = true)
    public long id;

    private String name;

    private int weight;

    private String age;
    @Ignore
    private URI avatarURI;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getAvatarURI() {
        return avatarURI;
    }

    public void setAvatarURI(URI avatarURI) {
        this.avatarURI = avatarURI;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}