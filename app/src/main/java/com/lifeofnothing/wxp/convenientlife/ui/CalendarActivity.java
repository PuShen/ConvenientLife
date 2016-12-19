package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.CalendarView;
import com.lifeofnothing.wxp.convenientlife.entity.ClickDataListener;
import com.lifeofnothing.wxp.convenientlife.entity.PerpetualCalendar;
import com.lifeofnothing.wxp.convenientlife.http.PerpetualCalendarTask;

/**
 * 日历显示activity
 */
public class CalendarActivity extends Activity {
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	private TextView textView4;
	private TextView textView5;
	private TextView textView6;
	private TextView textView7;
	private ImageView mIvCaleandarback;
	private CalendarView calendarview;
	private PerpetualCalendar mPerpetualCalendar;
	private View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.IvCalendarBack:
					finish();
					break;
			}
		}
	};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendarmain);
	}

	@Override
	protected void onStart() {
		super.onStart();
		mIvCaleandarback= (ImageView) findViewById(R.id.IvCalendarBack);
		calendarview = (CalendarView) findViewById(R.id.calendarview);
		textView1 = (TextView)findViewById(R.id.first);
		textView2 = (TextView)findViewById(R.id.second);
		textView3 = (TextView)findViewById(R.id.three);
		textView4 = (TextView)findViewById(R.id.four);
		textView5 = (TextView)findViewById(R.id.five);
		textView6 = (TextView)findViewById(R.id.six);
		textView7 = (TextView)findViewById(R.id.seven);
	}
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what){
				case 0:
					mPerpetualCalendar = (PerpetualCalendar) msg.obj;
					/* 测试
					Log.e("dghfad",mPerpetualCalendar.toString());*/
					textView1.setText(mPerpetualCalendar.getmAnimalsYear());
					textView2.setText(mPerpetualCalendar.getmLunarYear());
					textView3.setText(mPerpetualCalendar.getmLunar());
					textView4.setText(mPerpetualCalendar.getmAvoid());
					textView5.setText(mPerpetualCalendar.getmSuit());
					textView6.setText(mPerpetualCalendar.getmDate());
					textView7.setText(mPerpetualCalendar.getmHoliday());
					break;
			}
		}
	};
	@Override
	protected void onResume() {
		super.onResume();
		mIvCaleandarback.setOnClickListener(listener);
		calendarview.setClickDataListener(new ClickDataListener() {

			@Override
			public void clickData(String year, String month, String day) {
				new Thread(new PerpetualCalendarTask(year + "-" + month + "-" + day,mHandler)).start();

			}
		});

	}
}
