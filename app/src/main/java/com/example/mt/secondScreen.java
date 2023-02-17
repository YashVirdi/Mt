package com.example.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class secondScreen extends AppCompatActivity {
    EditText stringEditText;
    TextView capTextView, vowelsTextView, consonantsTextView;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        stringEditText = findViewById(R.id.stringEditText);
        capTextView = findViewById(R.id.capTextView);
        vowelsTextView = findViewById(R.id.vowelsTextView);
        consonantsTextView = findViewById(R.id.consonantsTextView);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUsrData = stringEditText.getText().toString();
                if (inputUsrData.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nothing was entered. Please enter something", Toast.LENGTH_LONG).show();
                }else if (inputUsrData == null){
                    System.out.println("Enter valid String Value");
                    Toast.makeText(getApplicationContext(), "Enter valid String Value", Toast.LENGTH_LONG).show();
                }
                else{
                    getUpperCaseValues(inputUsrData);
                    getConsValues(inputUsrData);
                    getVowelsValues(inputUsrData);

                }


            }

            //For upper case
            private void getUpperCaseValues(String inputUsrData){
                capTextView.setText("");
                for (int x =0; x < inputUsrData.length(); x++){
                    if (Character.isUpperCase(inputUsrData.charAt(x))){
                        capTextView.append(inputUsrData.charAt(x)+ "");
                    }
                }
            }
            //For vowels

            private void getVowelsValues(String inputUsrData) {
                //setting it to nothing
                vowelsTextView.setText("");
                String usrdata = inputUsrData.toLowerCase();
                for (int x = 0; x < usrdata.length(); x++) {
                    if (usrdata.charAt(x) == 'a' || usrdata.charAt(x) == 'e' || usrdata.charAt(x) == 'o' || usrdata.charAt(x) == 'i' ||
                            usrdata.charAt(x) == 'u') {
                        vowelsTextView.append(usrdata.charAt(x)+",");
                    }
                }
            }

            private void getConsValues(String inputUsrData) {
                consonantsTextView.setText("");
                char[] consonants =inputUsrData.toCharArray();

                for(int x=0; x<inputUsrData.length(); x++){

                    //catces if the vowles are to upper or lower case and show consontants only
                    if (consonants[x]=='a' || consonants[x]=='e' || consonants[x]=='i' || consonants[x]=='o' || consonants[x]=='u' ||
                            consonants[x]=='A' || consonants[x]=='E' || consonants[x]=='I' || consonants[x]=='O' || consonants[x]=='U' ){
                        continue;
                    }
                    else{
                        consonantsTextView.append(" "+consonants[x]+",");
                    }
                }
            }

        });
    }

}