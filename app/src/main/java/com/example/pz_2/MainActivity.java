package com.example.pz_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;
    private LinearLayout rectangle;

    private final String R_VALUE = "rValue";
    private final String G_VALUE = "gValue";
    private final String B_VALUE = "bValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pz_2);

        seekBarBlue = findViewById(R.id.seekBarBlue);
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        rectangle = findViewById(R.id.rectangle);


        if (savedInstanceState != null) {
            int rProgress = savedInstanceState.getInt(R_VALUE);
            int gProgress = savedInstanceState.getInt(G_VALUE);
            int bProgress = savedInstanceState.getInt(B_VALUE);

            seekBarBlue.setProgress(bProgress);
            seekBarGreen.setProgress(gProgress);
            seekBarRed.setProgress(rProgress);
        }

        seekBarBlue.setOnSeekBarChangeListener(this);
        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);

        setRectangleRgbBackground();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(R_VALUE, seekBarRed.getProgress());
        outState.putInt(G_VALUE, seekBarGreen.getProgress());
        outState.putInt(B_VALUE, seekBarBlue.getProgress());

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
       setRectangleRgbBackground();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //...no logic needed
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //... no logic needed
    }

    private void setRectangleRgbBackground() {
        int red = seekBarRed.getProgress();
        int blue = seekBarBlue.getProgress();
        int green = seekBarGreen.getProgress();
        rectangle.setBackgroundColor(Color.rgb(red, green, blue));
    }
}
