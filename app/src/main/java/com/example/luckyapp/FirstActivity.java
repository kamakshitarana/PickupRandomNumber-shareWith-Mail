package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FirstActivity extends AppCompatActivity {
    TextView textView ;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textView =findViewById(R.id.textNumber);
        button =findViewById(R.id.btnShareMyNumber);

        //now we are in second activity and get the data from the first activity
        //username
        Intent intent =getIntent();
        String userName = intent.getStringExtra("name");
        Toast.makeText(this, "username"+userName, Toast.LENGTH_SHORT).show();

        //random number generater
        int random_Num =generateRandomNumber();
        textView.setText(""+random_Num);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                generateRandomNumber();
                shareData(userName,random_Num);

            }git
        });
    }

    private void shareData(String username,int randomNum) {
        //now here we used implicit intent
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //convert the int to string
        String number =String.valueOf(randomNum);

        intent.putExtra(Intent.EXTRA_SUBJECT,username + "got lucky toady!");
        intent.putExtra(Intent.EXTRA_TEXT,"His lucky number is: "+ number);

        startActivity(Intent.createChooser(intent,"choose a platform"));

    }

    private int generateRandomNumber() {

        Random random =new Random();
        int upper_limit =1000;
        int randomNumberGenerater = random.nextInt(upper_limit);
        return  randomNumberGenerater;
    }
}