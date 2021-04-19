package com.example.android.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class LoginActivity extends AppCompatActivity {

    Button b10;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button cat;
    Button gre;
    Button clat;
    Button ntse;
    Button neet;
    Button jm;
    Button ja;
    Button gate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1=findViewById(R.id.class1);
        b2=findViewById(R.id.class2);
        b3=findViewById(R.id.class3);
        b4=findViewById(R.id.class4);
        b5=findViewById(R.id.class5);
        b6=findViewById(R.id.class6);
        b7=findViewById(R.id.class7);
        b8=findViewById(R.id.class8);
        b9=findViewById(R.id.class9);
        b10=findViewById(R.id.class10);

        gate=findViewById(R.id.gate);
        gre=findViewById(R.id.gre);
        clat=findViewById(R.id.clat);
        ntse=findViewById(R.id.ntse);
        neet=findViewById(R.id.neet);
        ja=findViewById(R.id.ja);
        jm=findViewById(R.id.jm);
        cat=findViewById(R.id.cat);



        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/ArvindAcademy");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/instyneducation");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/instyneducation");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/instyneducation");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/instyneducation");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/instyneducation");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/instyneducation");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/NCERTTUTORIAL2");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/NCERTTUTORIAL2");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/MKrClasses");
            }
        });

        gate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/channel/UCwh_qd5g7I88OVr8FM1PnjQ");
            }
        });
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/UnacademyCAT");
            }
        });
        clat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/UnacademyLaw");
            }
        });
        gre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/GREedgeOfficial");
            }
        });
        ja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/EtoosEducation");
            }
        });
        jm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/EtoosEducation");
            }
        });
        ntse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/ArvindAcademy");
            }
        });
        neet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/channel/UCp1T3Oi6gaNy7cngeEfQ09g");
            }
        });




    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


}



