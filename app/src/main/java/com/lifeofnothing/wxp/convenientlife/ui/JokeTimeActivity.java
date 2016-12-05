package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.lifeofnothing.wxp.convenientlife.R;

import java.util.Calendar;

public class JokeTimeActivity extends Activity {
    //定义5个记录当前时间的变量
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private ImageView mIvBack;
    private Button mIvJokefbtn;
    private Button mIvJokebbtn;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            switch (v.getId()) {
                case R.id.IvWechatcontentBack:
                    finish();
                    break;
                case R.id.IvJokefbtn:
                    intent.putExtra("time","first");
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                    break;
                case R.id.IvJokebbtn:
                    intent.putExtra("time","second");
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_time);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        //获取当前的年月日小时分钟
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        //初始化DatePicker组件，初始化时指定监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker arg0, int year, int month, int day) {
                JokeTimeActivity.this.year = year;
                JokeTimeActivity.this.month = month;
                JokeTimeActivity.this.day = day;
                //显示当前日期，时间
                showDate(year, month, day, hour, minute);
            }
        });
        //为TimePicker指定监听器
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker arg0, int hour, int minute ) {
                JokeTimeActivity.this.hour = hour;
                JokeTimeActivity.this.minute = minute;
                //显示当前日期，时间
                showDate(year, month, day, hour, minute);
            }
        });
    }

    //定义在EditText中显示当前日期时间的方法
    private void showDate(int year, int month, int day, int hour, int minute) {
        EditText show = (EditText) findViewById(R.id.show);
        show.setText("您选择的日期为：" + year + "年" + (month + 1) + "月" + day + "日" + hour + "时" + minute + "分" + 00 + "秒");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvBack = (ImageView) findViewById(R.id.IvWechatcontentBack);
        mIvJokefbtn = (Button) findViewById(R.id.IvJokefbtn);
        mIvJokebbtn = (Button) findViewById(R.id.IvJokebbtn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIvBack.setOnClickListener(listener);
        mIvJokefbtn.setOnClickListener(listener);
        mIvJokebbtn.setOnClickListener(listener);
    }
}
