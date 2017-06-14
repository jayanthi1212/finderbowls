package com.ench.jaya.example1212;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
String sname22,sname33;
    TextView ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView ed1 = (TextView) findViewById(R.id.textView2);
        sname22=getIntent().getStringExtra("use");
        ed1.setText(sname22);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView ed2 = (TextView) findViewById(R.id.textView3);
        sname33=getIntent().getStringExtra("use");
        ed1.setText(sname33);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
