package com.talon.animationdemo01;

import android.animation.Animator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import static android.R.attr.id;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
    }

    public void onClick(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            switch (view.getId()) {
                case R.id.button:
                    Animator animator = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2, view.getHeight() / 2, 0, view.getHeight() / 2);
                    animator.setDuration(1000);
                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
                    animator.start();
                    Toast.makeText(this, "fdsafdasd", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.circleAnimation:
                    bundle.putString("animation", "circle");
                    break;
                case R.id.explodeAnimation:
                    bundle.putString("animation", "explode");
                    break;
                case R.id.fadeAnimation:
                    bundle.putString("animation", "fade");
                    break;
                case R.id.slideAnimation:
                    bundle.putString("animation", "slide");
                    break;
            }
            Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        }
        else{
            Toast.makeText(this, "API版本低了", Toast.LENGTH_SHORT).show();
        }
    }
}
