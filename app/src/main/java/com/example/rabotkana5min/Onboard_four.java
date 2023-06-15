package com.example.rabotkana5min;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Onboard_four extends AppCompatActivity {
    public Button btn2;
    public EditText editText1;
    public EditText editText2;
    public EditText editText3;
    public EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        //инициализируем
        btn2 = (Button) findViewById(R.id.button5);
        editText1 = (EditText) findViewById(R.id.editTextNumber1);
        editText2 = (EditText) findViewById(R.id.editTextNumber2);
        editText3 = (EditText) findViewById(R.id.editTextNumber3);
        editText4 = (EditText) findViewById(R.id.editTextNumber4);

        ImageButton btn = (ImageButton) findViewById(R.id.imageButton);
        TextView text = (TextView) findViewById(R.id.textView12);
        //записываем листенер с методом
        editText1.addTextChangedListener(editTextWather);
        editText2.addTextChangedListener(editTextWather);
        editText3.addTextChangedListener(editTextWather);
        editText4.addTextChangedListener(editTextWather);

        //кнопка не робит пока
        btn2.setEnabled(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Onboard_four.this, Welcome.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Onboard_four.this, Onboard_five.class);
                startActivity(intent);
            }
        });


        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                text.setText("Отправить код повторно можно \n будет через" + " " + l/1000 + "  " +  "сек.");

            }

            @Override
            public void onFinish() {
                text.setText("Код отправлен повторно");

            }

        }.start();


    }
    //метода которая запускает кнопку при условии заполнения всех 4 полей
    public TextWatcher editTextWather = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String editTextInput1 = editText1.getText().toString().trim();
            String editTextInput2 = editText2.getText().toString().trim();
            String editTextInput3 = editText3.getText().toString().trim();
            String editTextInput4 = editText4.getText().toString().trim();



            btn2.setEnabled(!editTextInput1.isEmpty() && !editTextInput2.isEmpty() && !editTextInput3.isEmpty() && !editTextInput4.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}


