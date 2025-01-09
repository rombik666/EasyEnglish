
package com.example.firstapplication.db;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Weather {
    @PrimaryKey(autoGenerate = true)
    public long weatherId;
    public String city;
    public String condition;
    public int temp;
    public int wind;
    public int pressure;
}
