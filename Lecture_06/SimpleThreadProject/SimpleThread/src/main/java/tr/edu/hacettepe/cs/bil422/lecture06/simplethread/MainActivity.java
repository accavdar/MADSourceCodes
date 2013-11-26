package tr.edu.hacettepe.cs.bil422.lecture06.simplethread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView image = (ImageView) findViewById(R.id.image);
        final Button button = (Button) findViewById(R.id.button);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (image) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
                    image.notify();
                    image.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            }
        }).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synchronized (image) {
                    while (bitmap == null) {
                        try {
                            image.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    image.setImageBitmap(bitmap);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
