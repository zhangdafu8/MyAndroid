package com.example.qiaoxian.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2;
    private CheckBox checkBox1,checkBox2,checkBox3;
    private SeekBar seekBar;
    private Button button;
    private ImageView iv_pic;
    private ToggleButton toggleButton;
    private boolean isSpicy, isSeafood, isSour;
    private Person person;
    private MyRadioListener myRadioListener;
    private int price = 30;
    private MyCheckBox myCheckBox;
    private MySeekBarListener mySeekBarListener;
    private List<Food> list1,list2;
    private MyButtonListener myButtonListener;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        init();
        setBuild();
    }

    private void init() {
        editText=findViewById(R.id.et1);
        radioGroup = findViewById(R.id.rg1);
        radioButton1 = findViewById(R.id.rb1);
        radioButton2 = findViewById(R.id.rb2);
        checkBox1 = findViewById(R.id.cb1);
        checkBox2 = findViewById(R.id.cb2);
        checkBox3 = findViewById(R.id.cb3);
        seekBar = findViewById(R.id.sb1);
        button = findViewById(R.id.bt1);
        iv_pic = findViewById(R.id.iv1);
        toggleButton = findViewById(R.id.tb1);
        seekBar.setProgress(30);
    }

    private void setBuild() {
        person = new Person();
        myRadioListener = new MyRadioListener();
        radioGroup.setOnCheckedChangeListener(myRadioListener);
        myCheckBox = new MyCheckBox();
        checkBox1.setOnCheckedChangeListener(myCheckBox);
        checkBox2.setOnCheckedChangeListener(myCheckBox);
        checkBox3.setOnCheckedChangeListener(myCheckBox);
        mySeekBarListener = new MySeekBarListener();
        seekBar.setOnSeekBarChangeListener(mySeekBarListener);
        list1 = new ArrayList<Food>();
        list1.add(new Food("红烧鸡",55,R.drawable.chicken,true,false,false));
        list1.add(new Food("香辣蟹",75,R.drawable.crab,true,true,false));
        list1.add(new Food("椒盐鸡胗",65,R.drawable.gizzards,true,false,false));
        list1.add(new Food("海带",45,R.drawable.kelp,true,true,true));
        list1.add(new Food("奶茶",35,R.drawable.milktea,false,false,false));
        list2 = new ArrayList<Food>();
        myButtonListener = new MyButtonListener();
        button.setOnClickListener(myButtonListener);
        toggleButton.setOnClickListener(myButtonListener);

    }

    class MyRadioListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch(i){
                case R.id.rb1:
                    person.setSex("男");
                    Toast.makeText(MainActivity.this, "男士您好！欢迎点餐！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rb2:
                    person.setSex("女");
                    Toast.makeText(MainActivity.this, "女士您好！欢迎点餐！", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    class MyCheckBox implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            CheckBox checkBox4 = (CheckBox) compoundButton;

            switch(checkBox4.getId()){
                case R.id.cb1:
                    if(b){
                        isSpicy = true;
                    }else {
                        isSpicy = false;
                    }
                    break;
                case R.id.cb2:
                    if(b){
                        isSeafood = true;
                    }else{
                        isSeafood = false;
                    }
                    break;
                case R.id.cb3:
                    if(b){
                        isSour = true;
                    }else{
                        isSour = false;
                    }

            }
        }
    }

    class MySeekBarListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            price = seekBar.getProgress();
            Toast.makeText(MainActivity.this, "价格"+price, Toast.LENGTH_SHORT).show();

        }
    }

    class MyButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.bt1:
                    count = 0;
                    list2.clear();
                    toggleButton.setChecked(true);
                    for(int i = 0;i<list1.size();i++){
                        Food food = list1.get(i);
                        if((food.getPrice()<=price)&&(food.isSpicy()==isSpicy)&&(food.isSeafood()==isSeafood)&&(food.isSour()==isSour)){
                            list2.add(food);
                        }
                    }
                    if (list2.size()!=0) {
                        iv_pic.setImageResource(list2.get(count).getPicture());
                    }
                    else{
                        Toast.makeText(MainActivity.this, "未找到相关菜品！", Toast.LENGTH_SHORT).show();
                        iv_pic.setImageResource(R.drawable.wechat);
                    }

                    break;
                case R.id.tb1:

                        if(toggleButton.isChecked()){
                            if(count<list2.size()-1){
                                count++;
                            }
                            else{
                                count = 0;
                                Toast.makeText(MainActivity.this, "图片已显示完毕，显示初始图片", Toast.LENGTH_SHORT).show();
                            }
                            iv_pic.setImageResource(list2.get(count).getPicture());
                        }else{
                            person.setName(editText.getText().toString());
                            person.setFood(list2.get(count));
                            Toast.makeText(MainActivity.this, "信息："+person,Toast.LENGTH_LONG).show();
                        }


                    break;
            }
        }


    }




}
