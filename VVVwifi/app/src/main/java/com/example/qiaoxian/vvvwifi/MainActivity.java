package com.example.qiaoxian.vvvwifi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2,radioButton3;
    private ImageView imageView;
    private TextView textView2;
    private ToggleButton toggleButton;
    private int year, month, day, hour, minute,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        radioGroup = findViewById(R.id.rg1);
        radioButton1 = findViewById(R.id.rb1);
        radioButton2 = findViewById(R.id.rb2);
        radioButton3 = findViewById(R.id.rb3);
        imageView = findViewById(R.id.iv1);
        textView2 = findViewById(R.id.tv2);
        toggleButton = findViewById(R.id.tb1);
        MyToggleButtonListener myToggleButtonListener = new MyToggleButtonListener();
        toggleButton.setOnClickListener(myToggleButtonListener);
        RadioButtonListener radioButtonListener = new RadioButtonListener();
        radioGroup.setOnCheckedChangeListener(radioButtonListener);
    }

    public void time() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        day = calendar.get(calendar.DAY_OF_MONTH);
        hour = calendar.get(calendar.HOUR);
        minute = calendar.get(calendar.MINUTE);
        second = calendar.get(calendar.SECOND);
        String str = "当前时间："+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        textView2.setText(str);
    }

    class RadioButtonListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch(i){
                case R.id.rb1:
                    imageView.setImageResource(R.drawable.office);
                    time();
                    break;
                case R.id.rb2:
                    imageView.setImageResource(R.drawable.meeting);
                    time();
                    break;
                case R.id.rb3:
                    imageView.setImageResource(R.drawable.visitor);
                    time();
                    break;
            }
          
        }
    }

    class MyToggleButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(toggleButton.isChecked()){
                radioGroup.setVisibility(view.VISIBLE);
                imageView.setVisibility(view.VISIBLE);
                textView2.setVisibility(view.VISIBLE);

                }else{
                radioGroup.setVisibility(view.GONE);
                imageView.setVisibility(view.GONE);
                textView2.setVisibility(view.GONE);
            }
        }
    }
}
