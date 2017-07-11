package com.example.jsura.habittracker;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jsura.habittracker.HabitContract.HabitEntry;

public class MainActivity extends AppCompatActivity {

    HabitDBHelper mDbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDBHelper(this);
        insertHabit();
        readHabitDatabase();
        displayDatabaseInfo();
    }

    private void insertHabit() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put(HabitEntry.COLUMN_NAME, "Walking on water");
        data.put(HabitEntry.COLUMN_DURATION, 1);

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, data);
    }

    public Cursor readHabitDatabase() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_NAME,
                HabitEntry.COLUMN_DURATION,
        };

        return db.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + HabitEntry.TABLE_NAME, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).

            TextView text = (TextView) this.findViewById(R.id.infoText);
            text.setText("Number of rows in habit db table: " + cursor.getCount());

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
}
