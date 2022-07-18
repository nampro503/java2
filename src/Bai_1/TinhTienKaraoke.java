/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.util.Scanner;

/**
 *
 * @author Tuan
 */
public class TinhTienKaraoke {
    public static double tinhTien(int gioBatDau, int gioKetThuc){
        int thoiGian = gioKetThuc - gioBatDau;
        if(thoiGian <= 1) return thoiGian * 60000;
        else if(thoiGian > 1 && thoiGian <= 3) return 60000 + (thoiGian - 1) * 0.8*60000;
        else{
            return 60000 + 2 * 0.8 * 60000 + (thoiGian - 3)*0.7*60000;
        }
    }
    public static void main(String[] args) {
        int gioBatDau, gioKetThuc;
        
        System.out.println("Nhập giờ bắt đầu: ");
        gioBatDau = TienIch.Input_int();
        System.out.println("Nhập giờ kết thúc: ");
        gioKetThuc = TienIch.Input_int();
        if(gioBatDau < 9 || gioKetThuc > 24) System.out.println("Giờ nhập vào ko hợp lệ.");
        else if(gioBatDau > gioKetThuc) System.out.println("Giờ bắt đầu phải nhỏ hơn giờ kết thúc.");
        else{
            double thanhTien = tinhTien(gioBatDau, gioKetThuc);
            System.out.println("Tiền karaoke = " + thanhTien);
        }
    }
}
