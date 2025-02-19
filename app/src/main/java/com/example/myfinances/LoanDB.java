package com.example.myfinances;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoanDB {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public LoanDB(Context context) {
        /// Creates Db
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void insertVals(Loan loan) throws SQLException {
        try{
        ContentValues vals = new ContentValues();
        vals.put("accountNumber",loan.getAccountNumber());
        vals.put("initialBalance",loan.getInitialBalance());
        vals.put("currentBalance",loan.getCurrentBalance());
        vals.put("interestRate",loan.getInterestRate());
        vals.put("paymentAmount",loan.getPaymentAmount());

        this.db.insert("loan", null, vals);
    } catch (Exception e) {
        System.out.println("Error with loan db");
    }

}
}
