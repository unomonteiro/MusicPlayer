package monteirodev.io.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ActivityMainBinding binding;
    Button playButton;
    Button pauseButton;
    Button seekButton;
    Button volumeDownButton;
    Button stopButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.quesafo);

        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(this);

        pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(this);

        seekButton = (Button) findViewById(R.id.seek_button);
        seekButton.setOnClickListener(this);

        volumeDownButton = (Button) findViewById(R.id.volume_down);
        volumeDownButton.setOnClickListener(this);

        stopButton = (Button) findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //handle multiple view click events
            case R.id.play_button: {
                Toast.makeText(MainActivity.this, "PlayCLicked", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            }
            case R.id.pause_button: {
                Toast.makeText(MainActivity.this, "pause_button", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                break;
            }
            case R.id.seek_button: {
                Toast.makeText(MainActivity.this, "seek_button", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo((3*60 + 15) * 1000);
                break;
            }
            case R.id.volume_down: {
                Toast.makeText(MainActivity.this, "volume_down", Toast.LENGTH_SHORT).show();
                mediaPlayer.setVolume(0.5f, 0.5f);
                break;
            }
            case R.id.stop_button: {
                Toast.makeText(MainActivity.this, "pause_button", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                break;
            }
            default: {
                break;
            }
        }
    }
}
