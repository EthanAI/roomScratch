package com.example.ethansmith.roomscratch;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Entity(tableName = "userTable")
public class MyUser {
	@PrimaryKey(autoGenerate = true)
	int id;
	int age;
	String name;
	public boolean isCool;
//	Map<Integer, Integer> myMap;  // Gives type conversion error

//	public ArrayList<String> hobbies;
//	Date birthDate;

	public MyUser(int age, String name, boolean isCool) {
		this.age = age;
		this.name = name;
		this.isCool = isCool;
	}

	@Override
	public String toString() {
		return age + " " + name + " isCool: " + isCool;
	}
}
