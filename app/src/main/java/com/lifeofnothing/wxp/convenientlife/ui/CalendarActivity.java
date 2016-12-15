package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
	private TextView textView;
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
		textView = (TextView)findViewById(R.id.first);
		textView = (TextView)findViewById(R.id.second);
		textView = (TextView)findViewById(R.id.three);
		textView = (TextView)findViewById(R.id.four);
		textView = (TextView)findViewById(R.id.five);
		textView = (TextView)findViewById(R.id.six);
		textView = (TextView)findViewById(R.id.seven);
	}
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what){
				case 0:
					mPerpetualCalendar = (PerpetualCalendar) msg.obj;
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
				Toast.makeText(getApplicationContext(),
						year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
				new Thread(new PerpetualCalendarTask(year + "-" + month + "-" + day,mHandler)).start();

			}
		});

	}
}
