package com.example.ethansmith.roomscratch;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyTypeConverter {
	// Need converters going both ways or it wont build
	@TypeConverter
	public static int mapToInt(final Map<Integer, Integer> myMap) {
		return 1; // Kludgy to test!
	}

	@TypeConverter
	public static Map<Integer, Integer> intToMap(final int myInt) {
		return new HashMap<Integer, Integer>(); // Kludgy to test!
	}

	@TypeConverter
	public static ArrayList<String> stringToArrayList(String myString) {
		ArrayList<String> myStringList = new ArrayList<>();
		String[] stringArray = myString.split("\\,");
		for(String s : stringArray) {
			myStringList.add(s);
		}
		return myStringList;
	}

	@TypeConverter
	public static String arrayListToString(ArrayList<String> myArrayList) {
		String myString = "";
		for(String s : myArrayList) {
			s += s + ",";
		}
		return myString;
	}

	@TypeConverter
	public static String dateToString(Date d) {
		return "Test";
	}

	@TypeConverter
	public static Date stringToDate(String s) {
		return new Date();
	}
}
