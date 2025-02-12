package com.example.myfinances;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CheckingDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myFinances.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation sql statement
    private static final String "CREATE TABLE IF NOT EXISTS checking (" +
            "_id integer primary key autoincrement, " +
            "accountnumber integer not null, " +
            "currentbalance real not null);";



    public CheckingDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }


}
