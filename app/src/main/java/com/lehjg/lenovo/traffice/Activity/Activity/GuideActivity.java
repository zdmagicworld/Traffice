package com.lehjg.lenovo.traffice.Activity.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;

import com.lehjg.lenovo.traffice.R;


/**
 * Created by lenovo on 2017/10/11.
 */

public class GuideActivity extends Activity {
    private ConstraintLayout constraintlayoutGuide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(GuideActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}