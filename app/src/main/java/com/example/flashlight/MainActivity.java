package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton switchBtnOn, switchBtnOff;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switchBtnOn = findViewById(R.id.switchBtnOn);
        switchBtnOff = findViewById(R.id.switchBtnOff);

        camera = Camera.open();
        final Camera.Parameters parameters = camera.getParameters();

        switchBtnOn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchBtnOn.setVisibility(View.GONE);
                switchBtnOff.setVisibility(View.VISIBLE);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                //camera.startPreview();
            }
        });

        switchBtnOff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchBtnOff.setVisibility(View.GONE);
                switchBtnOn.setVisibility(View.VISIBLE);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();
            }
        });
    }
}