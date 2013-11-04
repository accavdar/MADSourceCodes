package tr.edu.hacettepe.cs.bil422.lecture04;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * User: accavdar
 * Date: 04/11/13
 */

public class Activity1 extends LifecycleActivity {

    private Button finish;
    private Button activity2;
    private Chronometer chrono;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        finish = (Button) findViewById(R.id.finishButton);
        finish.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        activity2 = (Button) findViewById(R.id.activity2Button);
        activity2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Activity1.this, Activity2.class));
            }
        });
        chrono = (Chronometer) findViewById(R.id.chronometer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.start();
    }

    @Override
    protected void onPause() {
        chrono.stop();
        super.onPause();
    }
}