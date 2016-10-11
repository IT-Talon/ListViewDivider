package com.lol.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private MediaPlayer mediaPlayer;
    private ImageView a;
    private VideoView mVideoView;
    private String path = "http://flv.bn.netease.com/videolib3/1601/13/RzAQP8148/HD/RzAQP8148-mobile.mp4";
    private SurfaceView mSurfaceView;
    private CheckBox mCheckBoxPlay;
    private CheckBox mCheckBoxScreen;
    private SeekBar mSeekBar;
    private TextView current;
    private TextView total;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        playSourceHttp();
        playSourceLocal();
//        initView();

    }

    private void initView() {
//        mVideoView = (VideoView) findViewById(R.id.videoView_main);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoURI(Uri.parse("android.resource://com.lol.mediaplayer/" + R.raw.mp4));
        mVideoView.start();
    }

    private void playSourceLocal() {
        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview_main);
        mCheckBoxPlay = (CheckBox) findViewById(R.id.cb_play);
        mCheckBoxPlay.setOnCheckedChangeListener(this);
        mCheckBoxScreen = (CheckBox) findViewById(R.id.cb_screen);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        current = (TextView) findViewById(R.id.tv_current);
        total = (TextView) findViewById(R.id.tv_total);
        surfaceHolder = mSurfaceView.getHolder();

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer = new MediaPlayer();
                try {
//                    mediaPlayer.setDataSource(MainActivity.this, Uri.parse("android.resource://com.lol.mediaplayer/" + R.raw.mp4));
                    mediaPlayer.setDataSource(path);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setDisplay(surfaceHolder);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
//                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    private void playSourceHttp() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    if (mp.getVideoWidth() > 0 && mp.getVideoHeight() > 0) {
                        mp.start();
                        Log.i("----->", "aaaa");
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }else{
            mediaPlayer.start();
        }

    }
}
