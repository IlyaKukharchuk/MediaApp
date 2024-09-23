package com.example.media;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MediaActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    VideoView videoView;
    Button playAudioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_activity);

        videoView = findViewById(R.id.videoView);
        playAudioButton = findViewById(R.id.playAudioButton);

        // Воспроизведение видео
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample_video);  // Пример видео
        videoView.start();

        // Воспроизведение аудио
        mediaPlayer = MediaPlayer.create(this, R.raw.ariana);
        playAudioButton.setOnClickListener(v -> mediaPlayer.start());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
