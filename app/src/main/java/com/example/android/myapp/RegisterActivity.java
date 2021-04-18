package com.example.android.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText uname, uemail, uphone, upassword;
    Button uregister;
    TextView ulogin;
    private FirebaseAuth firebaseAuth;
    String user_name,user_phone,user_email,user_password;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        uname = (EditText) findViewById(R.id.name);
        uemail = (EditText) findViewById(R.id.email);
        uphone = (EditText) findViewById(R.id.phone);
        upassword = (EditText) findViewById(R.id.password);
        uregister = (Button) findViewById(R.id.register);
        ulogin = (TextView) findViewById(R.id.login);

        firebaseAuth=FirebaseAuth.getInstance();

        uregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
                //upload this in database,okay
                String user_email=uemail.getText().toString().trim();
                String user_password=upassword.getText().toString().trim();
                String user_name=uname.getText().toString().trim();
                String user_phone=uphone.getText().toString().trim();


                firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() ){
                           sendEmailVerification();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this,"Registration unsuccessfull",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        ulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SetValidation() {

        // Check for a valid name.


        if (uname.getText().toString().isEmpty()) {
            isNameValid = false;
        } else  {
            isNameValid = true;
        }

        // Check for a valid email address.
        if (uemail.getText().toString().isEmpty()) {

            isEmailValid = false;
        }
         else  {
            isEmailValid = true;
        }

        // Check for a valid phone number.
        if (uphone.getText().toString().isEmpty()) {

            isPhoneValid = false;
        } else  {
            isPhoneValid = true;
        }

        // Check for a valid password.
        if (upassword.getText().toString().isEmpty()) {

            isPasswordValid = false;
        }  else  {
            isPasswordValid = true;
        }

        if (isNameValid==false || isEmailValid==false || isPhoneValid==false || isPasswordValid==false) {
            Toast.makeText(getApplicationContext(), "please enter the details carefully.", Toast.LENGTH_SHORT).show();
        }

    }
    private void sendEmailVerification(){
        FirebaseUser fireBaseUser=firebaseAuth.getCurrentUser();
        if(fireBaseUser!=null){
            fireBaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        sendUserData();
                        Toast.makeText(RegisterActivity.this,"successfully registered,Verfication mail has been sent.",Toast.LENGTH_LONG).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"no mail has been sent.",Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
    private void sendUserData(){
        String user_email=uemail.getText().toString().trim();
        String user_password=upassword.getText().toString().trim();
        String user_name=uname.getText().toString().trim();
        String user_phone=uphone.getText().toString().trim();
        firebaseDatabase=FirebaseDatabase.getInstance();

        myRef=firebaseDatabase.getReference("Users");
        String emailiser=Encoder.encodeUserEmail(uemail.getText().toString());

        UserProfile userProfile=new UserProfile(user_email,user_phone,user_name);
        myRef.child(emailiser).setValue(userProfile);
    }

}
