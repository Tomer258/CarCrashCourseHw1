package com.example.carcrashcoursehw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.carcrashcoursehw1.Logic.Lane;

public class game_content extends AppCompatActivity {
    private Lane mLane1,mLane2,mLane3;
    private ImageButton rightBtn,leftBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_content);
        initialLanes();
        initialStartingValues();
    }

    private void initialStartingValues() {
        rightBtn=findViewById(R.id.RightBTN);
        leftBtn=findViewById(R.id.leftBTN);
        setBtnOnClicks();
    }

    private void setBtnOnClicks() {
        rightBtn.setOnClickListener(v -> moveCar(1));

        leftBtn.setOnClickListener(v -> moveCar(0));
    }
    private  void moveCar(int direction)//1 = Right, 0 = Left
    {
        switch (direction)
        {
            case 1:
            {
                Log.i("case1","Going Right");
                if (mLane2.getIsCarInLane()==1)
                {
                    mLane2.setCarInLane(0);
                    Log.i("Right_Lane2GoingOff",mLane2.getIsCarInLane()+"");
                    mLane3.setCarInLane(1);
                    Log.i("Right_Lane3GoingOn",mLane3.getIsCarInLane()+"");
                }
                else if (mLane1.getIsCarInLane()==1)
                {
                    mLane1.setCarInLane(0);
                    Log.i("Right_Lane1GoingOff",mLane1.getIsCarInLane()+"");
                    mLane2.setCarInLane(1);
                    Log.i("Right_Lane2GoingOn",mLane2.getIsCarInLane()+"");
                }
                break;
            }
            case 0:
            {
                Log.i("case0","Going Left");
                if (mLane2.getIsCarInLane()==1)
                {
                    mLane2.setCarInLane(0);
                    Log.i("Left_Lane2GoingOff",mLane2.getIsCarInLane()+"");
                    mLane1.setCarInLane(1);
                    Log.i("Left_Lane1GoingOn",mLane1.getIsCarInLane()+"");
                }
                else if (mLane3.getIsCarInLane()==1)
                {
                    mLane3.setCarInLane(0);
                    Log.i("Left_Lane3GoingOff",mLane3.getIsCarInLane()+"");
                    mLane2.setCarInLane(1);
                    Log.i("Left_Lane2GoingOn",mLane2.getIsCarInLane()+"");
                }
                break;
            }
        }
    }

    private void initialLanes() {
        ImageView[] iLane1 ={findViewById(R.id.firstLaneDeer1),findViewById(R.id.firstLaneDeer2),
                            findViewById(R.id.firstLaneDeer3),findViewById(R.id.firstLaneDeer4),
                            findViewById(R.id.firstLaneDeer5),findViewById(R.id.firstLaneDeer6),
                            findViewById(R.id.firstLaneDeer7),findViewById(R.id.specialPosFirstLane)};

        ImageView[] iLane2 ={findViewById(R.id.SecondLaneDeer1),findViewById(R.id.SecondLaneDeer2),
                findViewById(R.id.SecondLaneDeer3),findViewById(R.id.SecondLaneDeer4),
                findViewById(R.id.SecondLaneDeer5),findViewById(R.id.SecondLaneDeer6),
                findViewById(R.id.SecondLaneDeer7),findViewById(R.id.specialPosSecondLane)};

        ImageView[] iLane3 ={findViewById(R.id.ThirdLaneDeer1),findViewById(R.id.ThirdLaneDeer2),
                findViewById(R.id.ThirdLaneDeer3),findViewById(R.id.ThirdLaneDeer4),
                findViewById(R.id.ThirdLaneDeer5),findViewById(R.id.ThirdLaneDeer6),
                findViewById(R.id.ThirdLaneDeer7),findViewById(R.id.specialPosThirdLane)};

        mLane1= new Lane(0,iLane1);
        mLane2= new Lane(1,iLane2);
        mLane3= new Lane(0,iLane3);
    }
}