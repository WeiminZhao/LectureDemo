package com.example.sofe4640bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AddNewBook extends AppCompatActivity {

    Button btnParse = null;
    HttpURLConnection conn= null;
    TextView jsonView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);


        Intent recMsg = getIntent();
        String tempMsg = recMsg.getStringExtra("msg1");

        TextView txtview = (TextView) findViewById(R.id.lblMessage);
        txtview.setText(tempMsg);
        btnParse = (Button) findViewById(R.id.btnParse);
        jsonView = (TextView) findViewById(R.id.lblMessage);

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    URL url = new URL("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(5000); //5 sec.
                    conn.connect();
                    if (conn.getResponseCode()== HttpURLConnection.HTTP_OK){

                        InputStream stream = conn.getInputStream();
                        BufferedReader reader = new BufferedReader( new InputStreamReader(stream));
                        StringBuffer buffer = new StringBuffer();
                        String line= "";
                        while((line = reader.readLine()) != null){
                            buffer.append(line);
                        }

                        jsonView.setText(buffer.toString());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    conn.disconnect();
                }
            }
        });
    }



}