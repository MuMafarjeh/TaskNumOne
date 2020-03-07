package com.example.tasknumone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText phoneNumber;
    public  static String MSG = "MSG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber=(EditText)findViewById(R.id.sendPhoneNumber);
    }

    public void btnOnclick(View view) {
        String message = phoneNumber.getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);

        intent.putExtra(MSG,message);
//        Log.d("hhhh", String.valueOf(message));
        startActivity(intent);

    }
}
