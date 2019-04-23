package com.cemilecerenerdem.interestcalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText totalMoney;
    EditText interestRate;
    EditText dailyvalue;
    EditText mountlyvalue;
    EditText yearlyvalue;
    RadioGroup radioGroup;
    RadioButton radioButton;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalMoney = (EditText) findViewById(R.id.totalMoney);
        interestRate = (EditText) findViewById(R.id.interestRate);
        mountlyvalue = (EditText) findViewById(R.id.monthly_value);
        yearlyvalue = (EditText) findViewById(R.id.yearly_value);
        dailyvalue = (EditText) findViewById(R.id.daily_value);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupID);

    }

    public void Calculate(View view) {
        double resultCalculate = 0;
        int selectedTime = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedTime);
        String value = radioButton.getText().toString();

        if (value != null){

            int i_totalMoney = Integer.parseInt(totalMoney.getText().toString());
            double i_interestRate = Double.parseDouble(interestRate.getText().toString());

            switch (value) {
                case "Daily":
                    int i_dailyvalue = Integer.parseInt(dailyvalue.getText().toString());
                    resultCalculate = (i_totalMoney / 100) * (i_interestRate / 365) * i_dailyvalue;
                    break;

                case "Monthly":
                    int i_montlyvalue = Integer.parseInt(mountlyvalue.getText().toString());
                    resultCalculate = (i_totalMoney / 100) * (i_interestRate / 12) * i_montlyvalue;
                    break;

                case "Yearly":
                    int i_yearlyvalue = Integer.parseInt(yearlyvalue.getText().toString());
                    resultCalculate = (i_totalMoney / 100) * (i_interestRate / 10) * i_yearlyvalue;
                    break;
            }
        }

        if (resultCalculate > 0.0) {

            String resultValue = String.valueOf(resultCalculate);

            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_result);
            dialog.setTitle("Calculator Message");

            TextView info = (TextView) dialog.findViewById(R.id.txt_view);
            info.setText(resultValue.toString());
            dialog.show();

        } else {
            Toast.makeText(this, "Error!", Toast.LENGTH_LONG);
        }
    }
}
