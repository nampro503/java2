/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_4.Models;

/**
 *
 * @author Tuan
 */
public class DiaCD {
    String tenCD;
    String caSy;
    int soBaiHat;
    double gia;

    public DiaCD() {
    }

    public DiaCD(String tenCD, String caSy, int soBaiHat, double gia) {
        this.tenCD = tenCD;
        this.caSy = caSy;
        this.soBaiHat = soBaiHat;
        this.gia = gia;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTenCD() {
        return tenCD;
    }

    public String getCaSy() {
        return caSy;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public double getGia() {
        return gia;
    }
    
    
}
