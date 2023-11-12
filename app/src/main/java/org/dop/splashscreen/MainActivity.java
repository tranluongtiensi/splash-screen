package org.dop.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Title;
    private ImageView Logo;
    private View Running1, Running2, Running3;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Title = findViewById(R.id.title);
        Logo = findViewById(R.id.logo);

        Running1 = findViewById(R.id.running1);
        Running2 = findViewById(R.id.running2);
        Running3 = findViewById(R.id.running3);

        Animation logoAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_animation);
        Animation titleAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_animation);

        Animation running1Animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.running_animation);
        Animation running2Animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.running_animation);
        Animation running3Animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.running_animation);

        Running1.startAnimation(running1Animation);

        running1Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Running2.setVisibility(View.VISIBLE);
                Running2.startAnimation(running2Animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        running2Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Running3.setVisibility(View.VISIBLE);
                Running3.startAnimation(running3Animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        running3Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Logo.setVisibility(View.VISIBLE);
                Logo.startAnimation(logoAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Title.setVisibility(View.VISIBLE);
                final String animateTxt = Title.getText().toString();
                Title.setText("");
                count = 0;

                new CountDownTimer(animateTxt.length()*100, 100){
                    @Override
                    public void onTick(long l) {
                        Title.setText(Title.getText().toString()+animateTxt.charAt(count));
                        count++;
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}