package com.example.ethansmith.roomscratch;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.reactivex.Maybe;

@Dao
public interface MyUserDao {
	@Insert
	void insert(MyUser myUser);

	@Query("SELECT * FROM userTable")
	List<MyUser> getUserList();

//	@Query("SELECT isCool FROM userTable WHERE name is :name")
//	boolean isUserCool(String name);

	// This breaks it somehow. List is empty
	@Query("SELECT isCool FROM userTable WHERE name is :name")
	Boolean isUserCool(String name);

//	// This breaks it somehow. List is empty
//	@Query("SELECT isCool FROM userTable WHERE name is :name")
//	LiveData<Boolean> isUserCool(String name);

//	 This breaks it somehow. List is empty
	@Query("SELECT isCool FROM userTable WHERE name is :name")
	Maybe<Boolean> isUserCoolMaybe(String name);

//	@Query("SELECT isCool FROM userTable WHERE name is :name")
//	int isUserCool(String name);

//	@Query("SELECT isCool FROM userTable WHERE name is :name")
//	Integer isUserCool(String name);

//	@Query("SELECT isCool FROM userTable WHERE name is :name")
//	Maybe<Integer> isUserCool(String name);

//	// Explicit compile error. Type mismatch
//	@Query("SELECT isCool FROM userTable WHERE name is :name")
//	String isUserCool(String name);

//	// Gives TypeConverter error
//	@Query("SELECT myMap FROM userTable")
//	Map<Integer, Integer> getMyMap();

	// Not sure how to convert a Cursor
//	@Query("SELECT hobbies FROM userTable")
//	ArrayList<String> getHobbies();

//	@Query("SELECT birthDate FROM userTable")
//	Maybe<Date> getBirthdate();

	@Query("SELECT * FROM userTable")
	Maybe<List<MyUser>> getUserListMaybe();

	@Query("SELECT age FROM userTable WHERE name is :name")
	Maybe<Integer> getUserAgeMaybe(String name);

	@Query("DELETE from userTable")
	void nukeTable();
}

