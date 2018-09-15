package com.example.qiaoxian.borrowbook;

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
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText1,editText2;
    private RadioGroup radioGroup1;
    private RadioButton radioButton1,radioButton2;
    private CheckBox checkBox1,checkBox2,checkBox3;
    private SeekBar seekBar;
    private ImageView imageView;
    private Button button1, button2;
    private TextView textView1,textView2,textView3,textView4;
    private Person person;
    private MyRaioListener myRaioListener;
    private boolean isHistory,isSuspense,isArt;
    private MyCheckBox myCheckBox;
    private int humanAge;
    private MySeekBarListener mySeekBarListener;
    private List<Book> list1,list2;
    private int count;
    private MyButtonListener myButtonListener;
    private String time1,time2;
    private Date dateBorrow,dateReturn;
    private SimpleDateFormat sdf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow);
        myInitView();
        myInitData();
    }

    private void myInitView() {
        editText1 = (EditText) findViewById(R.id.et1);
        radioGroup1 = (RadioGroup) findViewById(R.id.rg1);
        radioButton1 = (RadioButton) findViewById(R.id.rb1);
        radioButton2 = (RadioButton) findViewById(R.id.rb2);
        editText2 = (EditText) findViewById(R.id.et2);
        checkBox1 = (CheckBox) findViewById(R.id.cb1);
        checkBox2 = (CheckBox) findViewById(R.id.cb2);
        checkBox3 = (CheckBox) findViewById(R.id.cb3);
        seekBar = (SeekBar) findViewById(R.id.sb1);
        imageView = (ImageView) findViewById(R.id.iv1);
        button1 = (Button) findViewById(R.id.bt1);
        button2 = (Button) findViewById(R.id.bt2);
        textView1 = (TextView) findViewById(R.id.tv1);
        textView2 = (TextView) findViewById(R.id.tv2);
        textView3 = (TextView) findViewById(R.id.tv3);
        textView4 = (TextView) findViewById(R.id.tv4);

    }

    private void myInitData() {
        list1 = new ArrayList<Book>();
        list2 = new ArrayList<Book>();
        list1.add(new Book("人生感悟",R.drawable.aa,100,true,false,false,"心灵鸡汤"));
        list1.add(new Book("边城",R.drawable.bb,50,false,false,true,"沈从文著作"));
        list1.add(new Book("Sapir",R.drawable.cc,30,false,false,false,"计算机"));
        list1.add(new Book("光辉岁月",R.drawable.dd,60,true,false,false,"历史"));
        list1.add(new Book("宋词三百首",R.drawable.ee,70,true,false,true,"诗词"));
        list1.add(new Book("中国古代文学",R.drawable.ff,80,true,false,true,"文学著作"));
        list1.add(new Book("无花果",R.drawable.gg,20,false,false,true,"诗文集"));
        list1.add(new Book("古镇记忆",R.drawable.hh,40,false,true,false,"探索古镇"));
        person = new Person();
        myRaioListener = new MyRaioListener();
        radioGroup1.setOnCheckedChangeListener(myRaioListener);
        myCheckBox = new MyCheckBox();
        checkBox1.setOnCheckedChangeListener(myCheckBox);
        checkBox2.setOnCheckedChangeListener(myCheckBox);
        checkBox3.setOnCheckedChangeListener(myCheckBox);
        mySeekBarListener = new MySeekBarListener();
        seekBar.setOnSeekBarChangeListener(mySeekBarListener);
        myButtonListener = new MyButtonListener();
        button1.setOnClickListener(myButtonListener);
        button2.setOnClickListener(myButtonListener);


    }

    class MyRaioListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.rb1:
                    person.setSex("男");
                    break;
                case R.id.rb2:
                    person.setSex("女");
                    break;
            }
        }
    }

    class MyCheckBox implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            CheckBox checkBox4 = (CheckBox)compoundButton;
            switch(checkBox4.getId()){
                case R.id.cb1:
                    if(b){
                        isHistory =true;
                    }else{
                        isHistory=false;
                    }
                    break;
                case R.id.cb2:
                    if(b){
                        isSuspense =true;
                    }else{
                        isSuspense=false;
                    }
                    break;
                case R.id.cb3:
                    if(b){
                        isArt =true;
                    }else{
                        isArt=false;
                    }
                    break;
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
            humanAge = seekBar.getProgress();
            Toast.makeText(MainActivity.this,"读者年纪："+humanAge,Toast.LENGTH_SHORT).show();
        }
    }

    class MyButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.bt1:
                    time1 = editText2.getText().toString();
                    time2 = "2016-06-30";
                    dateBorrow = new Date();
                    dateReturn = new Date();
                    sdf=new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        dateBorrow = sdf.parse(time1);
                        dateReturn = sdf.parse(time2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(dateBorrow.after(dateReturn)){
                        Toast.makeText(MainActivity.this,"借书时间晚于还书时间！",Toast.LENGTH_LONG).show();

                        finish();

                    } else {

                        count = 0;
                        list2.clear();
                        textView1.setVisibility(View.GONE);
                        for (int i = 0; i < list1.size(); i++) {
                            Book book1 = list1.get(i);
                            if ((book1.getReadAge() <= humanAge) && (book1.isHistory() == isHistory) && (book1.isSuspense() == isSuspense) && (book1.isArt() == isArt)) {
                                list2.add(book1);
                            }
                        }

                        if (list2.size() == 0) {
                            Toast.makeText(MainActivity.this, "没有符合要求的书籍", Toast.LENGTH_SHORT).show();
                            textView1.setText("符合条件的书0本");
                            textView1.setVisibility(View.VISIBLE);
                            imageView.setImageResource(R.drawable.f);
                        } else {
                            imageView.setImageResource(list2.get(count).getPic());
                            person.setAge(humanAge);
                            person.setPer_name(editText1.getText().toString());
                            person.setTime(editText2.getText().toString());
                            Toast.makeText(MainActivity.this, "信息" + person, Toast.LENGTH_SHORT).show();
                            String str = "符合条件的书有" + list2.size() + "本";
                            textView1.setText(str);
                            textView1.setVisibility(View.VISIBLE);
                            textView2.setText(list2.get(count).getName());
                            textView3.setText(list2.get(count).getType());
                            String str1 = "" + humanAge;
                            textView4.setText(str1);
                        }
                    }
                    break;
                case R.id.bt2:
                    if(count<(list2.size())-1){
                        count++;
                    }else{
                        count = 0;
                    }
                    imageView.setImageResource(list2.get(count).getPic());
                    person.setAge(humanAge);
                    person.setPer_name(editText1.getText().toString());
                    person.setTime(editText2.getText().toString());
                    Toast.makeText(MainActivity.this,"信息"+person,Toast.LENGTH_SHORT).show();
                    textView2.setText(list2.get(count).getName());
                    textView3.setText(list2.get(count).getType());
                    String str1 = ""+humanAge;
                    textView4.setText(str1);
                    break;
            }
        }
    }

}
