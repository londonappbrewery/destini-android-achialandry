package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.londonappbrewery.destini.R.string.T1_Ans1;
import static com.londonappbrewery.destini.R.string.T1_Ans2;
import static com.londonappbrewery.destini.R.string.T1_Story;
import static com.londonappbrewery.destini.R.string.T2_Ans1;
import static com.londonappbrewery.destini.R.string.T2_Ans2;
import static com.londonappbrewery.destini.R.string.T2_Story;
import static com.londonappbrewery.destini.R.string.T3_Ans1;
import static com.londonappbrewery.destini.R.string.T3_Ans2;
import static com.londonappbrewery.destini.R.string.T3_Story;
import static com.londonappbrewery.destini.R.string.T4_End;
import static com.londonappbrewery.destini.R.string.T5_End;
import static com.londonappbrewery.destini.R.string.T6_End;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryText;
    Button mButtonTop, mButtonDown;

    int mStoryIndex = 1;
    int buttonPressed = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To check saved app info prior to rotation
        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("mStoryIndexKey");
        }else{
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = (TextView)findViewById(R.id.storyTextView);
        mButtonTop = (Button)findViewById(R.id.buttonTop);
        mButtonDown = (Button)findViewById(R.id.buttonBottom);
        story();



        //Create a Listener
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 1;
                updateStory();

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 2;
                updateStory();

            }
        });



    }

    //function updates story based on user selection
    private void updateStory(){
//
        if(mStoryIndex == 1 ){
           if(buttonPressed==1){
               mStoryIndex=3;
           }else if (buttonPressed==2){
               mStoryIndex =2;
           }
        }else if(mStoryIndex ==2){
            if(buttonPressed==1){
                mStoryIndex=3;
            }else if(buttonPressed==2){
                mStoryIndex=4;
            }

        }else if(mStoryIndex ==3) {
            if (buttonPressed == 1) {
                mStoryIndex = 5;
            } else if (buttonPressed == 2) {
                mStoryIndex = 6;
            }
        }
        story();

    }

    //function for story based on user selection
    private void story(){

        if(mStoryIndex == 1 ){
            mStoryText.setText(T1_Story);
            mButtonTop.setText((T1_Ans1));
            mButtonDown.setText(T1_Ans2);
        }else if(mStoryIndex ==2){
            mStoryText.setText(T2_Story);
            mButtonTop.setText(T2_Ans1);
            mButtonDown.setText(T2_Ans2);
        }else if(mStoryIndex ==3){
            mStoryText.setText(T3_Story);
            mButtonTop.setText(T3_Ans1);
            mButtonDown.setText(T3_Ans2);
        }else if(mStoryIndex==4){
            mStoryText.setText(T4_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonDown.setVisibility(View.GONE);
        }else if(mStoryIndex==5){
            mStoryText.setText(T5_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonDown.setVisibility(View.GONE);
        }else if(mStoryIndex==6){
            mStoryText.setText(T6_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonDown.setVisibility(View.GONE);
        }
    }

    //a key story update so incase outstate or a rotation, we save track of game
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("mStoryIndexKey", mStoryIndex);
    }

}
