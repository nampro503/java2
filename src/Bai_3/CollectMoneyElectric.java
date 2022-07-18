/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_3;

/**
 *
 * @author Tuan
 */
public class CollectMoneyElectric implements CollectMoney{
    
    double chiSoDau;
    double chiSoCuoi;
    final int donGia = 2500;

    public CollectMoneyElectric() {
        chiSoDau = 0;
        chiSoCuoi = 0;
    }

    public CollectMoneyElectric(double chiSoDau, double chiSoCuoi) {
        this.chiSoDau = chiSoDau;
        this.chiSoCuoi = chiSoCuoi;
    }

    public void setChiSoDau(double chiSoDau) {
        this.chiSoDau = chiSoDau;
    }

    public void setChiSoCuoi(double chiSoCuoi) {
        this.chiSoCuoi = chiSoCuoi;
    }

    public double getChiSoDau() {
        return chiSoDau;
    }

    public double getChiSoCuoi() {
        return chiSoCuoi;
    }

    public int getDonGia() {
        return donGia;
    }
    

    @Override
    public double calculateMoney() {
        double soTieuThu = this.chiSoCuoi - this.chiSoDau;
        if(soTieuThu < 100) return soTieuThu*donGia;
        else if(soTieuThu >= 100 && soTieuThu < 300) return soTieuThu*donGia*1.05;
        else return soTieuThu*donGia*1.1;
    }

    
}
