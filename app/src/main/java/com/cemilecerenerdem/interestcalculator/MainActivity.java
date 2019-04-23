package com.cemilecerenerdem.interestcalculator;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText totalMoney;
    EditText interestRate;
    EditText numberOfRate;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalMoney = (EditText) findViewById(R.id.totalMoney);
        interestRate = (EditText) findViewById(R.id.interestRate);
        numberOfRate = (EditText) findViewById(R.id.numberOfDate);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupID);

    }

    public void Calculate(View view)
    {
        int resultCalculate = 0;
        int selectedTime = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedTime);
        String value = radioButton.getText().toString();

        switch (value){
            case "Daily":
                //Günlük Faiz = (Anapara / 100) x (faiz oranı / 365) x gün sayısı
                break;
            case "Mountly":
                //Aylık Faiz = (anapara / 100) x (faiz oranı / 12) x ay sayısı
                break;
            case "Yearly":
                //Yıllık Faiz = (anapara / 100) x (faiz oranı) x yıl sayısı
                break;
        }

    }
}
