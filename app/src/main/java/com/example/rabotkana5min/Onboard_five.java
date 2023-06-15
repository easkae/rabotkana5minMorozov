package com.example.rabotkana5min;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Onboard_five extends AppCompatActivity {
    public EditText editText;
    public Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        editText = (EditText) findViewById(R.id.editTextTextPassword2);
        TextView textView = (TextView) findViewById(R.id.textView9);
        Button buttonSave = (Button) findViewById(R.id.buttonSave);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Onboard_five.this, Onboard_six.class);
                startActivity(intent);
            }
        });


    }

    public void write(View view) {
        String str = editText.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("test.txt", MODE_PRIVATE);
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            editText.setText("");
            Toast.makeText(Onboard_five.this, "Пароль сохранен", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void onNumberClick(View view) {
        Button button = (Button) view;
        editText.append(button.getText());
    };
    public void clear(View view) {
        editText.setText("");
    };

}