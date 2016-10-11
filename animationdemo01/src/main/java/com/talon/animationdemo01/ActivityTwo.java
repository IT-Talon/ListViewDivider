package com.talon.animationdemo01;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Window;
import android.widget.Toast;


public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            Bundle bundle = getIntent().getExtras();
            String animation = bundle.getString("animation");
            if (!TextUtils.isEmpty(animation)) {
//                Transition transition = null;
                switch (animation) {
                    case "circle":
                        break;
                    case "fade":
                        Fade fade = new Fade();
                        fade.setDuration(1000);
                        getWindow().setEnterTransition(fade);
                        break;
                    case "slide":
                        Slide slide = new Slide();
                        slide.setDuration(1000);
                        getWindow().setEnterTransition(slide);
                        break;
                    case "explode":
                        Explode explode = new Explode();
                        getWindow().setEnterTransition(explode);
                        break;
                }
//                if (transition != null) {
//                    transition.setDuration(1000);
//                    getWindow().setEnterTransition(transition);
//                    Toast.makeText(this, "aaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
//                }
            }

            setContentView(R.layout.activity_two);
        }
    }
}
