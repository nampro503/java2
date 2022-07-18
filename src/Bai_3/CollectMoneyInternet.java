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
public class CollectMoneyInternet implements CollectMoney{
    
    int soThang;
    final int donGia = 285000;

    public CollectMoneyInternet() {
    }

    public CollectMoneyInternet(int soThang) {
        this.soThang = soThang;
    }

    public void setSoThang(int soThang) {
        this.soThang = soThang;
    }

    public int getSoThang() {
        return soThang;
    }

    public int getDonGia() {
        return donGia;
    }
    

    @Override
    public double calculateMoney() {
        if(soThang < 3) return soThang*donGia;
        else if(soThang >= 3 && soThang < 6) return soThang*donGia*0.95;
        else return soThang*donGia*0.9;
    }
    
}
