package com.example.shoptastic.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shoptastic.db";

    public OrderHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_TABLE = "CREATE TABLE " + OrderContract.OrderEntry.TABLE_NAME + " ("
                + OrderContract.OrderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  OrderContract.OrderEntry.COLUMN_NAME + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_QUANTITY + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_PRICE + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_HASGIFT + " TEXT NOT NULL); ";

        db.execSQL(SQL_TABLE);
        db.execSQL("create Table users(username TEXT primary key, password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;

    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}