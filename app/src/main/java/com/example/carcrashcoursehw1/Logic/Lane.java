package com.example.carcrashcoursehw1.Logic;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.carcrashcoursehw1.R;

public class Lane {
    private int isCarInLane=0;
    private ImageView[] objects =new ImageView[8];

    public Lane(int isCarInLane,ImageView[] objects)
    {
        if (objects.length!=8)
            Log.e("Lane Copy","arrays not same size");
        else {
            System.arraycopy(objects, 0, this.objects, 0, objects.length);
        }
        for (int i = 1; i < this.objects.length-1; i++) {
            this.objects[i].setVisibility(View.INVISIBLE);
        }
        if (isCarInLane==1)
            this.objects[objects.length-1].setImageResource(R.drawable.car);
        else {
            this.objects[objects.length - 1].setImageResource(R.drawable.plyo_w39i_210318_ss4mp_generated);
            this.objects[objects.length - 1].setVisibility(View.INVISIBLE);
        }
    }

    public void setCarInLane(int carToggle)
    {
        if (carToggle==1)
            this.objects[7].setImageResource(R.drawable.car);
        else {
            this.objects[7].setImageResource(R.drawable.plyo_w39i_210318_ss4mp_generated);
            //this.objects[objects.length - 1].setVisibility(View.INVISIBLE);
        }
    }

    public void setDeerVisibility(int index,String mode)
    {
        if (index>=0&&index<=7)
            if (mode.equals("off"))
                this.objects[index].setVisibility(View.INVISIBLE);
            else if (mode.equals("on"))
                this.objects[index].setVisibility(View.VISIBLE);
    }

}
