package com.example.carcrashcoursehw1.Logic;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.carcrashcoursehw1.R;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class Lane {
    private int isCarInLane = 0,index=0;
    private final ImageView[] objects = new ImageView[8];

    private CountDownTimer timer;

    public final int DELAY = 1000;

    public Lane(int isCarInLane, ImageView[] objects) {
        if (objects.length != 8)
            Log.e("Lane Copy", "arrays not same size");
        else {
            System.arraycopy(objects, 0, this.objects, 0, objects.length);
        }
        for (int i = 0; i < this.objects.length - 1; i++) {
            this.objects[i].setVisibility(View.INVISIBLE);
        }
        if (isCarInLane == 1) {
            this.setCarInLane(1);
            this.objects[objects.length - 1].setImageResource(R.drawable.car);
        } else {
            this.setCarInLane(0);
            this.objects[objects.length - 1].setImageResource(R.drawable.plyo_w39i_210318_ss4mp_generated);
            this.objects[objects.length - 1].setVisibility(View.INVISIBLE);
        }
    }

    public void setCarInLane(int carToggle) {
        if (carToggle == 1) {
            Log.i("SetCarInLane", "Car toggled");
            this.setIsCarInLane(1);
            this.objects[7].setImageResource(R.drawable.car);
            this.objects[7].setVisibility(View.VISIBLE);
        } else {
            Log.i("SetCarInLane", "Car not toggled");
            this.setIsCarInLane(0);
            this.objects[7].setImageResource(R.drawable.plyo_w39i_210318_ss4mp_generated);
            this.objects[7].setVisibility(View.INVISIBLE);
        }
    }

    public void setDeerVisibility(int index, String mode) {
        if (index >= 0 && index <= 7) {
            if (mode.equals("off")) {
                Log.i("setDeerVisFirstIf", "set index" +index +"off");
                this.objects[index].setVisibility(View.INVISIBLE);
            } else if (mode.equals("on")) {
                Log.i("setDeerVisSecondIf", "set index" +index +"on");
                this.objects[index].setVisibility(View.VISIBLE);
            }
        }
    }

    public ImageView getItemInLane(int index) {
        return this.objects[index];
    }

    public int getIsCarInLane() {
        return this.isCarInLane;
    }

    public void setIsCarInLane(int isCarInLane) {
        this.isCarInLane = isCarInLane;
    }//setting if car is in lane within the instance

    public void runLane()
    {
        timer =new CountDownTimer(DELAY*objects.length,DELAY) {
            @Override
            public void onTick(long l) {
                Log.d("LaneTimer","working on index: " +index+"");
                setDeerVisibility(index,"on");
                if (index>0)
                    setDeerVisibility(index-1,"off");

                index++;
            }

            @Override
            public void onFinish() {
                index=0;
                setDeerVisibility(7,"off");
                Log.d("LaneTimer","Timer D3d");
            }
        }.start();
    }
}
