/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_4.CSDL;

import Bai_4.Models.DiaCD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan
 */
public class QuanLyCD {
    
    // Hàm thêm đĩa CD
    public static int ThemDiaCD(DiaCD diaCD){
        Connection cnn = Bai_4.CSDL.Database.KetnoiCSDL();
        if(cnn == null){
            return -1;
        }
        String sql = "INSERT INTO diacd(TenCd, CaSy, SoBaiHat, Gia) VALUE(?, ?, ?, ?)";
        
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1, diaCD.getTenCD());
            stm.setString(2, diaCD.getCaSy());
            stm.setInt(3, diaCD.getSoBaiHat());
            stm.setDouble(4, diaCD.getGia());
            
            int n = stm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCD.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
    
    // Hàm Tìm đĩa CD
    public static int TimDiaCD(String tukhoa, Vector<DiaCD> danhsach){
        Connection cnn = Bai_4.CSDL.Database.KetnoiCSDL();
        if(cnn == null){
            return -1;
        }
        String sql = "SELECT * FROM diacd";
        if(!tukhoa.equals("")){
            sql += " WHERE TenCD LIKE '%" +tukhoa+ "%'";
        }
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                String tencd = rs.getString("TenCD");
                String casy = rs.getString("CaSy");
                int sobaihat = rs.getInt("SoBaiHat");
                double gia = rs.getDouble("Gia");
                DiaCD diaCD = new DiaCD(tencd, casy, sobaihat, gia);
                danhsach.add(diaCD);
            }
            return danhsach.size();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCD.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
    
    // Hàm Xóa đĩa CD
    public static int XoaDiaCD(String tenCD){
        Connection cnn = Bai_4.CSDL.Database.KetnoiCSDL();
        if(cnn == null) return -1;
        String sql = "DELETE FROM diacd WHERE TenCD = ?";
        
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1, tenCD);
            int n = stm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCD.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
    
    // Hàm Sửa đĩa CD
    public static int SuaDiaCD(String tenCD, DiaCD diaCD){
        Connection cnn = Bai_4.CSDL.Database.KetnoiCSDL();
        if(cnn == null) return -1;
        String sql = "UPDATE diacd SET TenCD = ?, CaSy = ?, SoBaiHat = ?, Gia = ? WHERE TenCD = ?";
        
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1, diaCD.getTenCD());
            stm.setString(2, diaCD.getCaSy());
            stm.setInt(3, diaCD.getSoBaiHat());
            stm.setDouble(4, diaCD.getGia());
            stm.setString(5, tenCD);
            
            int n = stm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCD.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
}
