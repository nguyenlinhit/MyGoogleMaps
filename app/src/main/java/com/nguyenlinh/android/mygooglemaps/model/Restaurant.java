package com.nguyenlinh.android.mygooglemaps.model;

/**
 * Created by nguye on 3/9/2017.
 * Restaurant
 */

public class Restaurant {
    private int ma;
    private String ten;
    private double kinhdo;
    private double vido;

    public Restaurant() {
    }

    public Restaurant(int ma, String ten, double kinhdo, double vido) {
        this.ma = ma;
        this.ten = ten;
        this.kinhdo = kinhdo;
        this.vido = vido;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getKinhdo() {
        return kinhdo;
    }

    public void setKinhdo(double kinhdo) {
        this.kinhdo = kinhdo;
    }

    public double getVido() {
        return vido;
    }

    public void setVido(double vido) {
        this.vido = vido;
    }
}
