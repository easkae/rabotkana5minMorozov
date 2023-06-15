package com.example.rabotkana5min;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    private EditText editText;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        editText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        btn =  (Button) findViewById(R.id.button);


        editText.addTextChangedListener(editTextWather);
        btn.setEnabled(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Onboard_four.class);
                startActivity(intent);
            }
        });
    }
    private TextWatcher editTextWather = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String editTextInput = editText.getText().toString().trim();

            btn.setEnabled(editTextInput.contains("@"));
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}