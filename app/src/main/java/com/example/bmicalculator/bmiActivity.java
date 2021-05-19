package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiActivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;
   TextView mbmidisplay,mbmicategory,mgender;
   Intent i;
   ImageView mimageview;
   String mbmi;
   float intbmi;
   String height;
   String weight;
   float intheight,intweight;
   RelativeLayout  mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

    mrecalculatebmi=findViewById(R.id.recalculatebmi);
    mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(bmiActivity.this,MainActivity.class);
        startActivity(i);
        }
    });

    i=getIntent();
    mbmidisplay=findViewById(R.id.bmiDisplay);
    mbmicategory=findViewById(R.id.bmicategory);
    mgender=findViewById(R.id.genderDisplay);
    mbackground=findViewById(R.id.contentLayout);
    mimageview=findViewById(R.id.imageview);
    mrecalculatebmi=findViewById(R.id.recalculatebmi);

    height=i.getStringExtra("height");
    weight=i.getStringExtra("weight");

    intheight=Float.parseFloat(height);
    intweight=Float.parseFloat(weight);

    intheight=intheight/100;
    intbmi=intweight/(intheight*intheight);

    mbmi=Float.toString(intbmi);

  //BMI Condition//
    if(intbmi<18.5){
        mbmicategory.setText("UnderWeight");
        mbackground.setBackgroundColor(Color.RED);
        mimageview.setImageResource(R.drawable.crosss);
    }
    else if(intbmi >18.5 && intbmi<24.9){
        mbmicategory.setText("Normal Weight");
        mbackground.setBackgroundColor(Color.GREEN);
        mimageview.setImageResource(R.drawable.ok);
    }
    else if(intbmi >25 && intbmi <29.9){
        mbmicategory.setText("Obese");
        mbmidisplay.setTextColor(Color.BLACK);
        mgender.setTextColor(Color.BLACK);
        mbmicategory.setTextColor(Color.BLACK);
        mbackground.setBackgroundColor(Color.YELLOW);
        mimageview.setImageResource(R.drawable.warning);
    }
else{
        mbmicategory.setText("Severe Obese");
        mbackground.setBackgroundColor(Color.RED);
        mimageview.setImageResource(R.drawable.crosss);
    }

mgender.setText(i.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);

    }
}