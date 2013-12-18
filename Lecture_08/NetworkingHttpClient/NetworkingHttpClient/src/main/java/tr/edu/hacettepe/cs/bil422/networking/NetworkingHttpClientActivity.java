package tr.edu.hacettepe.cs.bil422.networking;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.IOException;

public class NetworkingHttpClientActivity extends Activity {
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
            AndroidHttpClient client = AndroidHttpClient.newInstance("");
            HttpGet request = new HttpGet(params[0]);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                return client.execute(request, responseHandler);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            onFinishGetRequest(result);
        }
    }
}