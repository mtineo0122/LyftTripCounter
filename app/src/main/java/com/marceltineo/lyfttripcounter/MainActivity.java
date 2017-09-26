package com.marceltineo.lyfttripcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterTxt;
    private Button minusBtn;
    private Button resetBtn;
    private Button plusBtm;
    private int counter;
    private Button bt;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.minusBtn:
                    minusCounter();
                    break;
                case R.id.resetBtn:
                    initcounter();
                    break;
                case R.id.plusBtn:
                    plusCounter();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTxt = (TextView) findViewById(R.id.counterTxt);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(clickListener);
        plusBtm = (Button) findViewById(R.id.plusBtn);
        plusBtm.setOnClickListener(clickListener);

        initcounter();

        bt = (Button) findViewById(R.id.share);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Hola!" + "\n" + "Me faltan " + counter + " viajes";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });
    }

    private void initcounter() {
        counter = 20;
        counterTxt.setText(counter + "");
    }

    private void minusCounter() {
        counter--;
        counterTxt.setText(counter + "");
    }

    private void plusCounter() {
        counter++;
        counterTxt.setText(counter + "");
    }
}
