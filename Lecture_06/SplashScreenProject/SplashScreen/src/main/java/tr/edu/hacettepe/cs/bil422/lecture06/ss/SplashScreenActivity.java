package tr.edu.hacettepe.cs.bil422.lecture06.ss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {

    public static final int SPLASH_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ss);

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                proceed();
            }
        }, SPLASH_TIMEOUT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            proceed();
        }

        return super.onTouchEvent(event);
    }

    private void proceed() {
        if (this.isFinishing()) {
            return;
        }

        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        finish();
    }
}
