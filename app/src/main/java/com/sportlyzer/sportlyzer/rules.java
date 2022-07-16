package com.sportlyzer.sportlyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class rules extends AppCompatActivity implements View.OnClickListener {
    Button traingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        traingBtn = findViewById(R.id.training_btn);
        traingBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(traingBtn)){
            startActivity(new Intent(getBaseContext(),volleyvedios.class));

        }
    }
}