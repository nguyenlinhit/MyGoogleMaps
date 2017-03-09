package com.nguyenlinh.android.mygooglemaps.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.nguyenlinh.android.mygooglemaps.model.Clothes;
import com.nguyenlinh.android.mygooglemaps.model.Coffee;
import com.nguyenlinh.android.mygooglemaps.model.GasStation;
import com.nguyenlinh.android.mygooglemaps.model.Hotel;
import com.nguyenlinh.android.mygooglemaps.model.Market;
import com.nguyenlinh.android.mygooglemaps.model.Restaurant;
import com.nguyenlinh.android.mygooglemaps.model.SmartPhone;

import java.util.ArrayList;

/**
 * Created by nguye on 3/8/2017.
 * Datasource
 */

public class SQLDatasource {
    private DatabaseCoppy db;

    public SQLDatasource(){

    }

    public SQLDatasource(Context context){
        db = new DatabaseCoppy(context);
        db.xuLySaoChepCSDL();
    }

    public ArrayList<Hotel> showAllHotel(){
        ArrayList<Hotel> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from Hotel",null);
        while (cursor.moveToNext()){
            Hotel khachSan = new Hotel();
            khachSan.setMa(cursor.getInt(0));
            khachSan.setTen(cursor.getString(1));
            khachSan.setKinhdo(cursor.getDouble(2));
            khachSan.setVido(cursor.getDouble(3));
            list.add(khachSan);
        }
        cursor.close();
        return list;
    }

    public ArrayList<Restaurant> showAllRetaurant(){
        ArrayList<Restaurant> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from Restaurant",null);
        while (cursor.moveToNext()){
            Restaurant restaurant = new Restaurant();
            restaurant.setMa(cursor.getInt(0));
            restaurant.setTen(cursor.getString(1));
            restaurant.setVido(cursor.getDouble(2));
            restaurant.setKinhdo(cursor.getDouble(3));
            list.add(restaurant);
        }
        cursor.close();
        return list;
    }

    public ArrayList<Market> showAllMarket(){
        ArrayList<Market> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from Market",null);
        while (cursor.moveToNext()){
            Market market = new Market();
            market.setMa(cursor.getInt(0));
            market.setTen(cursor.getString(1));
            market.setVido(cursor.getDouble(2));
            market.setKinhdo(cursor.getDouble(3));
            list.add(market);
        }
        cursor.close();
        return list;
    }

    public ArrayList<SmartPhone> showAllPhone(){
        ArrayList<SmartPhone> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from ShopDienThoai",null);
        while (cursor.moveToNext()){
            SmartPhone smartPhone = new SmartPhone();
            smartPhone.setMa(cursor.getInt(0));
            smartPhone.setTen(cursor.getString(1));
            smartPhone.setVido(cursor.getDouble(2));
            smartPhone.setKinhdo(cursor.getDouble(3));
            list.add(smartPhone);
        }
        cursor.close();
        return list;
    }

    public ArrayList<Clothes> showAllClothes(){
        ArrayList<Clothes> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from ShopQuanAo",null);
        while (cursor.moveToNext()){
            Clothes clothes = new Clothes();
            clothes.setMa(cursor.getInt(0));
            clothes.setTen(cursor.getString(1));
            clothes.setVido(cursor.getDouble(2));
            clothes.setKinhdo(cursor.getDouble(3));
            list.add(clothes);
        }
        cursor.close();
        return list;
    }

    public ArrayList<Coffee> showAllCoffee(){
        ArrayList<Coffee> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from Coffee",null);
        while (cursor.moveToNext()){
            Coffee coffee = new Coffee();
            coffee.setMa(cursor.getInt(0));
            coffee.setTen(cursor.getString(1));
            coffee.setVido(cursor.getDouble(2));
            coffee.setKinhdo(cursor.getDouble(3));
            list.add(coffee);
        }
        cursor.close();
        return list;
    }

    public ArrayList<GasStation> showAllGas(){
        ArrayList<GasStation> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from GasStation",null);
        while (cursor.moveToNext()){
            GasStation gasStation = new GasStation();
            gasStation.setMa(cursor.getInt(0));
            gasStation.setTen(cursor.getString(1));
            gasStation.setVido(cursor.getDouble(2));
            gasStation.setKinhdo(cursor.getDouble(3));
            list.add(gasStation);
        }
        cursor.close();
        return list;
    }
}