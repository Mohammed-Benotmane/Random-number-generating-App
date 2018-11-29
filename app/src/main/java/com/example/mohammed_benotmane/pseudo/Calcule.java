package com.example.mohammed_benotmane.pseudo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Calcule extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_main,container,false);
        return root;
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
    TextView koulchi;
    Runnable run;
    String s;
    static int j;

    public void moh(View view) {
        koulchi = view.findViewById(R.id.textView);
        EditText editTextA = view.findViewById(R.id.a);
        textView = view.findViewById(R.id.textView2);
        EditText editTextC = view.findViewById(R.id.c);
        EditText editTextM = view.findViewById(R.id.m);
        EditText editTextX = view.findViewById(R.id.x);
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
}
