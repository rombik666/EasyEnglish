
package com.example.firstapplication.db;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.firstapplication.db.Weather;

import java.util.List;

@Dao
public interface WeatherDao {
    @Query("SELECT * FROM weather")
    List<Weather> getAllWeathers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Weather weather);
    @Query("DELETE FROM weather")
    void deleteAllWeathers();
}

