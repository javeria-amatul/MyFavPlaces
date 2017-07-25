package com.example.android.myfavplaces;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Javeria on 7/23/2017.
 */

public class MarkerDataSource
{
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "loc.db";
    private static final String TABLE_COORD = "table_coordonnées";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_LATI = "Latitude";
    private static final int NUM_COL_LATI = 1;
    private static final String COL_LONGI = "Longitude";
    private static final int NUM_COL_LONGI = 2;


    private LocationsSQLHelper dbHelper;
    private SQLiteDatabase db;

    public MarkerDataSource(Context c) {
       dbHelper = new LocationsSQLHelper(c);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }


    public void addMarker(MapObj m){
        ContentValues values=new ContentValues();

        values.put(LocationsSQLHelper.FIELD_LAT, m.getMlat());
        values.put(LocationsSQLHelper.FIELD_LNG, m.getMlon());
        values.put(LocationsSQLHelper.FIELD_NAME, m.getMname());
        db.insert(dbHelper.TABLE_NAME, null, values );
    }
    public SQLiteDatabase getDb(){
        return db;
    }


}
