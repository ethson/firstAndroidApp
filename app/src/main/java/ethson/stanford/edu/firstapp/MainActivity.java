//Ethson Villegas <ethson@stanford.edu>
//Simple Reaction Time Measure - only works once
//Extension ideas include making it randomly place 10 buttons



package ethson.stanford.edu.firstapp;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int width;
    private int height;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        width = this.getResources().getDisplayMetrics().widthPixels;
        height = this.getResources().getDisplayMetrics().heightPixels;
    }

    public void switchTurned(View view){
        Switch gameSwitch = (Switch) findViewById(R.id.switch1);
        TextView instructionsOne = (TextView) findViewById(R.id.instructions);
        TextView instructionsTwo = (TextView) findViewById(R.id.instructions2);
        Button button1 = (Button) findViewById(R.id.button);
        gameSwitch.setVisibility(View.GONE);
        instructionsOne.setVisibility(View.GONE);
        instructionsTwo.setVisibility(View.GONE);
        button1.setVisibility(View.VISIBLE);
        startTime = System.currentTimeMillis();
    }

    public void measureTime(View view){
        long elapsedTime = System.currentTimeMillis() - startTime;
        Button button1 = (Button) findViewById(R.id.button);
        button1.setVisibility(View.GONE);
        TextView resultsText = (TextView) findViewById(R.id.results);
        resultsText.setTypeface(Typeface.DEFAULT_BOLD);
        resultsText.setText("Your reaction time is: " + String.valueOf(elapsedTime) + " in miliseconds. Needs work");
    }

}
