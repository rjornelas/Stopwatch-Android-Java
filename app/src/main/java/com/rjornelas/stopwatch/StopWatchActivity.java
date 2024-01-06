package com.rjornelas.stopwatch;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StopWatchActivity extends AppCompatActivity {

    Button btnStop;
    ImageView icAnchor;
    Animation rounding;
    Chronometer timer;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStop = findViewById(R.id.btnStop);
        icAnchor = findViewById(R.id.icAnchor);
        timer = findViewById(R.id.timer);



        startAnimation();
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        btnStop.setOnClickListener(it -> {
            stopAnimation();
            timer.stop();
            //TODO -> Create a dialogue at MainActivity with the time reached in this focus session
            time = String.valueOf(timer.getContentDescription());
            finish();
        });
    }

    private void startAnimation() {
        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);
        icAnchor.startAnimation(rounding);
    }

    private void stopAnimation() {
        rounding.reset();
        rounding.setDuration(0);
        rounding.setRepeatCount(0);
    }
}