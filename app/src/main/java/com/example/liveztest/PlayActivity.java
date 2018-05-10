package com.example.liveztest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paly);
        videoView = (VideoView)findViewById(R.id.video_view);
        Button play = (Button) findViewById(R.id.play);
        Button pause = (Button) findViewById(R.id.pause);
        Button replay = (Button) findViewById(R.id.replay);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        if(getIntent()!=null) {
            String uriString = getIntent().getStringExtra("PlayActivity");
            Uri uri = Uri.parse(uriString);
            videoView.setMediaController(new MediaController(this));
            videoView.setVideoURI(uri);
            videoView.start();
        }



    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.play:
                if(!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.pause:
                if(videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.replay:
                if(videoView.isPlaying()) {
                    videoView.resume();
                }
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(videoView!=null) {
            videoView.suspend();
        }
    }
}
