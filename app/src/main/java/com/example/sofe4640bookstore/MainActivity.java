package com.example.sofe4640bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    public void onClickActivity2(View view){
        Intent activity2Intent = new Intent(this,AddNewBook.class);
        activity2Intent.putExtra("msg1","Greetings from Activity 1");
        //activity2Intent.putExtra("msg2"," Another Greetings from Activity 1");
        // activity2Intent.putExtra("msg3",100);
        startActivity(activity2Intent);

    }


    public void signup(View view){

        Intent intent = new Intent(this,SignupUsers.class);
        startActivity(intent);

    }



}