package com.example.googleeb.td1.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import static com.example.googleeb.td1.Data.PersonneContract.PersonneTable.*;


/**
 * Created by googleeb on 3/14/18.
 */

public class Db extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_personnes";
    private static final int DB_VERSION = 1;

    private static Db db;


    private static final String createTable = "CREATE tABLE "+NAME+
            "("+COLUMN_ID+"INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_FIRST_NAME+" TEXT NOT NULL, "+
            COLUMN_LAST_NAME+" TEXT, "+
            COLUMN_AGE+" INTEGER NOT NULL)";

    private static final String dropTable = "DROP TABLE IF EXISTS"+NAME;


    // TODO init befor all fragment
    public Db(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.db = this;
    }


    public static long insertNewCV(String nameTable, ContentValues contentValues){
        if(db == null) Log.e("ERROR", "db is NULL");
        else{
            SQLiteDatabase write = db.getWritableDatabase();
            return write.insert(nameTable, null, contentValues);
        }
        return 0;
    }

    public static Cursor getAll(String tableName, String[] columns){
        return db.getReadableDatabase().query(tableName, columns, null, null, null, null, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropTable);
        onCreate(db);
    }



}
