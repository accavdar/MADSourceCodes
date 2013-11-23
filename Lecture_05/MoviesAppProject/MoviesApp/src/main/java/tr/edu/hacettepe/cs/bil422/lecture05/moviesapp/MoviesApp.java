package tr.edu.hacettepe.cs.bil422.lecture05.moviesapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: accavdar
 * Date: 14/11/13
 */

public class MoviesApp extends ListActivity {

    private static final String SEPERATOR = ":";

    private MovieAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        ListView listView = getListView();

        Button backToTop =
                (Button) getLayoutInflater().inflate(R.layout.list_footer, null);
        backToTop.setCompoundDrawablesWithIntrinsicBounds(getResources()
                .getDrawable(android.R.drawable.ic_menu_upload), null, null,
                null);
        listView.addFooterView(backToTop, null, true);

        this.adapter = new MovieAdapter(this, R.layout.movie_item, getMovies());
        listView.setAdapter(this.adapter);
        listView.setItemsCanFocus(false);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        this.adapter.toggleMovie(position);
        this.adapter.notifyDataSetChanged();
    }

    public void backToTop(View view) {
        getListView().setSelection(0);
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        String[] movieNames = getResources().getStringArray(R.array.movies);
        for (String name : movieNames) {
            movies.add(getMovie(name));
        }

        return movies;
    }

    private Movie getMovie(String name) {
        String[] parts = name.split(SEPERATOR);
        return new Movie(parts[0], Integer.valueOf(parts[1]));
    }
}