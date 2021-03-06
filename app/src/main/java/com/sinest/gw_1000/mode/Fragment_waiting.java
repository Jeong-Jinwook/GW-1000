package com.sinest.gw_1000.mode;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sinest.gw_1000.R;
import com.sinest.gw_1000.management.Application_manager;

/**
 * Created by Jinwook on 2016-11-21.
 *
 * 대기 상태에서 선택된 모드를 표시하는 프래그먼트
 */

public class Fragment_waiting extends Fragment {

    Button[] mode = new Button[4];
    int idx = 0;
    int[] checked_idx = new int[4]; // 선택된 패턴 인덱스 ex) {12, 3, 1, 9}

    private View view;

    public Fragment_waiting() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_waiting, container, false);

        Log.i("JW_LIFECYCLE", "Fragment_waiting - onCreateView");
        refresh();

        return view;
    }

    public void reset() {

        idx = 0;
        for (int i = 0; i< Application_manager.MAX_CHECKED; i++) {

            checked_idx[i] = -1;
        }
    }

    public void refresh() {

        for (int i = 0; i< Application_manager.MAX_CHECKED; i++) {

            if (checked_idx[i] != -1) {

                int btn_resourceId = getResources().getIdentifier("button_mode_" + (i + 1), "id", "com.sinest.gw_1000");
                mode[i] = (Button) view.findViewById(btn_resourceId);
                mode[i].setOnTouchListener(mTouchEvent);

                int resourceId = -1;
                resourceId = getResources().getIdentifier("mode" + (checked_idx[i] + 1), "drawable", "com.sinest.gw_1000");
                mode[i].setBackgroundResource(resourceId);
            }
        }
    }

    public void addCheckedIdx(int _idx) {

        checked_idx[idx] = _idx;
        idx++;
    }

    private View.OnTouchListener mTouchEvent = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Application_manager.set_m_start_sleep(0);

            Activity_waiting activity = (Activity_waiting) getActivity();
            Button button_clicked = (Button) view;

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                activity.setIsTouched_work(true);
                for (int i=0; i<4; i++) {

                    if (button_clicked == mode[i]) {

                        int resourceId = -1;
                        resourceId = getResources().getIdentifier("mode" + (checked_idx[i]+1) + "_on", "drawable", "com.sinest.gw_1000");
                        mode[i].setBackgroundResource(resourceId);
                    }
                }
            }
            else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

                activity.setIsTouched_work(false);
                for (int i=0; i<4; i++) {

                    if (button_clicked == mode[i]) {

                        int resourceId = -1;
                        resourceId = getResources().getIdentifier("mode" + (checked_idx[i]+1), "drawable", "com.sinest.gw_1000");
                        mode[i].setBackgroundResource(resourceId);

                        if (!activity.getIsTouched()) {

                            // i+1 번째 모드
                            activity.changeFragment_working(checked_idx[i] + 1);
                        }
                    }
                }
            }

            return true;
        }
    };

    @Override
    public void onResume() {
        super.onResume();

        Log.i("JW_LIFECYCLE", "Fragment_waiting - onResume");
        Application_manager.working_flag = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("JW_LIFECYCLE", "Fragment_waiting - onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.i("JW_LIFECYCLE", "Fragment_waiting - onDetach");
    }
}
