package com.rjornelas.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button btnStop;
    ImageView icAnchor;
    Animation rounding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStop = findViewById(R.id.btnStop);
        icAnchor = findViewById(R.id.icAnchor);

        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);
        icAnchor.startAnimation(rounding);

        btnStop.setOnClickListener(it -> {
            finish();
        });
    }
}