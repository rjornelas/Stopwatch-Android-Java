package com.rjornelas.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash, tvSubSplash;
    Button btnStart;
    Animation atg, btgOne, btgTwo;
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvTitle);
        tvSubSplash = findViewById(R.id.tvSubtitle);
        btnStart = findViewById(R.id.btnStart);
        ivSplash = findViewById(R.id.ivSplash);

        setSplashAnimations();
        setFonts();

        btnStart.setOnClickListener(it -> {
            Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

    }

    private void setSplashAnimations() {
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgOne = AnimationUtils.loadAnimation(this, R.anim.btg_one);
        btgTwo = AnimationUtils.loadAnimation(this, R.anim.btg_two);

        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgOne);
        tvSubSplash.startAnimation(btgOne);
        btnStart.startAnimation(btgTwo);
    }

    private void setFonts() {
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnStart.setTypeface(MMedium);
    }
}