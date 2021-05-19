package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
android.widget.Button mcalculatebmi;
TextView mcurrentHeight;
TextView mcurrentage,mcurrentweight;
ImageView mincrementage,mincrementweight,mdecrementweight,mdecrementage;
SeekBar mseekbarheight;
RelativeLayout mmale,mfemale;

int mweight=55;
int mage=22;
int currentProgress;
String mintprogress="170";
String typeofuser="0";
String weight2="55";
String age2="22";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcurrentage=findViewById(R.id.currentAge);
        mcurrentweight=findViewById(R.id.currentWeight);
        mcurrentHeight=findViewById(R.id.currentHeight);
        mincrementage=findViewById(R.id.incrementAge);
        mdecrementage=findViewById(R.id.decrementAge);
        mincrementweight=findViewById(R.id.incrementWeight);
        mdecrementweight=findViewById(R.id.decrementWeight);

        mseekbarheight=findViewById(R.id.seekbarHeight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);


    //Calculate BMI Button//
        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(typeofuser.equals("0")){
                Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
            }
          else if(mintprogress.equals("0")){
                Toast.makeText(getApplicationContext(),"Select Your Height First",Toast.LENGTH_SHORT).show();
            }
          else if(mage==0 || mage<0){
              Toast.makeText(getApplicationContext(),"Select Your Age First",Toast.LENGTH_SHORT).show();
            }
          else if(mweight==0 || mweight<0){
              Toast.makeText(getApplicationContext(),"Select Your Weight First",Toast.LENGTH_SHORT).show();
            }
          else {
                Intent i =new Intent(MainActivity.this,bmiActivity.class);
               i.putExtra("gender",typeofuser);
               i.putExtra("height",mintprogress);
               i.putExtra("weight",weight2);
               i.putExtra("age",age2);
                startActivity(i);
            }
        }
    });

   //Choosing Gender//
    mmale.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
           mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
        typeofuser="Male";
        }
    });
    mfemale.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
           mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
        typeofuser="Female";
        }
    });

    //Height SeekBar//
    mseekbarheight.setMax(300);
    mseekbarheight.setProgress(170);
    mseekbarheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            currentProgress =progress;
            mintprogress=String.valueOf(currentProgress);
            mcurrentHeight.setText(mintprogress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });

    //Increasing & Decreasing Age//
    mincrementage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mage=mage+1;
            age2=String.valueOf(mage);
            mcurrentage.setText(age2);
        }
    });
    mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mage=mage-1;
                age2=String.valueOf(mage);
                mcurrentage.setText(age2);
            }
        });

  //Increasing & Decreasing Weight//
    mincrementweight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mweight=mweight+1;
            weight2=String.valueOf(mweight);
            mcurrentweight.setText(weight2);
        }
    });
    mdecrementweight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mweight=mweight-1;
            weight2=String.valueOf(mweight);
            mcurrentweight.setText(weight2);
        }
    });



    }
}