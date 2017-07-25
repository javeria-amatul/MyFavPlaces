package com.example.android.myfavplaces;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.R.attr.id;
import static android.R.attr.version;

/**
 * Created by Javeria on 7/23/2017.
 */

public class LocationsSQLHelper extends SQLiteOpenHelper {

    private SQLiteDatabase mDB;
    public static final String DATABASE_NAME = "MyDBName.db";
    private static final int D_VERSION=1;
    public static final String TABLE_NAME="locations";

     static final String FIELD_ROW_ID="loc_id";
     static final String FIELD_LAT="loc_lat";
    static final String FIELD_LNG="loc_lng";
     static final String FIELD_NAME="loc_name";

    private static final String DB_CREATE="create table "+TABLE_NAME+ "("
                            +FIELD_ROW_ID + " integer primary key autoincrement, "
                            +FIELD_LAT + " real , "
                            +FIELD_LNG + " real ,"
                            +FIELD_NAME + " text"
                            +");"
                    ;


        public LocationsSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, D_VERSION);

        }

    @Override
        public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public void addLatLng(MapObj mapObj ){
        ContentValues values=new ContentValues();
        values.put(FIELD_LAT, mapObj.getMlat());
        values.put(FIELD_LNG, mapObj.getMlon());
        values.put(FIELD_NAME, mapObj.getMname());
        SQLiteDatabase db=getReadableDatabase();
        db.insert(DATABASE_NAME, null, values);
        db.close();
    }

    public List<MapObj> allLocations(){
        List<MapObj> locationList=new ArrayList<MapObj>();
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME + "WHERE 1";

        //Cursor point to loaction to results

        Cursor c = db.rawQuery(query,null);
        //Move to first row in query
        if(c.moveToFirst()){
            do{
                MapObj mapObj=new MapObj();
                mapObj.setMid(Integer.parseInt(c.toString()));
                mapObj.getMlat();
            }
            while (c.moveToNext());
        }


        return locationList;
    }

}
