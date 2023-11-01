package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userID = (TextView) findViewById(R.id.userID);
        TextView businessID = (TextView) findViewById(R.id.businessID);
        TextView businessPassword = (TextView) findViewById(R.id.businessPassword);

        MaterialButton login = (MaterialButton) findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userID.getText().toString().equals("1") && businessID.getText().toString().equals("1111") && businessPassword.getText().toString().equals("11111111"))
                {
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"UserID, BusinessID or Business Password is incorrect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}