
package com.example.firstapplication.db;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UserWithCity {
    @Embedded public User user;
    @Relation(
            parentColumn = "userId",
            entityColumn = "weatherId",
            associateBy = @Junction(UserWeatherCrossRef.class)
    )
    public List<Weather> weathers;
}