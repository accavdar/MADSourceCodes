package tr.edu.hacettepe.cs.bil422.lecture04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity2 extends LifecycleActivity {

    private Button activity3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        activity3 = (Button) findViewById(R.id.activity3Button);
        activity3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, Activity3.class));
            }
        });
    }
}