package com.nguyenlinh.android.mygooglemaps.model;

import java.io.Serializable;

/**
 * Created by nguye on 2/22/2017.
 */

public class Hotel implements Serializable {


        private int ma;
        private String ten;
        private double kinhdo;
        private double vido;

    public Hotel(int ma, String ten, double kinhdo, double vido) {
        this.ma = ma;
        this.ten = ten;
        this.kinhdo = kinhdo;
        this.vido = vido;
    }

    public Hotel() {
        }

        public Hotel(String ten, double kinhdo, double vido) {
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
