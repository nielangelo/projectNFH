package com.example.safe_haven;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Mainactivity2 extends AppCompatActivity {

    GoogleSignInOptions  gso;
    GoogleSignInClient gsc;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity2);
        logout = findViewById(R.id.logout);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc =GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct= GoogleSignIn.getLastSignedInAccount(this);


        ImageView caskets = findViewById(R.id.caskets);
        caskets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mainactivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mainactivity2.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        ImageView nissan = findViewById(R.id.nissan);
        nissan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Mainactivity2.this, rentals.class);
                startActivity(intent);
            }
        });
        ImageView contact = findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mainactivity2.this, contacts.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    public void gotoscroll(View view) {
        startActivity(new Intent(Mainactivity2.this, Slideshow.class));
    }
    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(Mainactivity2.this, login.class));

            }
        });
    }

}