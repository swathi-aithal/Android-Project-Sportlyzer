package com.sportlyzer.sportlyzer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class cricketvedios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketvedios);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.yt_view1);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "KY8gsVeKn0w";
                youTubePlayer.loadVideo(videoId, 0);

            }
        });

        YouTubePlayerView youTubePlayerView1 = findViewById(R.id.yt_view2);
        getLifecycle().addObserver(youTubePlayerView1);

        youTubePlayerView1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "Fj_WWSAJ2qw";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }
}