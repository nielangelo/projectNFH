package com.example.safe_haven;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class login extends AppCompatActivity {

    EditText memail,mpassword;
    ImageView mGoogle, mfb;
    Button mloginBtn;
    TextView msignup;
    FirebaseAuth fAuth;
    FirebaseAuth mAuth;
    GoogleSignInOptions  gso;
    GoogleSignInClient gsc;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        memail   = findViewById(R.id.email);
        mpassword= findViewById(R.id.password);
        msignup= findViewById(R.id.signup);
        fAuth   = FirebaseAuth.getInstance();
        mloginBtn = findViewById(R.id.loginBtn);
        mGoogle = findViewById(R.id.Google);




        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    memail.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mpassword.setError("Password is required.");
                    return;
                }
                if (password.length()< 6){
                    mpassword.setError("Password must be > = 6 Characters");
                    return;
                }


                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(login.this, "Log in Successfully ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Mainactivity2.class));
                        }else{
                            Toast.makeText(login.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                });


            }


        });
        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });
        mGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });
    }
    void signin(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1000){
            Task<GoogleSignInAccount> Task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                Task.getResult(ApiException.class);
                navigatetoMainactivity2();
            } catch (ApiException e) {
               Toast.makeText(getApplicationContext(),"Sign in Cancelled by User",Toast.LENGTH_SHORT).show();
            }
        }
    }
    void navigatetoMainactivity2(){
        Intent intent= new Intent(login.this, Mainactivity2.class);
        Toast.makeText(getApplicationContext(),"Sign In Using Google",Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }
}