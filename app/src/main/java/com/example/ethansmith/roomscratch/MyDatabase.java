package com.example.ethansmith.roomscratch;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = MyUser.class, version = 5, exportSchema = false)
//@TypeConverters({MyTypeConverter.class})
public abstract class MyDatabase extends RoomDatabase {
	public abstract MyUserDao myUserDao();
}
