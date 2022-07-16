package com.sportlyzer.sportlyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class cricket_rules extends AppCompatActivity implements View.OnClickListener {
    Button trainigBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket_rules);
        trainigBtn = findViewById(R.id.training_btn2);

        trainigBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(trainigBtn)) {
            startActivity(new Intent(getBaseContext(),cricketvedios.class));
        }
    }
}