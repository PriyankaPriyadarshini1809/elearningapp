package com.example.android.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    EditText email,password;
    Button login,register;
    private FirebaseAuth firebaseAuth;
    boolean isPasswordValid,isEmailValid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        email=(EditText) findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.loginActivity);
        register=(Button)findViewById(R.id.registerActivity);


        firebaseAuth=FirebaseAuth.getInstance();

        FirebaseUser user=firebaseAuth.getCurrentUser();

        if(user!=null){
            finish();
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetValidation(email.getText().toString(),password.getText().toString());
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void SetValidation(String userName,String userPassword){

        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    //Toast.makeText(HomeActivity.this,"the login was successfull",Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                }
                else{
                    Toast.makeText(HomeActivity.this,"the login wasn't successfull",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private void checkEmailVerification(){
        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag=firebaseUser.isEmailVerified();

        if(emailflag){
            finish();
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        }
        else{
            Toast.makeText(this,"verify ur email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
