package com.example.mohammed_benotmane.pseudo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calcule extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_main,container,false);
        editTextA= root.findViewById(R.id.a);
        editTextC= root.findViewById(R.id.c);
        editTextX= root.findViewById(R.id.x);
        editTextM= root.findViewById(R.id.m);
        koulchi = root.findViewById(R.id.textView);
        textView = root.findViewById(R.id.textView2);

        Button button = root.findViewById(R.id.calcule);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moh1();
            }
        });
        return root;
    }
    public int puissance(int x, int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s *= x;
        }
        return s;
    }
//-----
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
    TextView koulchi;
    EditText editTextA;
    EditText editTextC;
    EditText editTextM;
    EditText editTextX;
    Runnable run;
    String s;
    static int j;

    public void moh1() {


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
                if (j < m) {
                    s += String.valueOf(x0) + " ";
                    x0 = pseudo(x0, m, a, c);
                    textView.setText(String.valueOf(x0));
                    handler.postDelayed(this, 1000);
                    j++;
                } else {
                    handler.removeCallbacks(run);
                }
            }
        };
        handler.postDelayed(run, 0);
        for (int i = 0; i < m; i++) {
            s += String.valueOf(x0) + " ";
            x0 = pseudo(x0, m, a, c);
        }
        koulchi.setText(s);

    }

    @Override
    public void onClick(View v) {

    }
}
