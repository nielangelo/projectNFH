/*package com.example.safe_haven;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class login2 extends login {
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        callbackManager = CallbackManager.Factory.create();
        mfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login2.this,Mainactivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });



            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            handleFacebookAccessToken(loginResult.getAccessToken());
                        }

                        @Override
                        public void onCancel() {
                            // App code
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            // App code
                        }
                    });
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Pass the activity result back to the Facebook SDK
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }

        private void handleFacebookAccessToken(AccessToken token) {


            AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(login2.this, ""+task.getException(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

        private void updateUI(FirebaseUser user) {
            Intent intent = new Intent(login2.this,Mainactivity2.class);
            startActivity(intent);
        }
    }*/