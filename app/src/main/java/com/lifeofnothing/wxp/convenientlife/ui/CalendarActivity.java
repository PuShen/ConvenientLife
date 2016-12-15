package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.CalendarView;
import com.lifeofnothing.wxp.convenientlife.entity.ClickDataListener;

/**
 * 日历显示activity
 */
public class CalendarActivity extends Activity {
	private ImageView mIvCaleandarback;
	private CalendarView calendarview;
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
	}

	@Override
	protected void onResume() {
		super.onResume();
		mIvCaleandarback.setOnClickListener(listener);
		calendarview.setClickDataListener(new ClickDataListener() {

			@Override
			public void clickData(String year, String month, String day) {
				Toast.makeText(getApplicationContext(),
						year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();

			}
		});

	}
}
