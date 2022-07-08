package com.example.safe_haven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText mfullname, memail, mpassword, mphone,mfirstname, mmiddlename;
    Button mloginBtn;
    TextView msign;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mfullname = findViewById(R.id.fullname);
        mfirstname= findViewById(R.id.firstname);
        mmiddlename= findViewById(R.id.middlename);
        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mphone = findViewById(R.id.phone);
        mloginBtn = findViewById(R.id.loginBtn);
        fAuth = FirebaseAuth.getInstance();
        msign = findViewById(R.id.sign);

        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                String fullname = mfullname.getText().toString().trim();
                String firstname = mfirstname.getText().toString().trim();
                String middlename = mmiddlename.getText().toString().trim();
                String phone = mphone.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    memail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpassword.setError("Password is required");
                    return;
                }
                if (TextUtils.isEmpty(fullname)) {
                    mfullname.setError("Full Name is required");
                    return;
                }
                if (TextUtils.isEmpty(firstname)) {
                    mfirstname.setError("First Name is required");
                    return;
                }
                if (TextUtils.isEmpty(middlename)) {
                    mmiddlename.setError("Middle Name is required");
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    mphone.setError("Phone Number is required");
                    return;
                }
                if (password.length() < 6) {
                    mpassword.setError("Password is must be >=6 Characters");
                }

                fAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    User user = new User(fullname, email, phone,password,firstname,middlename);

                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {
                                                Toast.makeText(register.this, "User Created", Toast.LENGTH_SHORT).show();
                                                Intent i = new Intent(getApplicationContext(), login.class);
                                                startActivity(i);
                                            } else {
                                                Toast.makeText(register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                } else {
                                    Toast.makeText(register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        msign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });







            }
}