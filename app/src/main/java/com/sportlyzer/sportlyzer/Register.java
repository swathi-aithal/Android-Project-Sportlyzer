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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText email,password;
    Button registerBtn;
    TextView loginText;
    String regex="^(?=.*[0-9])"
            +"(?=.*[a-z])(?=.*[A-Z])"
            +"(?=.*[@#$%&])"
            +"(?=\\S+$).{8,20}$";
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.registerEmail);
        password=findViewById(R.id.registerPass);
        registerBtn=findViewById(R.id.registerBtn);
        auth = FirebaseAuth.getInstance();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String pwd = password.getText().toString();
                if (ValidatePassword(pwd)) {
                    auth.createUserWithEmailAndPassword(Email,pwd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(getApplicationContext(), "User Created Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getBaseContext(), Login.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(Register.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginText = findViewById(R.id.logintxtview);

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }
    public boolean ValidatePassword(String pwd)
    {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(pwd);
        return matcher.matches();
    }


}