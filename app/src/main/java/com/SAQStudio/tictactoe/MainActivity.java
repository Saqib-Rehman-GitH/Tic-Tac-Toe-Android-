package com.SAQStudio.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    boolean gameActive = true;
    int activePlayer = 0 ;

    int [] gameState = { 2 , 2 , 2 ,
                        2 , 2 , 2 ,
                        2 , 2 , 2};

    int[][] winPositions ={ { 0 , 1 , 2 } ,
                            { 3 , 4 , 5} ,
                            { 6 , 7 , 8 } ,

                            { 0 , 3 , 6 } ,
                            { 1 , 4 , 7 } ,
                            { 2 , 5 , 8 } ,
                            { 6 , 4 , 2 } ,
                            { 0 , 4 , 8 }

    };
    TextView statusTV;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            statusTV = findViewById(R.id.TVlower);
        }

    //scheme for players
    //0 -> 0
    //1-> X

        public void gridTaped(View v)
            {
                    ImageView img = (ImageView) v ;
                    int tapedImage = Integer.parseInt(img.getTag().toString());

                    if (gameState[tapedImage] == 2 && gameActive  ) {
                            gameState[tapedImage] = activePlayer;
                            img.setTranslationY(-1000f);
                            if(gameState[tapedImage] == 1){
                                    img.setImageResource(R.drawable.x);
                                    activePlayer = 0 ;
                                    statusTV.setText(" 0's Turn ");
                            }
                            else {
                                img.setImageResource(R.drawable.o);
                                activePlayer = 1 ;
                                statusTV.setText(" X's Turn ");
                            }
                     img.animate().translationYBy(1000f).setDuration(300);
                    }

                    for(int[] winPosition : winPositions ){
                        if (
                                        gameState [ winPosition[0] ] == gameState[winPosition[1]]//CONDITION 1
                                &&
                                        gameState [ winPosition[1] ] == gameState[winPosition[2]]//CONDITION 2
                                &&
                                        gameState [ winPosition[2] ] == gameState[winPosition[3]]//CONDITION 3
                        )//IF CONDTION PARAM ENDS
                             {
                                    if( gameState [ winPosition[0] ] == 0 ){
                                        statusTV.setText("player X has Won");

                                    }else{
                                        statusTV.setText("player 0 has won");

                                    }

                        }
                    }//FOR LOOP ENDS

            }//GRIDTAPPED ENDS

            public void resetGame(View v){
                    activePlayer =0 ;
                    for(int i = 0 ; i <= gameState.length ; i++){
                            gameState[i] = 2;
                    }//FOR LOOP ENDS
                    ((ImageView)findViewById(R.id.imageView11)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView12)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView13)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView21)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView22)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView23)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView31)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView32)).setBackgroundResource(0);
                    ((ImageView)findViewById(R.id.imageView33)).setBackgroundResource(0);
            }//resetGame ENDS

        }//MAIN ACTIVITY ENDS

