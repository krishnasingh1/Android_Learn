package com.example.androidlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentTimeUpdate extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextTime);

        Thread t1 = new Thread(){

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calendar= Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                                String currenttime = simpleDateFormat.format(calendar.getTime());
                                textView.setText(currenttime);
                            }
                        });
                    }
                }
                catch (Exception e) {

                    textView.setText(R.string.app_name);

                }
            }
        };
        t1.start();
    }
}