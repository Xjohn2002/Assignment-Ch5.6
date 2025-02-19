package com.example.myfinances;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CheckingDB {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public CheckingDB(Context context) {
        /// Creates Db
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void insertVals(CheckingAccount checkingAccount) throws SQLException {
        try{
            ContentValues vals = new ContentValues();
            vals.put("accountNumber",checkingAccount.getAccountNumber());

            vals.put("currentBalance",checkingAccount.getCurrentBalance());


            this.db.insert("checking", null, vals);
        } catch (Exception e) {
            System.out.println("Error with checking database");
        }

    }
}
