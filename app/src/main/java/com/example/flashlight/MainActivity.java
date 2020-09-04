package com.example.flashlight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton switchBtnOn, switchBtnOff;

    private  CameraManager cameraManager;
    private  String camera;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);

        try {
            camera = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        switchBtnOn = findViewById(R.id.switchBtnOn);
        switchBtnOff = findViewById(R.id.switchBtnOff);

        switchBtnOn.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                switchBtnOn.setVisibility(View.GONE);
                switchBtnOff.setVisibility(View.VISIBLE);

                try {
                    cameraManager.setTorchMode(camera, true);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        switchBtnOff.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                switchBtnOff.setVisibility(View.GONE);
                switchBtnOn.setVisibility(View.VISIBLE);

                try {
                    cameraManager.setTorchMode(camera, false);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}