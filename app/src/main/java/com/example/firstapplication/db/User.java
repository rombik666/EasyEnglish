
package com.example.firstapplication.db;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public long userId;
    public String email;
    public String password;
}

