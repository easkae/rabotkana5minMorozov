package com.example.rabotkana5min;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Onboard_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard_one);

        LinearLayout LinLay = (LinearLayout) findViewById(R.id.main);
        TextView txtView = (TextView) findViewById(R.id.textView);


        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Onboard_one.this, Welcome.class);
                startActivity(intent);
            }
        });

        LinLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Onboard_one.this, Onboard_two.class);
                startActivity(intent);
            }
        });
    }
}