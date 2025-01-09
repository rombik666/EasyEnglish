
package com.example.firstapplication.db;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE email = :mail")
    User getUserByEmail(String mail);

    @Transaction
    @Query("SELECT * FROM user WHERE email = :mail")
    UserWithCity getUserWithWeatherByEmail(String mail);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser (User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserWithWeather(UserWeatherCrossRef userWeatherCrossRef);
    @Query("SELECT * FROM userweathercrossref Where userid=:userid")
    UserWithCity getAllUserWeathers(long userid);
    @Query("DELETE FROM userweathercrossref")
    void deleteAllUsersWithWeather();

    @Query("DELETE FROM user")
    void deleteAllUsers();
    @Query("SELECT userId FROM user WHERE email = :mail LIMIT 1")
    Integer getUserIdByEmail(String mail);
    @Query("SELECT email FROM user WHERE email = 1 LIMIT 1")
    String getCurrentUserEmail();
    @Query("DELETE FROM UserWeatherCrossRef WHERE weatherId = :weatherId AND userId = :userId")
    void deleteUserWeatherCrossRef(long weatherId, long userId);

}
