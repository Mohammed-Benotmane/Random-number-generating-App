package com.example.mohammed_benotmane.pseudo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int puissance(int x, int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s *= x;
        }
        return s;
    }

    public int pseudo(int val, int m, int a, int c) {
        int x;
        int i = 1;
        //int a = 9;
        //int c = 11;
        int mP = 0;
        while (puissance(2, i) < m) {
            i++;
            mP = puissance(2, i);
        }

        x = (a * val + c) % mP;
        if (x < m) {
            return x;
        } else {
            return pseudo(x, m, a, c);
        }

    }

    int a, c, x0, m;
    TextView textView;
    Runnable run;
    String s;
    static int j;
    public void moh(View view) {
        textView = findViewById(R.id.textView);
        EditText editTextA = findViewById(R.id.a);
        EditText editTextC = findViewById(R.id.c);
        EditText editTextM = findViewById(R.id.m);
        EditText editTextX = findViewById(R.id.x);
        s = "";
        a = Integer.parseInt(editTextA.getText().toString());
        c = Integer.parseInt(editTextC.getText().toString());
        x0 = Integer.parseInt(editTextX.getText().toString());
        m = Integer.parseInt(editTextM.getText().toString());
        final Handler handler = new Handler();


        //for (int i = 0; i < m; i++) {
        run = new Runnable() {
            @Override
            public void run() {
                //s += String.valueOf(x0) + " ";
                if(j<=m) {
                    x0 = pseudo(x0, m, a, c);
                    textView.setText(String.valueOf(x0));
                    handler.postDelayed(this, 1000);
                    j++;
                }else{
                    handler.removeCallbacks(run);
                }
            }
        };
        handler.postDelayed(run,0);
        /*
            handler.postDelayed(new Runnable() {
                public void run() {
                    s += String.valueOf(x0) + " ";
                    x0 = pseudo(x0, m, a, c);
                    textView.setText(s);
                }
            }, 1000);
       //}*/
    }

}
