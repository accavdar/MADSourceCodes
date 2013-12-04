package tr.edu.hacettepe.cs.bil422.lecture07.sqlite;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    final static String TABLE_NAME = "artists";
    final static String ARTIST_NAME = "name";
    final static String _ID = "_id";
    final static String[] columns = {_ID, ARTIST_NAME};

    private SQLiteDatabase db = null;
    private DatabaseOpenHelper dbHelper = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new DatabaseOpenHelper(this);
        db = dbHelper.getWritableDatabase();

        // start with an empty database
        clearAll();

        insertArtists();

        deleteLadyGaga();

        updateJohnnyCash();

        Cursor c = readArtists();
        setListAdapter(new SimpleCursorAdapter(this, R.layout.list_layout, c,
                columns, new int[]{R.id._id, R.id.name}, 0));

    }

    private void insertArtists() {
        ContentValues values = new ContentValues();

        values.put(ARTIST_NAME, "Frank Sinatra");
        db.insert(TABLE_NAME, null, values);

        values.clear();

        values.put(ARTIST_NAME, "Lady Gaga");
        db.insert(TABLE_NAME, null, values);

        values.clear();

        values.put(ARTIST_NAME, "Jawny Cash");
        db.insert(TABLE_NAME, null, values);

        values.clear();

        values.put(ARTIST_NAME, "Ludwig von Beethoven");
        db.insert(TABLE_NAME, null, values);
    }

    private Cursor readArtists() {
        return db.query(TABLE_NAME, columns, null, new String[]{}, null, null,
                null);
    }

    private int deleteLadyGaga() {
        return db.delete(TABLE_NAME, ARTIST_NAME + "=?",
                new String[]{"Lady Gaga"});
    }

    private int updateJohnnyCash() {
        ContentValues values = new ContentValues();
        values.put(ARTIST_NAME, "Johnny Cash");
        return db.update(TABLE_NAME, values, ARTIST_NAME + "=?",
                new String[]{"Jawny Cash"});
    }

    private void clearAll() {
        db.delete(TABLE_NAME, null, null);
    }

    @Override
    protected void onDestroy() {
        db.close();
        dbHelper.deleteDatabase();
        super.onDestroy();
    }
}
