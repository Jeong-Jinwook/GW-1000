package com.sinest.gw_1000.management;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;

import com.sinest.gw_1000.communication.Communicator;

/**
 * Created by Jinwook on 2016-11-20.
 */

public class Application_communicator extends Application {

    // DB name
    public final static String NAME_OF_SHARED_PREF = "myData";

    // 대기모드 산소농도 / 수압세기 / 사용시간 값
    public final static String VAL_OXYGEN   = "val_oxygen";
    public final static String VAL_PRESSURE = "val_pressure";
    public final static String VAL_TIME     = "val_time";

    // 대기모드 동작시간
    public final static String WAITING_WORKING_TIME = "waiting_working_time";

    // 라이브러리 20개중 선택된 값
    public final static int MAX_CHECKED = 4;
    public final static String LIBRARY_LOC_  = "library_location_";

    // 매뉴얼 모드 man_pattern_*_*
    public final static String MANUAL_MODE_PATTERN_ = "man_pattern_";
    public final static String MANUAL_MODE_TIME_ = "man_time_";

    // 언어 [KOR, ENG, CHI]
    public static int LANGUAGE = 0;

    // 사운드 id
    public final static int NUM_OF_LANG = 3;
    public final static int NUM_OF_SOUND = 5;
    public final static int[] ID_KOR = new int[5];
    public final static int[] ID_ENG = new int[5];
    public final static int[] ID_CHI = new int[5];
    public final static int[][] ID_LANG_SOUND = new int[NUM_OF_LANG][NUM_OF_SOUND];

    // App context
    private static Context context;

    // Communicator
    private static Communicator communicator;

    // SoundManager
    private static SoundManager soundManager;

    // 앱 동작 시간
    private int runningTime = 0;

    public void onCreate() {

        Application_communicator.context = getApplicationContext();
        Application_communicator.communicator = new Communicator(context);
        Application_communicator.soundManager = new SoundManager(context);
    }

    public static Communicator getCommunicator() {

        return communicator;
    }

    public static SoundManager getSoundManager() {

        return soundManager;
    }

    public static void setFullScreen(Activity activity)
    {
        activity.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }
}
