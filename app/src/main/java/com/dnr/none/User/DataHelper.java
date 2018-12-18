package com.dnr.none.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dnr.none.Login.User;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bola.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "user";

    //TABLE USERS COLUMNS
    //ID COLUMN @primaryKey
    public static final String KEY_ID = "id";

    //COLUMN username
    public static final String KEY_USERNAME = "username";

    //COLUMN full name
    public static final String KEY_FULL_NAME = "fullname";

    //COLUMN email
    public static final String KEY_EMAIL = "email";

    //COLUMN password
    public static final String KEY_PASSWORD = "password";

    //SQL for creating users table
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_USERNAME + " TEXT, "
            + KEY_FULL_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT"
            + " ) ";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table list(no integer primary key, tim text null, tgl text null, tempat text null, longitude double null, latitude double null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

//        String sql2 = "create table user(id integer primary key, username text null, nama text null, email text null, pass text null);";
//        Log.d("DATA", "onCreate: " + sql2);
//        db.execSQL(sql2);

        sql = "INSERT INTO list (no, tim, tgl, tempat, longitude, latitude) VALUES ('1','FC Barcelona VS Chelsea', '1018-05-12', 'Stadion Dean Court','-7.975464','112.625077');";
        db.execSQL(sql);

        db.execSQL(SQL_TABLE_USERS);
//        sql2 = "INSERT INTO user (id, username, nama, email, pass) VALUES ('1', 'dinar', 'Dinarpratnya Ningrum', 'dinarpratnya12@gmail.com', 'dinar123');";
//        db.execSQL(sql2);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int arg1, int arg2) {
        // TODO Auto-generated method stub
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }
    public void addUser(User user) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        //Put username in  @values
        values.put(KEY_USERNAME, user.username);

        //Put username in  @values
        values.put(KEY_FULL_NAME, user.nama);

        //Put email in  @values
        values.put(KEY_EMAIL, user.email);

        //Put password in  @values
        values.put(KEY_PASSWORD, user.password);

        // insert row
        long todo_id = db.insert(TABLE_USERS, null, values);
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_USERNAME, KEY_FULL_NAME, KEY_EMAIL, KEY_PASSWORD},//Selecting columns want to query
                KEY_USERNAME + "=?",
                new String[]{user.username},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean isEmailExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_USERNAME, KEY_FULL_NAME, KEY_EMAIL, KEY_PASSWORD},//Selecting columns want to query
                KEY_USERNAME + "=?",
                new String[]{username},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }
}