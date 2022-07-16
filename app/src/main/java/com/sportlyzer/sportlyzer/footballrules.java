package com.sportlyzer.sportlyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class footballrules extends AppCompatActivity implements View.OnClickListener {
    Button trainingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footballrules);

        trainingBtn = findViewById(R.id.footBallTrainingBtn);
        trainingBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(trainingBtn)) {
            startActivity(new Intent(getBaseContext(),footballvedios.class));
        }
    }
}