package com.example.qiaoxian.mydialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button myButton1,myButton2,myButton3;
    private DatePickerDialog datePickerDialog;
    private MyDateDialogListener myDateDialogListener;
    private MyOnClick myOnClick;
    private AlertDialog.Builder builder;
    private final String[] love = {"编程","LOL","旅游","篮球"};
    private boolean[] bol = {false,false,false,false};
    private int idx = 0;
    private String msg = "您的爱好是";
    private String msg1;
    private TextView textView;
    private List<String> list1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myInit();
        myData();
    }


    private void myInit() {
        myButton1 = (Button)findViewById(R.id.button1);
        myButton2 = (Button)findViewById(R.id.button2);
        myButton3 = (Button)findViewById(R.id.button3);
        textView = (TextView)findViewById(R.id.textView);

    }

    private void myData() {
        list1 = new ArrayList<String>();
        builder = new AlertDialog.Builder(this);
        myDateDialogListener = new MyDateDialogListener();
        myOnClick = new MyOnClick();
        myButton1.setOnClickListener(myOnClick);
        myButton2.setOnClickListener(myOnClick);
        myButton3.setOnClickListener(myOnClick);


    }


    class MyOnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.button1:
                    datePickerDialog = new DatePickerDialog(MainActivity.this, myDateDialogListener, 1990, 0, 1);
                    datePickerDialog.show();
                    break;
                case R.id.button2:
                    mySingleDialog();
                    break;
                case R.id.button3:
                    myMultiDialog();
                    break;

            }
        }
    }

    //日期
    class MyDateDialogListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Toast.makeText(MainActivity.this,i+"年"+(int)((i1+1))+"月"+i2+"日",Toast.LENGTH_SHORT).show();
        }
    }

    //单选
    private void mySingleDialog() {
        idx=2;
        msg1 = "您的选择是";
        final String[] sex = {"男","女","性别未知","你猜"};
        builder.setIcon(R.drawable.star1).setTitle("性别选择").setSingleChoiceItems(sex, 2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                idx = i;

            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, msg1 + sex[idx], Toast.LENGTH_SHORT).show();
            }
        }).show();

    }

    //多选
    private void myMultiDialog() {
        list1.clear();
        msg = "您的爱好是";
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.drawable.star1);
        builder1.setTitle("选择个人爱好");
        builder1.setMultiChoiceItems(love, bol, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                for(int j=0;j<bol.length;j++) {
                    if (bol[j]) {
                        msg = msg+love[j]+".";
                        list1.add(love[j]);

                    }
                }
                if(list1.size() == 0){
                    msg = "您没爱好！";
                }
                textView.setText(msg);
                textView.setVisibility(View.VISIBLE);
            }
        });
        builder1.show();

    }

}
