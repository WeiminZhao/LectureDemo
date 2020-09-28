package com.example.sofe4640bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddNewBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);


        Intent recMsg = getIntent();
        String tempMsg = recMsg.getStringExtra("msg1");

        TextView txtview = (TextView) findViewById(R.id.lblMessage);
        txtview.setText(tempMsg);

    }
}