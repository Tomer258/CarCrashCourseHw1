package com.example.carcrashcoursehw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.carcrashcoursehw1.Logic.Lane;

public class game_content extends AppCompatActivity {
    private Lane mLane1,mLane2,mLane3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_content);
        initialLanes();

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