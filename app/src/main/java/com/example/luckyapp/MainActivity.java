package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnsignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.edittextt);
        btnsignIn =findViewById(R.id.btnSignIn);

        btnsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_name= editText.getText().toString();

                //explicit intent (using for navigate to one activity to another activity)
                Intent intent =new Intent(getApplicationContext(),FirstActivity.class);


                //now passing the name to the second activity
                intent.putExtra("name" ,user_name);
                startActivity(intent);


            }
        });
    }
}