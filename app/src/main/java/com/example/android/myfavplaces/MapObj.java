package com.example.android.myfavplaces;

import static android.R.attr.id;

/**
 * Created by Javeria on 7/25/2017.
 */

public class MapObj {

    private  int mid;
    private Double mlat;
    private Double mlon;
    private String mname;

    public MapObj(){

    }

    public MapObj(int id, double lat, double lon, String name){
        this.setMid(id);
        this.setMlat(lat);
        this.setMlon(lon);
        this.setMname(name);
    }
    public MapObj( double lat, double lon, String name){

        this.setMlat(lat);
        this.setMlon(lon);
        this.setMname(name);
    }
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Double getMlat() {
        return mlat;
    }

    public void setMlat(Double mlat) {
        this.mlat = mlat;
    }

    public Double getMlon() {
        return mlon;
    }

    public void setMlon(Double mlon) {
        this.mlon = mlon;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
