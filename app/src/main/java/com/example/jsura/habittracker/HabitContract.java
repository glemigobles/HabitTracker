package com.example.jsura.habittracker;


import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract() {
    }

    public final static class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_DURATION = "duration";
    }
}
