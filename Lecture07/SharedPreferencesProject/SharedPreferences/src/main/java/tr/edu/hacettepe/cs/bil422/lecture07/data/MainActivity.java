package tr.edu.hacettepe.cs.bil422.lecture07.data;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    private static String HIGH_SCORE = "high_score";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        setContentView(R.layout.main);

        final TextView highScoreText = (TextView) findViewById(R.id.highScoreTextView);
        highScoreText.setText(String.valueOf(prefs.getInt(HIGH_SCORE, 0)));
        final TextView playText = (TextView) findViewById(R.id.textView2);

        final Button go = (Button) findViewById(R.id.button1);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int val = r.nextInt(1000);
                playText.setText(String.valueOf(val));
                if (val > prefs.getInt(HIGH_SCORE, 0)) {
                    highScoreText.setText(String.valueOf(val));
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt(HIGH_SCORE, val);
                    editor.commit();
                }
            }
        });
    }
}
