package com.example.asst_tg_2016_106;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_table";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String AGE = "AGE";
    public static final String MARKS = "MARKS";
    public static final int DB_VERSION = 1;

    public DatabaseHelper(Context context1, String databaseName, @Nullable Context context, int dbVersion) {
        super(context, DATABASE_NAME, null, 1);

    }

    public DatabaseHelper(Context context) {
        super(context,"studentData.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(NAME VARCHAR(60), AGE VARCHAR(2), MARKS VARCHAR(2))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
/*
    public void AddData(String name, String age, String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(MARKS, marks);
        Long result = db.insert(TABLE_NAME, null, contentValues);
        /*if(result == -1)
            return false;
        else
            return true;
    } */

    public String AddData(String name, String age, String marks){
        SQLiteDatabase db = getWritableDatabase();
       db.execSQL("INSERT INTO "+TABLE_NAME+" VALUES('"+name+"', '"+age+"', '"+marks+"')");
        db.close();

        return "Pass";
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }
    public Cursor findData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM " + TABLE_NAME+ " WHERE "+ name + " = " + name +";",null);
        return data;
    }


}