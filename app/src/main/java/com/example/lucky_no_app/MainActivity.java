package com.example.lucky_no_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText editText;
        Button btn;
        TextView text;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text= findViewById(R.id.textView);
        editText= findViewById(R.id.editText);
        btn= findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                Intent i= new Intent(
                        getApplicationContext(),
                        second.class
                );

                i.putExtra("name", name);

                startActivity(i);
            }
        });


    }
}