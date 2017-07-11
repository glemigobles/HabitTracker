package com.example.jsura.habittracker;


import android.provider.BaseColumns;

public final class HabitContract {

    public class HabitEntry implements BaseColumns{

        public static final String TABLE_NAME="habits";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_DURATION="duration";
        public static final String COLUMN_FREQUENCY="frequency";

        public static final int DURATION_LESS_THAN_HOUR=0;
        public static final int DURATION_MORE_THAN_HOUR=1;

        public static final int FREQUENCY_ONCE_PER_WEEK=0;
        public static final int FREQUENCY_FEW_PER_WEEK=1;
        public static final int FREQUENCY_EVERYDAY=2;


    }
}
