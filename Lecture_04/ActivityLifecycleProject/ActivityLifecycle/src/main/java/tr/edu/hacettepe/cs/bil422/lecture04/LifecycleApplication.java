package tr.edu.hacettepe.cs.bil422.lecture04;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;

/**
 * User: accavdar
 * Date: 04/11/13
 */

public class LifecycleApplication extends Application {
    private NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize notification manager
        notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public NotificationManager getNotificationManager() {
        return notificationManager;
    }
}
