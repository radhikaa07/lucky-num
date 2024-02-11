package com.example.lucky_no_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class second extends AppCompatActivity {
    TextView  welcome, lucky;
    Button btn;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcome = findViewById(R.id.textView2);
        lucky= findViewById(R.id.textView3);
        btn = findViewById(R.id.button2);
        // receiving the data from main activity
        Intent i= getIntent();
        String userName= i.getStringExtra("name");

        //generating random numbers

        int random_num = generate();
        lucky.setText(" " + random_num);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(random_num,userName);
            }
        });






    }

    public int generate(){
        Random random = new Random();
        int upper= 1000;
        return random.nextInt(upper);

    }

    public void shareData(int random, String username){
          Intent i = new Intent(Intent.ACTION_SEND);
          i.setType("text/plain");

          i.putExtra(Intent.EXTRA_SUBJECT, username+"you got lucy today");
          i.putExtra(Intent.EXTRA_TEXT, "his lucky number is:" + random);

          startActivity(Intent.createChooser(i,"choose a platform"));
    }


}