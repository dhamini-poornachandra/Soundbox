package soundbox.myfirstapp.com.soundbox;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button playButton;
    private Button prevButton;
    private Button nextButton;
    private MediaPlayer mediaPlayer;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

        text = (TextView) findViewById(R.id.artistName);

        playButton = (Button) findViewById(R.id.playButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.playButton:
                if (mediaPlayer.isPlaying()){
                    pauseMusic();
                }
                else {
                    playMusic();
                }
                break;

            case R.id.prevButton:
                prevMusic();
                break;

            case R.id.nextButton:
                nextMusic();
                break;

        }

    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            text.setText("music player is now playing");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }

    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            text.setText("Music paused");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            text.setText("you just reset");
        }
    }

    public void nextMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            text.setText("you just reset");
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
            super.onDestroy();
        }


    }
