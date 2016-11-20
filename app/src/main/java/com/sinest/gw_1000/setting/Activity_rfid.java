package com.sinest.gw_1000.setting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sinest.gw_1000.R;
import com.sinest.gw_1000.mode.Activity_library;

public class Activity_rfid extends Activity {

    Button rfid_w_up; Button rfid_w_down;
    Button rfid_t_up; Button rfid_t_down;
    Button rfid_save; Button rfid_check; Button rfid_off;
    Button rfid_back;

    boolean[] rfid_flag = {true,true,true};

    TextView rfid_t_c; TextView rfid_w_c;

    String s_buf;
    int int_buf;
    int working_mode_num;
    int treatment_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_rfid);

        rfid_w_up = (Button) findViewById(R.id.rfid_w_up);
        rfid_w_down = (Button) findViewById(R.id.rfid_w_down);
        rfid_t_up = (Button) findViewById(R.id.rfid_t_up);
        rfid_t_down = (Button) findViewById(R.id.rfid_t_down);
        rfid_save = (Button) findViewById(R.id.rfid_save);
        rfid_check = (Button) findViewById(R.id.rfid_check);
        rfid_off = (Button) findViewById(R.id.rfid_off);
        rfid_back = (Button) findViewById(R.id.rfid_back);

        rfid_t_c = (TextView) findViewById(R.id.rfid_t_c);
        rfid_w_c = (TextView) findViewById(R.id.rfid_w_c);

        working_mode_num = 0;
        treatment_num = 0;
        rfid_t_c.setText(Integer.toString(working_mode_num));
        rfid_w_c.setText(Integer.toString(treatment_num));


        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.rfid_off:
                        //
                        if (rfid_flag[2] == true) {
                            rfid_off.setBackgroundResource(R.drawable.on);
                            rfid_flag[2] = false;
                        } else {
                            rfid_off.setBackgroundResource(R.drawable.off);
                            rfid_flag[2] = true;
                        }
                        break;
                }
            }
        };

        rfid_off.setOnClickListener(listener);

        rfid_w_up.setOnTouchListener(mTouchEvent);
        rfid_w_down.setOnTouchListener(mTouchEvent);
        rfid_t_up.setOnTouchListener(mTouchEvent);
        rfid_t_down.setOnTouchListener(mTouchEvent);
        rfid_save.setOnTouchListener(mTouchEvent);
        rfid_check.setOnTouchListener(mTouchEvent);
        rfid_back.setOnTouchListener(mTouchEvent);

    }

    private View.OnTouchListener mTouchEvent = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int id = view.getId();
            if (action == MotionEvent.ACTION_DOWN) {
                switch (id) {
                    case R.id.rfid_w_up:
                        rfid_w_up.setBackgroundResource(R.drawable.button_up_on);
                        break;
                    case R.id.rfid_w_down:
                        rfid_w_down.setBackgroundResource(R.drawable.button_down_on);
                        break;
                    case R.id.rfid_t_up:
                        rfid_t_up.setBackgroundResource(R.drawable.button_up_on);
                        break;
                    case R.id.rfid_t_down:
                        rfid_t_down.setBackgroundResource(R.drawable.button_down_on);
                        break;
                    case R.id.rfid_save:
                        rfid_save.setBackgroundResource(R.drawable.save_setting_on);
                        break;
                    case R.id.rfid_check:
                        rfid_check.setBackgroundResource(R.drawable.check_on);
                        break;
                    case R.id.rfid_back:
                        rfid_back.setBackgroundResource(R.drawable.button_elipse_back_on);
                        break;
                }
            } else if (action == MotionEvent.ACTION_UP) {
                switch (id) {
                    case R.id.rfid_w_up:
                        rfid_w_up.setBackgroundResource(R.drawable.button_up_off);
                        s_buf = (String)rfid_t_c.getText();
                        int_buf = Integer.parseInt(s_buf) + 1;
                        working_mode_num++;
                        s_buf = Integer.toString(int_buf);
                        rfid_t_c.setText(s_buf);
                        break;
                    case R.id.rfid_w_down:
                        rfid_w_down.setBackgroundResource(R.drawable.button_down_off);
                        s_buf = (String)rfid_t_c.getText();
                        int_buf = Integer.parseInt(s_buf) - 1;
                        working_mode_num--;
                        s_buf = Integer.toString(int_buf);
                        rfid_t_c.setText(s_buf);
                        break;
                    case R.id.rfid_t_up:
                        rfid_t_up.setBackgroundResource(R.drawable.button_up_off);
                        s_buf = (String)rfid_w_c.getText();
                        int_buf = Integer.parseInt(s_buf) + 1;
                        treatment_num++;
                        s_buf = Integer.toString(int_buf);
                        rfid_w_c.setText(s_buf);
                        break;
                    case R.id.rfid_t_down:
                        rfid_t_down.setBackgroundResource(R.drawable.button_down_off);
                        s_buf = (String)rfid_w_c.getText();
                        int_buf = Integer.parseInt(s_buf) - 1;
                        treatment_num--;
                        s_buf = Integer.toString(int_buf);
                        rfid_w_c.setText(s_buf);
                        break;
                    case R.id.rfid_save:
                        rfid_save.setBackgroundResource(R.drawable.save_setting_off);
                        //save -> working_mode_num, treatment_num

                        break;
                    case R.id.rfid_check:
                        rfid_check.setBackgroundResource(R.drawable.check_off);

                        break;
                    case R.id.rfid_back:
                        rfid_back.setBackgroundResource(R.drawable.button_elipse_back_off);
                        finish();
                        break;
                }
            }
            return true;
        }
    };
}
