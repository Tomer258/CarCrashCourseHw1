package com.example.carcrashcoursehw1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.example.carcrashcoursehw1.Logic.Lane;
import com.example.carcrashcoursehw1.Logic.gameManager;

public class game_content extends AppCompatActivity {
    private ImageButton rightBtn,leftBtn;
    private gameManager gm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_content);
        initialStartingValues();
        initialGameManager();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gm.killHandler();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gm.killHandler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //gm.restartHandler();
    }

    private void initialGameManager() {
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

        Lane mLane1 = new Lane(0, iLane1);
        Lane mLane2= new Lane(1,iLane2);
        Lane mLane3= new Lane(0,iLane3);
        gm =new gameManager(this,new Lane[]{mLane1, mLane2, mLane3},
            new ImageView[]{findViewById(R.id.heart1),findViewById(R.id.heart2),findViewById(R.id.heart3)});
        gm.runGame2();

    }
    private void initialStartingValues() {
        rightBtn=findViewById(R.id.RightBTN);
        leftBtn=findViewById(R.id.leftBTN);
        setBtnOnClicks();
    }

    private void setBtnOnClicks() {
        rightBtn.setOnClickListener(v -> gm.moveCar(1));
        leftBtn.setOnClickListener(v -> gm.moveCar(0));
    }




}