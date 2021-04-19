package com.example.assignment9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.sql.SQLInput;
import java.util.ArrayList;



// This essentially is our API to call to save to the SQLite table
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
//        I am calling our database JobsDatabase.db
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
//        Creating table for the User
        String statement = "create Table User(name TEXT, age INTEGER, ownsCat BOOLEAN) "
        DB.execSQL(statement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        //This is called when the database needs to be upgraded to a new schema.
        // I doubt this will be used, but it is required, so I have logic to drop the table
        DB.execSQL("drop Table if exists User");
    }

    // This is an example of how to insert into the database. Returns false if unsuccessful
    public Boolean addRow(String name, int age, boolean ownsCat){
        // Use the ContentValues class to store job details
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("ownsCat", ownsCat);

        long result = DB.insert("User", null, contentValues);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }


    public ArrayList<User> getWeights(){
        ArrayList<User> returnList = new ArrayList<User>();
        String queryString = "SELECT * FROM User";
        SQLiteDatabase db = this.getReadableDatabase();

        // use selection args instead of null for parameterizing the query
        Cursor c = db.rawQuery(queryString, null);

        if (c.moveToFirst()){
            // loop through the cursor and create new Job objects. Put them in the return list
            do{
                String name = c.getString(0);
                int age = c.getInt(1);
                int ownsCats = c.getInt(2);


                User u = new User(name,age,ownsCats);
                returnList.add(u);

            }while(c.moveToNext());
        }else{
            // failure. do not add anything
        }
        // close the cursor and the database connection
        c.close();
        db.close();

        return returnList;

    }

}
