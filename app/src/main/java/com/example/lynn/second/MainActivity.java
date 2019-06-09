package com.example.lynn.second;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static MyDatabaseHelper myDatabaseHelper;
    public static SQLiteDatabase database;
    public static MyView myView;
    public static MyListener listener = new MyListener();

    public static String getWord() {
        java.util.List<String> words = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM statearea;",new String[]{});

        cursor.moveToFirst();

        do {
            int wordIndex = cursor.getColumnIndex("word");

            String word = cursor.getString(wordIndex);

            words.add(word);
        } while (cursor.moveToNext());

        return(words.get((int)(words.size()*Math.random())));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDatabaseHelper = new MyDatabaseHelper(this);

        database = myDatabaseHelper.getReadableDatabase();




        setContentView(R.layout.activity_main);
    }
}
