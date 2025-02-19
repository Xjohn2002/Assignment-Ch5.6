package com.example.myfinances;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void alert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setMessage("Data Saved to Database Successfully!");
        alert.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alert.create();
        alert.show();
    }
    void initState(){
        RadioGroup radioGroup = findViewById(R.id.rGroupAccountOptions);
        EditText paymentAmount = findViewById(R.id.etPaymentAmount);
        radioGroup.check(R.id.cdRadioBtn);
        paymentAmount.setEnabled(false);
    }
    public void radioGroupChange(){
        RadioGroup radioGroup = findViewById(R.id.rGroupAccountOptions);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton cdRadioButton = findViewById(R.id.cdRadioBtn);
                RadioButton loanRadioButton = findViewById(R.id.loanRadioBtn);
                RadioButton checkingRadioButton = findViewById(R.id.checkingRadioBtn);

                EditText accountNumber = findViewById(R.id.etAccountNum);
                EditText initialBalance = findViewById(R.id.etInitialBalance);
                EditText currentBalance = findViewById(R.id.etCurrentBalance);
                EditText interestRate = findViewById(R.id.etInterestRate);
                EditText paymentAmount = findViewById(R.id.etPaymentAmount);

                if (cdRadioButton.isChecked()) {
                    accountNumber.setEnabled(true);
                    initialBalance.setEnabled(true);
                    currentBalance.setEnabled(true);
                    interestRate.setEnabled(true);
                    paymentAmount.setEnabled(false);


                } else if (loanRadioButton.isChecked()) {
                    accountNumber.setEnabled(true);
                    initialBalance.setEnabled(true);
                    currentBalance.setEnabled(true);
                    interestRate.setEnabled(true);
                    paymentAmount.setEnabled(true);

                } else if (checkingRadioButton.isChecked()) {
                    accountNumber.setEnabled(true);
                    initialBalance.setEnabled(false);
                    currentBalance.setEnabled(true);
                    interestRate.setEnabled(false);
                    paymentAmount.setEnabled(false);
                }

            }

        });
    }
    public void initSaveBtn() {
        Button saveButton = findViewById(R.id.saveBtn);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton cdRadioButton = findViewById(R.id.cdRadioBtn);
                RadioButton loanRadioButton = findViewById(R.id.loanRadioBtn);
                RadioButton checkingRadioButton = findViewById(R.id.checkingRadioBtn);

                EditText accountNumber = findViewById(R.id.etAccountNum);
                EditText initialBalance = findViewById(R.id.etInitialBalance);
                EditText currentBalance = findViewById(R.id.etCurrentBalance);
                EditText interestRate = findViewById(R.id.etInterestRate);
                EditText paymentAmount = findViewById(R.id.etPaymentAmount);

                int accountNum = 0;
                double initialBal = 0;
                double currentBal = 0;
                double intRate = 0;
                double paymentAmt = 0;

                if (!accountNumber.getText().toString().isEmpty()) {
                    accountNum = Integer.parseInt(accountNumber.getText().toString());
                }
                if (!initialBalance.getText().toString().isEmpty()) {
                    initialBal = Integer.parseInt(initialBalance.getText().toString());
                }
                if (!currentBalance.getText().toString().isEmpty()) {
                    currentBal = Integer.parseInt(currentBalance.getText().toString());
                }
                if (!interestRate.getText().toString().isEmpty()) {
                    intRate = Integer.parseInt(interestRate.getText().toString());
                }
                if (!paymentAmount.getText().toString().isEmpty()) {
                    paymentAmt = Integer.parseInt(paymentAmount.getText().toString());
                }

                if (cdRadioButton.isChecked()) {
                    try {
                        CD cd = new CD(accountNum, initialBal, currentBal, intRate);

                        CdDb cdDb = new CdDb(MainActivity.this);

                        cdDb.open();
                        cdDb.insertVals(cd);
                        cdDb.close();
                        alert();
                        deleteText();
                    } catch (Exception e) {
                        System.out.println("Error with cd db");
                    }
                } else if (loanRadioButton.isChecked()) {
                    try {
                        Loan loan = new Loan(accountNum, initialBal, currentBal, paymentAmt, intRate);

                        LoanDB loanDB = new LoanDB(MainActivity.this);

                        loanDB.open();
                        loanDB.insertVals(loan);
                        loanDB.close();
                        alert();
                        deleteText();
                    } catch (Exception e) {
                        System.out.println("Error with LoanDB");
                    }
                } else if (checkingRadioButton.isChecked()) {
                    try {
                        CheckingAccount checkingAccount =
                                new CheckingAccount(accountNum, currentBal);

                        CheckingDB checkingDB = new CheckingDB(MainActivity.this);
                        CheckingDB.open();
                        CheckingDB.insertVals(checkingAccount);
                        alert();
                        deleteText();
                    } catch (Exception e) {
                        System.out.println("Error with CheckingDB");
                    }
                }
            }
        });
    }
    public void initCancelBtn(){
        Button cancelButton = findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText();
            }
        });
    }
    public void deleteText(){
        EditText accountNumber = findViewById(R.id.etAccountNum);
        EditText initialBalance = findViewById(R.id.etInitialBalance);
        EditText currentBalance = findViewById(R.id.etCurrentBalance);
        EditText interestRate = findViewById(R.id.etInterestRate);
        EditText paymentAmount = findViewById(R.id.etPaymentAmount);

        accountNumber.setText("");
        initialBalance.setText("");
        currentBalance.setText("");
        interestRate.setText("");
        paymentAmount.setText("");
    }
}