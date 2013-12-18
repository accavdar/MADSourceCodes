package tr.edu.hacettepe.cs.bil422.networking;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingURLActivity extends Activity {
    TextView mTextView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTextView = (TextView) findViewById(R.id.textView1);
        new HttpGetTask()
                .execute("http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo");
    }

    private void onFinishGetRequest(String result) {
        mTextView.setText(result);
    }

    private class HttpGetTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            StringBuffer data = new StringBuffer();
            BufferedReader br = null;

            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(params[0]).openConnection();
                br = new BufferedReader(new InputStreamReader(
                        conn.getInputStream()));
                String rawData;
                while ((rawData = br.readLine()) != null) {
                    data.append(rawData);
                }
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (br != null)
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            return data.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            onFinishGetRequest(result);
        }
    }
}