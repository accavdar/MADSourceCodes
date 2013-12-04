package tr.edu.hacettepe.cs.bil422.lecture07.data;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        String fileName = "TestFile.txt";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout1);

        try {
            FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(fos)));
            pw.println("This is a test of the File Writing API");
            pw.println("This is a test of the File Writing API");
            pw.println("This is a test of the File Writing API");
            pw.close();

            FileInputStream fis = openFileInput(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while (null != (line = br.readLine())) {
                TextView tv = new TextView(this);
                tv.setText(line);
                ll.addView(tv);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
