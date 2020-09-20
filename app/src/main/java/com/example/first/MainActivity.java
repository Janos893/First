package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int input=0;
    TextView valueText;
    EditText inputString;
    Switch isNumber;
    Switch uppercase;
    Switch lowercase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button passwordBtn = (Button) findViewById(R.id.newPassword);
        valueText = (TextView) findViewById(R.id.value);
        inputString = (EditText) findViewById(R.id.input);
        isNumber= (Switch) findViewById(R.id.isNumber);
        uppercase= (Switch) findViewById(R.id.uppercase);
        lowercase= (Switch) findViewById(R.id.lowrcase);

        passwordBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String string=inputString.getText().toString();

                try {
                    input = Integer.parseInt(string);
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
               valueText.setText(getAlphaNumericString(input, isNumber.isChecked(), uppercase.isChecked(), lowercase.isChecked()));
            }
        });

    }

    private static String getAlphaNumericString(int n, boolean isNumber, boolean uppercase, boolean lowercase) {
        String AlphaNumericString;
        if (isNumber==true && uppercase==true && lowercase==true) {
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";
        }
        else if (isNumber==true && uppercase==true && lowercase==false){
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789";
        }
        else if(isNumber==true && uppercase==false && lowercase==false){
            AlphaNumericString = "0123456789";
        }
        else if(isNumber==false && uppercase==true && lowercase==true){
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz";
        }
        else if(isNumber==true && uppercase==false && lowercase==true){
            AlphaNumericString = "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";
        }
        else if(isNumber==false && uppercase==true && lowercase==false){
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        else if(isNumber==false && uppercase==false && lowercase==true){
            AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        }
        else{
            return "Kevés paraméter!";
        }
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}