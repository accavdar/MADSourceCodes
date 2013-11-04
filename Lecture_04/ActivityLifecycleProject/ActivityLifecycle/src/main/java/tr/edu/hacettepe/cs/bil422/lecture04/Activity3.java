package tr.edu.hacettepe.cs.bil422.lecture04;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class Activity3 extends LifecycleActivity {

    private static final String COUNT_KEY = "cKey";

    private TextView numberOfResumes;
    private int count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        numberOfResumes = (TextView) findViewById(R.id.numResumes);
    }

    @Override
    protected void onResume() {
        super.onResume();

        numberOfResumes.setText(String.valueOf(count));
        count++;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if ((savedInstanceState != null) && savedInstanceState.containsKey(COUNT_KEY)) {
            count = savedInstanceState.getInt(COUNT_KEY);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(COUNT_KEY, count);
        super.onSaveInstanceState(outState);
    }
}