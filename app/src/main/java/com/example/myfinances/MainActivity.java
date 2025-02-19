package com.example.myfinances;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
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
    public void
}