package tr.edu.hacettepe.cs.bil422.lecture06.asynctask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tr.edu.hacettepe.cs.bil422.lecture05.moviesapp.R;

/**
 * User: accavdar
 * Date: 27/11/13
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    private final int resourceId;

    private final LayoutInflater layoutInflater;

    public MovieAdapter(Context context, int resourceId, List<Movie> movies) {
        super(context, resourceId, movies);

        this.resourceId = resourceId;
        this.layoutInflater = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CheckedTextView name;
        TextView year;
        ImageView thumb;

        Movie movie = getItem(position);

        if (convertView == null) {
            convertView = layoutInflater.inflate(resourceId, parent, false);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (holder != null) {
            name = holder.name;
            year = holder.year;
            thumb = holder.thumb;
        } else {
            name = (CheckedTextView) convertView.findViewById(R.id.name);
            year = (TextView) convertView.findViewById(R.id.year);
            thumb = (ImageView) convertView.findViewById(R.id.thumbnail);
            thumb.setTag(position);

            holder = new ViewHolder(name, year, thumb);
            convertView.setTag(holder);

            new DownloadTask(position, thumb).execute(movie.getThumbnail());
        }

        name.setChecked(movie.isWatched());
        name.setText(movie.getName());
        year.setText(String.valueOf(movie.getYear()));

        if (position != (Integer) thumb.getTag()) {
            thumb.setTag(position);
            new DownloadTask(position, thumb).execute(movie.getThumbnail());
        }

        return convertView;
    }

    public void toggleMovie(int position) {
        Movie movie = getItem(position);
        movie.setWatched(!movie.isWatched());
    }

    private class ViewHolder {

        protected final CheckedTextView name;

        protected final TextView year;

        protected final ImageView thumb;

        public ViewHolder(CheckedTextView name, TextView year, ImageView thumb) {
            this.name = name;
            this.year = year;
            this.thumb = thumb;
        }
    }
}
