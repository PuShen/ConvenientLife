package com.lifeofnothing.wxp.convenientlife.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lifeofnothing.wxp.convenientlife.R;
import com.lifeofnothing.wxp.convenientlife.entity.BusLine;
import com.lifeofnothing.wxp.convenientlife.http.BusLineTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王晓普 on 2016/12/14.
 */

public class BuscityActivity extends Activity {
    private ImageView mIvBack;
    private TextView mTvSwitch;
    private EditText mEtCity;
    private ProgressDialog dialog;
    private List<BusLine> mList=new ArrayList<>();
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.IvBuscitytBack:
                    finish();
                    break;
                case R.id.TvBuscitySwitch:
                    if (0!=mEtCity.getText().length()){
                        dialog.show();
                        new BusLineTask(mEtCity.getText().toString(),"1",handler,mList).Bus_run();
                    }
                    break;
            }
        }
    };
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    SharedPreferences sharedPreferences=getSharedPreferences("ConvenientLife", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("bus_city",mEtCity.getText().toString());
                    editor.commit();
                    dialog.dismiss();
                    finish();
                    break;
                case 1:
                    dialog.dismiss();
                    Toast.makeText(BuscityActivity.this,R.string.tip_error_input,Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    dialog.dismiss();
                    Toast.makeText(BuscityActivity.this,R.string.tip_error_net,Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIvBack= (ImageView) findViewById(R.id.IvBuscitytBack);
        mTvSwitch= (TextView) findViewById(R.id.TvBuscitySwitch);
        mEtCity= (EditText) findViewById(R.id.EtBuscityCity);
        dialog=new ProgressDialog(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dialog.setMessage(getResources().getString(R.string.tip_load));
        mIvBack.setOnClickListener(listener);
        mTvSwitch.setOnClickListener(listener);
    }
}
