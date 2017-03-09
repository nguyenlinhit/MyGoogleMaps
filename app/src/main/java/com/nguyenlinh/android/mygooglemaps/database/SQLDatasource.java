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
            khachSan.setVido(cursor.getDouble(2));
            khachSan.setKinhdo(cursor.getDouble(3));
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

    public ArrayList<Restaurant> showAllRetaurant_Ma(int ma){
        ArrayList<Restaurant> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from Restaurant where manhahang = " + ma,null);
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

    public ArrayList<Hotel> showAllHotel_Ma(int ma){
        ArrayList<Hotel> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from Hotel where mahotel = " + ma,null);
        while (cursor.moveToNext()){
            Hotel khachSan = new Hotel();
            khachSan.setMa(cursor.getInt(0));
            khachSan.setTen(cursor.getString(1));
            khachSan.setVido(cursor.getDouble(2));
            khachSan.setKinhdo(cursor.getDouble(3));
            list.add(khachSan);
        }
        cursor.close();
        return list;
    }

    public ArrayList<Market> showAllMarket_Ma(int ma){
        ArrayList<Market> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from Market where macho = " + ma,null);
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

    public ArrayList<SmartPhone> showAllPhone_Ma(int ma){
        ArrayList<SmartPhone> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from ShopDienThoai where madt = " + ma,null);
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

    public ArrayList<Clothes> showAllClothes_Ma(int ma){
        ArrayList<Clothes> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from ShopQuanAo where maqa = " + ma,null);
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

    public ArrayList<Coffee> showAllCoffee_Ma(int ma){
        ArrayList<Coffee> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from Coffee where macf = " + ma,null);
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

    public ArrayList<GasStation> showAllGas_Ma(int ma){
        ArrayList<GasStation> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from GasStation where macx = " + ma,null);
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

    public ArrayList<Restaurant> showAllRetaurant_Ten(String ten){
        ArrayList<Restaurant> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from Restaurant where tennhahang LIKE '%" + ten.toLowerCase() +"%'" ,null);
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

    public ArrayList<Hotel> showAllHotel_Ten(String ten){
        ArrayList<Hotel> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.nguyenlinh.android.mygooglemaps.app/databases/DiaDiemDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("select * from Hotel where tenhotel LIKE '%" + ten.toLowerCase() +"%'",null);
        while (cursor.moveToNext()){
            Hotel khachSan = new Hotel();
            khachSan.setMa(cursor.getInt(0));
            khachSan.setTen(cursor.getString(1));
            khachSan.setVido(cursor.getDouble(2));
            khachSan.setKinhdo(cursor.getDouble(3));
            list.add(khachSan);
        }
        cursor.close();
        return list;
    }
}
