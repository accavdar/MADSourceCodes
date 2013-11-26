package tr.edu.hacettepe.cs.bil422.lecture06.asynctask;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;

/**
 * User: accavdar
 * Date: 27/11/13
 */

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {

    private int position;
    private ImageView imageView;
    private Drawable placeholder;

    public DownloadTask(int position, ImageView imageView) {
        this.position = position;
        this.imageView = imageView;
        Resources resources = imageView.getContext().getResources();
        this.placeholder = resources.getDrawable(android.R.drawable.gallery_thumb);
    }

    @Override
    protected void onPreExecute() {
        imageView.setImageDrawable(placeholder);
    }

    @Override
    protected Bitmap doInBackground(String... inputUrls) {
        try {
            URL url = new URL(inputUrls[0]);
            return BitmapFactory.decodeStream(url.openStream());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        int forPosition = (Integer) imageView.getTag();
        if (forPosition == this.position) {
            this.imageView.setImageBitmap(result);
        }
    }
}
