package com.example.administrator.customview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.paitextview.PaiTextView;

public class MainActivity extends AppCompatActivity implements PaiTextView.onClickListener {
private PaiTextView paiTextView,paiTextView1,paiTextView2,paiTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        paiTextView.setRadius(90, 90, 90, 90)
                .setFillColor(Color.GREEN)
                .setOnClickListener(this)
                .init();
        paiTextView1.setRadius(90, 90, 90, 90)
                .setFillColor(Color.GREEN)
                .setStrokeWidth(3)
                .setStrokeColor(Color.BLACK)
                .setOnClickListener(this)
                .init();
        paiTextView2.setRadius(90, 90, 90, 90)
                .setFillColor(Color.GREEN)
                .setStrokeWidth(3)
                .setStrokeColor(Color.BLACK)
                .setOnClickListener(this)
                .setAre(true)
                .init();
        paiTextView3.setRadius(70, 0, 70, 0)
                .setFillColor(Color.GREEN)
                .setStrokeWidth(3)
                .setStrokeColor(Color.BLACK)
                .setOnClickListener(this)
                .init();
    }

    private void initView() {
        paiTextView=findViewById(R.id.paiTextview);
        paiTextView1=findViewById(R.id.paiTextview1);
        paiTextView2=findViewById(R.id.paiTextview2);
        paiTextView3=findViewById(R.id.paiTextview3);
    }

    @Override
    public void onClick(View v) {

    }
}
