package com.mobileproto.lab2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evan on 9/15/13.
 */
public class NoteDetailActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        Intent intent = getIntent();

        String fileName = intent.getStringExtra("file");
        TextView title = (TextView) findViewById(R.id.noteTitle);
        TextView noteText = (TextView) findViewById(R.id.noteText);

        final DatabaseHelper DbHelper = new DatabaseHelper(this);
        title.setText(fileName);

        SQLiteDatabase db = DbHelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM NOTES WHERE " + DatabaseHelper.COLUMN_TITLE + " LIKE "+ "'"+fileName +"';", null);
        Log.d("Lyra", "I made the cursor");
        List<String> listContents = new ArrayList<String>();
        List<String> listNames = new ArrayList<String>();

        c.moveToFirst();
        while (!c.isAfterLast()) {
            String itemContent = c.getString(
                    c.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CONTENT));
            String itemName = c.getString(
                    c.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TITLE)
            );
            listContents.add(itemContent);
            listNames.add(itemName);
            c.moveToNext();

        }
        // Make sure to close the cursor
        c.close();
        String listContent = listContents.get(0);
        String listName = listNames.get(0);


        Log.d("Lyra", listContent);
        Log.d("Lyra", listName);
        noteText.setText(listContent);




        /*try{
            FileInputStream fis = openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                fileText.append(line);
                fileText.append('\n');
            }

        }catch (IOException e){
            Log.e("IOException", e.getMessage());
        }*/



    }
}
