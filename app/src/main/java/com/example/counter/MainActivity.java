package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private long lastpause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Chronometer myChronometer = (Chronometer)findViewById(R.id.chronometer);
        Button buttonstart = (Button)findViewById(R.id.buttonstart);
        Button buttonstop =(Button)findViewById(R.id.buttonstop);
        Button buttonReset = (Button)findViewById(R.id.buttonReset);
        buttonstart.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(lastpause !=0)
                {
                    myChronometer.setBase(myChronometer.getBase() + SystemClock.elapsedRealtime()-lastpause);
                }
                myChronometer.start();
                buttonstart.setEnabled(false);
                buttonstop.setEnabled(true);
            }
        });
        buttonstop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                lastpause=SystemClock.elapsedRealtime();
                myChronometer.stop();
                buttonstop.setEnabled(false);
                buttonstart.setEnabled(true);
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myChronometer.setBase(SystemClock.elapsedRealtime());
            }
        });
    }
}