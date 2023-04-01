package com.example.carcrashcoursehw1.Logic;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.carcrashcoursehw1.OnCustomEventListener;

import java.util.Random;


public class gameManager implements OnCustomEventListener {

   private final Lane[] lanes;
   private final ImageView[] hearts;
   private int droppedHeartCounter=0;
   private final Context c;
   Vibrator vibrator;

   public gameManager(Context c,Lane[] lanes, ImageView[] hearts) {
      this.c=c;
      vibrator=(Vibrator)c.getSystemService(Context.VIBRATOR_SERVICE);
      this.lanes = lanes;
      for (int i = 0; i < this.lanes.length; i++) {
         lanes[i].setOnCustomEventListener(this);
      }
      this.hearts=hearts;
   }
   public void moveCar(int direction)//1 = Right, 0 = Left, Works only with 3 Lanes!!!!!
   {
      switch (direction) {
         case 1: {
            Log.i("case1", "Going Right");
            assert lanes != null;
            if (lanes[1].getIsCarInLane() == 1) {
               lanes[1].setCarInLane(0);
               Log.i("Right_Lane2GoingOff", lanes[1].getIsCarInLane() + "");
               lanes[2].setCarInLane(1);
               Log.i("Right_Lane3GoingOn", lanes[2].getIsCarInLane() + "");
            } else if (lanes[0].getIsCarInLane() == 1) {
               lanes[0].setCarInLane(0);
               Log.i("Right_Lane1GoingOff", lanes[0].getIsCarInLane() + "");
               lanes[1].setCarInLane(1);
               Log.i("Right_Lane2GoingOn", lanes[1].getIsCarInLane() + "");
            }
            break;
         }
         case 0: {
            Log.i("case0", "Going Left");
            assert lanes != null;
            if (lanes[1].getIsCarInLane() == 1) {
               lanes[1].setCarInLane(0);
               Log.i("Left_Lane2GoingOff", lanes[1].getIsCarInLane() + "");
               lanes[0].setCarInLane(1);
               Log.i("Left_Lane1GoingOn", lanes[0].getIsCarInLane() + "");
            } else if (lanes[2].getIsCarInLane() == 1) {
               lanes[2].setCarInLane(0);
               Log.i("Left_Lane3GoingOff", lanes[2].getIsCarInLane() + "");
               lanes[1].setCarInLane(1);
               Log.i("Left_Lane2GoingOn", lanes[1].getIsCarInLane() + "");
            }
            break;
         }
      }
   }
   public void removeHeart()//lo tov
   {
      Log.i("Game Manager: ", "CRASH!!!!!!!!!!!!!!!! -1 HP");
      if (this.hearts.length-1-droppedHeartCounter>=0)
      {
         this.hearts[droppedHeartCounter].setVisibility(View.INVISIBLE);
         droppedHeartCounter++;
      }
      else
      {
         droppedHeartCounter=0;
         gameOver();
      }
      new Handler(Looper.getMainLooper()).post(() -> {
         Toast.makeText(c,"Ouch",Toast.LENGTH_SHORT).show();
         // Vibrate for 500 milliseconds
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
      });
   }
   private void gameOver() {
      Log.i("Game Manager: ", "GAME OVER");
   }

   public void runGame() {
      Handler handler = new Handler();
      Runnable runnable = new Runnable() {
         @Override
         public void run() {
            int max=0;
            for (Lane lane : lanes) {
               Random r = new Random();
               int randomNum = r.nextInt(100) + 1;
               if (randomNum >= 40) {
                  if (max<2)
                     lane.runLane();
                  max++;
               }
            }
            if (max==0)//in case all random failed to generate
               lanes[1].runLane();
            handler.postDelayed(this,1500);
         }
      };
      handler.postDelayed(runnable,0);
   }
   @Override
   public void onEvent() {
      removeHeart();

   }
}