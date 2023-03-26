package com.example.carcrashcoursehw1.Logic;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class gameManager {

   private final Timer obsGenTimer=new Timer();
   private final Lane[] lanes;

   public gameManager(Lane[] lanes) {
      this.lanes = lanes;
   }

   public void moveCar(int direction)//1 = Right, 0 = Left, Works only with 3 Lanes!!!!!
   {
      switch (direction)
      {
         case 1:
         {
            Log.i("case1","Going Right");
            if (lanes[1].getIsCarInLane()==1)
            {
               lanes[1].setCarInLane(0);
               Log.i("Right_Lane2GoingOff",lanes[1].getIsCarInLane()+"");
               lanes[2].setCarInLane(1);
               Log.i("Right_Lane3GoingOn",lanes[2].getIsCarInLane()+"");
            }
            else if (lanes[0].getIsCarInLane()==1)
            {
               lanes[0].setCarInLane(0);
               Log.i("Right_Lane1GoingOff",lanes[0].getIsCarInLane()+"");
               lanes[1].setCarInLane(1);
               Log.i("Right_Lane2GoingOn", lanes[1].getIsCarInLane()+"");
            }
            break;
         }
         case 0:
         {
            Log.i("case0","Going Left");
            if (lanes[1].getIsCarInLane()==1)
            {
               lanes[1].setCarInLane(0);
               Log.i("Left_Lane2GoingOff", lanes[1].getIsCarInLane()+"");
               lanes[0].setCarInLane(1);
               Log.i("Left_Lane1GoingOn",lanes[0].getIsCarInLane()+"");
            }
            else if (lanes[2].getIsCarInLane()==1)
            {
               lanes[2].setCarInLane(0);
               Log.i("Left_Lane3GoingOff",lanes[2].getIsCarInLane()+"");
               lanes[1].setCarInLane(1);
               Log.i("Left_Lane2GoingOn",lanes[1].getIsCarInLane()+"");
            }
            break;
         }
      }
   }



}
