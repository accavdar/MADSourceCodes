package tr.edu.hacettepe.cs.bil422.lecture04;

import android.app.Activity;
import android.app.Notification;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Random;

/**
 * User: accavdar
 * Date: 04/11/13
 */

public abstract class LifecycleActivity extends Activity {

    private final String className;

    public LifecycleActivity() {
        super();
        this.className = this.getClass().getSimpleName();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        debugEvent("onCreate");
    }

    @Override
    protected void onStart() {
        debugEvent("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        debugEvent("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        debugEvent("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        debugEvent("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        debugEvent("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        debugEvent("onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        debugEvent("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        debugEvent("onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean isFinishing() {
        debugEvent("isFinishing");
        return super.isFinishing();
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void onLowMemory() {
        Toast.makeText(this, "onLowMemory", Toast.LENGTH_SHORT).show();
        super.onLowMemory();
    }

    private void debugEvent(final String method) {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(className)
                .setContentText(method + " is called");

        ((LifecycleApplication) getApplication())
                .getNotificationManager()
                .notify(new Random(System.currentTimeMillis()).nextInt(), builder.build());
    }
}