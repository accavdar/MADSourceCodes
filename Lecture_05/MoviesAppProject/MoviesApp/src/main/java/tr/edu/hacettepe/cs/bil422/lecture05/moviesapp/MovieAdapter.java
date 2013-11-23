package tr.edu.hacettepe.cs.bil422.lecture05.moviesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.List;

/**
 * User: accavdar
 * Date: 14/11/13
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

        if (convertView == null) {
            convertView = layoutInflater.inflate(resourceId, parent, false);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (holder != null) {
            name = holder.name;
            year = holder.year;
        } else {
            name = (CheckedTextView) convertView.findViewById(R.id.name);
            year = (TextView) convertView.findViewById(R.id.year);

            holder = new ViewHolder(name, year);
            convertView.setTag(holder);
        }

        Movie movie = getItem(position);

        name.setChecked(movie.isWatched());
        name.setText(movie.getName());
        year.setText(String.valueOf(movie.getYear()));

        return convertView;
    }

    public void toggleMovie(int position) {
        Movie movie = getItem(position);
        movie.setWatched(!movie.isWatched());
    }

    private class ViewHolder {

        protected final CheckedTextView name;

        protected final TextView year;

        public ViewHolder(CheckedTextView name, TextView year) {
            this.name = name;
            this.year = year;
        }
    }
}
