package com.sinest.gw_1000.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;

import com.sinest.gw_1000.R;

public class Activity_finishtime extends Activity {

    Button finish_time1; Button finish_time2; Button finish_time3;
    Button finish_time4; Button finish_time5; Button finish_time6;
    Button finish_time7; Button finish_time8; Button finish_time9;
    Button finish_time0; Button finish_time_enter; Button finish_time_back;

    boolean[] finish_flag = {true,true,true,true,true,true,true,true,true,true,true,true};

    Chronometer finish_time;

    String s_buf;
    int int_buf;
    int int_c = 0;

    String buf_l;
    String buf_r;
    int int_l;
    int int_r;
    int check;

    Intent finish_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_finish_time);

        finish_time1 = (Button) findViewById(R.id.finish_time1);
        finish_time2 = (Button) findViewById(R.id.finish_time2);
        finish_time3 = (Button) findViewById(R.id.finish_time3);
        finish_time4 = (Button) findViewById(R.id.finish_time4);
        finish_time5 = (Button) findViewById(R.id.finish_time5);
        finish_time6 = (Button) findViewById(R.id.finish_time6);
        finish_time7 = (Button) findViewById(R.id.finish_time7);
        finish_time8 = (Button) findViewById(R.id.finish_time8);
        finish_time9 = (Button) findViewById(R.id.finish_time9);
        finish_time0 = (Button) findViewById(R.id.finish_time0);
        finish_time_enter = (Button) findViewById(R.id.finish_time_enter);
        finish_time_back = (Button) findViewById(R.id.finish_time_back);

        finish_result = this.getIntent();

        finish_time = (Chronometer) findViewById(R.id.finish_time);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/digital.ttf");
        finish_time.setText(finish_result.getStringExtra("finish"));
        finish_time.setTypeface(tf);

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.finish_time1:
                        //
                        time_sum(1);
                        break;
                    case R.id.finish_time2:
                        //
                        time_sum(2);
                        break;
                    case R.id.finish_time3:
                        //
                        time_sum(3);
                        break;
                    case R.id.finish_time4:
                        //
                        time_sum(4);
                        break;
                    case R.id.finish_time5:
                        //
                        time_sum(5);
                        break;
                    case R.id.finish_time6:
                        //
                        time_sum(6);
                        break;
                    case R.id.finish_time7:
                        //
                        time_sum(7);
                        break;
                    case R.id.finish_time8:
                        //
                        time_sum(8);
                        break;
                    case R.id.finish_time9:
                        //
                        time_sum(9);
                        break;
                    case R.id.finish_time0:
                        //
                        time_sum(0);
                        break;


                    case R.id.finish_time_enter:
                        //
                        finish_result.putExtra("finish",s_buf);
                        setResult(RESULT_OK, finish_result);
                        finish();

                        break;
                    case R.id.finish_time_back:
                        //
                        finish();
                        break;
                }
            }
        };

        finish_time1.setOnClickListener(listener);
        finish_time2.setOnClickListener(listener);
        finish_time3.setOnClickListener(listener);
        finish_time4.setOnClickListener(listener);
        finish_time5.setOnClickListener(listener);
        finish_time6.setOnClickListener(listener);
        finish_time7.setOnClickListener(listener);
        finish_time8.setOnClickListener(listener);
        finish_time9.setOnClickListener(listener);
        finish_time0.setOnClickListener(listener);
        finish_time_enter.setOnClickListener(listener);
        finish_time_back.setOnClickListener(listener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return false;
    }

    void time_sum(int k)
    {
        if(int_c >= 4)
        {
            s_buf = (String)finish_time.getText();
            check = s_buf.indexOf(":");
            buf_l = s_buf.substring(0,check);
            buf_r = s_buf.substring(check+1);
            int_buf = Integer.parseInt(buf_l)*100 + Integer.parseInt(buf_r);
            // change
            int_buf = (int_buf%1000)*10 + k;

            int_l = int_buf/100;
            int_r = int_buf%100;

            if(int_l == 0)
            {
                buf_l = "00";
            }else if(int_l < 10)
            {
                buf_l = "0"+Integer.toString(int_l);
            }else{
                buf_l = Integer.toString(int_l);
            }

            if(int_r == 0)
            {
                buf_r = "00";
            }else if(int_r < 10){
                buf_r = "0"+Integer.toString(int_r);
            }else{
                buf_r = Integer.toString(int_r);
            }

            s_buf = buf_l+":"+buf_r;

            finish_time.setText(s_buf);

        }else if(int_c == 0) {
            finish_time.setText("00:0"+Integer.toString(k));
            int_c++;
        }
        else {
            s_buf = (String)finish_time.getText();
            check = s_buf.indexOf(":");
            buf_l = s_buf.substring(0,check);
            buf_r = s_buf.substring(check+1);
            int_buf = Integer.parseInt(buf_l)*100 + Integer.parseInt(buf_r);
            //change
            int_buf = int_buf*10 + k;

            int_l = int_buf/100;
            int_r = int_buf%100;

            if(int_l == 0)
            {
                buf_l = "00";
            }else if(int_l < 10)
            {
                buf_l = "0"+Integer.toString(int_l);
            }else{
                buf_l = Integer.toString(int_l);
            }

            if(int_r == 0)
            {
                buf_r = "00";
            }else if(int_r < 10){
                buf_r = "0"+Integer.toString(int_r);
            }else{
                buf_r = Integer.toString(int_r);
            }

            s_buf = buf_l+":"+buf_r;

            finish_time.setText(s_buf);
            int_c++;
        }
    }
}
