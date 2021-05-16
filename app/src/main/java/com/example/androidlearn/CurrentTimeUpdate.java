package com.example.androidlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentTimeUpdate extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  ---->  Thread Time Continuesly Working Start code    <----
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
        //       ======================================================
        //  ---->  Thread Time Continuesly Working END code    <----
        //       ======================================================

    }
     //       ======================================================
    //            ---->    Theme Button Code Start    <----
    //        ======================================================

    public void Light(View view) {
    }

    public void Dark(View view) {
    }

    public void Custom(View view) {
    }
}