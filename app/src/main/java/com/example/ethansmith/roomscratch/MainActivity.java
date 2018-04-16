package com.example.ethansmith.roomscratch;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Timber.plant(new Timber.DebugTree());

		Timber.d("Start");

		MyDatabase myDatabase = Room.databaseBuilder(this, MyDatabase.class, "MyDatabase")
			.allowMainThreadQueries()
			.fallbackToDestructiveMigration()
			.build();

		final MyUserDao myUserDao = myDatabase.myUserDao();

		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				myUserDao.nukeTable();
				myUserDao.insert(new MyUser(15, "John", true));
				myUserDao.insert(new MyUser(12, "Dope", false));
				myUserDao.insert(new MyUser(100, "Here", true));
			}
		});



		myUserDao.getUserListMaybe()
			.subscribe(new MaybeObserver<List<MyUser>>() {
				@Override
				public void onSubscribe(Disposable d) {
					Timber.d("onSubscribe");
				}

				@Override
				public void onSuccess(List<MyUser> myUsers) {
					Timber.d("onSuccess");
					for(MyUser myUser : myUsers)
						Timber.d("User: " + myUser.toString());
				}

				@Override
				public void onError(Throwable e) {
					Timber.d("onError");

				}

				@Override
				public void onComplete() {
					Timber.d("onComplete");

				}
			});

//		myUserDao.getUserAgeMaybe("Dope")
//			.subscribe(new MaybeObserver<Integer>() {
//				@Override
//				public void onSubscribe(Disposable d) {
//					Timber.d("onSubscribe");
//				}
//
//				@Override
//				public void onSuccess(Integer age) {
//					Timber.d("onSuccess");
//					Timber.d("Age: " + age);
//
//				}
//
//				@Override
//				public void onError(Throwable e) {
//					Timber.d("onError");
//
//				}
//
//				@Override
//				public void onComplete() {
//					Timber.d("onComplete");
//
//				}
//			});

		myUserDao.isUserCoolMaybe("Dopeooo")
			.subscribe(new MaybeObserver<Boolean>() {
				@Override
				public void onSubscribe(Disposable d) {
					Timber.d("isUserCoolMaybe onSubscribe");

				}

				@Override
				public void onSuccess(Boolean isCool) {
					Timber.d("isUserCoolMaybe onSuccess: " + isCool);

				}

				@Override
				public void onError(Throwable e) {
					Timber.d("isUserCoolMaybe onError");

				}

				@Override
				public void onComplete() {
					Timber.d("isUserCoolMaybe onComplete");

				}
			});

		myUserDao.insert(new MyUser(10, "More", true));

		myUserDao.insert(new MyUser(10, "Dope", true));


//		List<MyUser> myUserList = myUserDao.getUserList();
//
//		for(MyUser myUser : myUserList) {
//			Log.d("This", myUser.toString());
//		}
//
//		boolean isCool = myUserDao.isUserCool("Dopeee");
//		Log.d("This", "John is.....: " + isCool);



		Timber.d("Finish");
	}
}
