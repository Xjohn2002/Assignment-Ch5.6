package com.example.myfinances;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CdDb {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public CdDb(Context context) {
        /// Creates Db
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void insertVals(CD cd) {
        ContentValues vals = new ContentValues();
        vals.put("accountNumber",cd.getAccountNumber());
        vals.put("initialBalance",cd.getInitialBalance());
        vals.put("currentBalance",cd.getCurrentBalance());
        vals.put("interestRate",cd.getInterestRate());
    }

}

