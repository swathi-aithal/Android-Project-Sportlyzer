package com.sportlyzer.sportlyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText Username, Password;
    Button loginbtn;
    TextView registerText;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username=findViewById(R.id.loginEmail);
        Password=findViewById(R.id.loginPass);
            auth = FirebaseAuth.getInstance();
            if(auth.getCurrentUser()!= null){
                startActivity(new Intent(getBaseContext(), images.class));
                finish();
            }
        loginbtn=(Button)findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Username.getText().toString();
                String pass = Password.getText().toString();
auth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()) {
            Toast.makeText(getApplicationContext(), "login successfull", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getBaseContext(), images.class));
        } else {
            Toast.makeText(getApplicationContext(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
        }
    }
});

            }
        });

        registerText = findViewById(R.id.registertxtview);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

    }
}