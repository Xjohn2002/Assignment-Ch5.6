package com.example.myfinances;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyFinances.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_CD = "CREATE TABLE IF NOT EXISTS CD (" +
            "_id integer primary key autoincrement, " +
            "accountNumber integer not null, " +
            "initialBalance real not null, " +
            "currentBalance real not null, " +
            "interestRate real not null);";

    private static final String CREATE_TABLE_CHECKING = "CREATE TABLE IF NOT EXISTS checking (" +
            "_id integer primary key autoincrement, " +
            "accountNumber integer not null, " +
            "currentBalance real not null);";

    private static final String CREATE_TABLE_LOANS = "CREATE TABLE IF NOT EXISTS loan (" +
            "_id integer primary key autoincrement, " +
            "accountNumber integer not null, " +
            "initialBalance integer not null, " +
            "currentBalance real not null, " +
            "interestRate real not null, " +
            "paymentAmount real not null);";
    public DBHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CHECKING);
        sqLiteDatabase.execSQL(CREATE_TABLE_CD);
        sqLiteDatabase.execSQL(CREATE_TABLE_LOANS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cd");
        onCreate(sqLiteDatabase);
    }
}
