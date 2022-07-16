package com.sportlyzer.sportlyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class images extends AppCompatActivity implements View.OnClickListener {
    Button vollbtn, cricbtn, foobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        vollbtn = findViewById(R.id.volbtn);
        cricbtn = findViewById(R.id.cribtn);
        foobtn = findViewById(R.id.footbtn);

        vollbtn.setOnClickListener(this);
        cricbtn.setOnClickListener(this);
        foobtn.setOnClickListener(this);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.logout : FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(getBaseContext(), home.class));
                                return true;
            default: super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(vollbtn)){
            startActivity(new Intent(getApplicationContext(), rules.class));
        } else if(v.equals(cricbtn)){
            startActivity(new Intent(getApplicationContext(), cricket_rules.class));
        } else if(v.equals(foobtn)){
            startActivity(new Intent(getApplicationContext(), footballrules.class));
        }
    }
}