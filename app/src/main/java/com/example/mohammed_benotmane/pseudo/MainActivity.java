package com.example.mohammed_benotmane.pseudo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public int puissance(int x, int n){
        int s=1;
        for (int i=1;i<=n;i++){
            s*=x;
        }
        return s;
    }
    public int pseudo(int val,int m){
        int x ;
        int i = 1;
        int a = 9;
        int c = 11;
        int mP = 0;
        while(puissance(2,i)<m){
            i++;
            mP =puissance(2,i);
        }

        x=(a * val + c)% mP;
        if(x<m){
            return x;
        }else{
            return pseudo(x,m);
        }

    }
    public void moh(View view){
        TextView textView = findViewById(R.id.textView);
        String s = "";
        int x0 = 2;
        int m = 100;

            for (int i = 0; i < m; i++) {
                s += String.valueOf(x0) + " ";
                x0 = pseudo(x0, m);

            }
            textView.setText(s);
        }

}
