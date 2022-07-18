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
public class TienIch {
    public static int Input_int(){
        Scanner input = new Scanner(System.in);
        int number;
        while(true){
            try{
                number = Integer.parseInt(input.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Lỗi nhập số.");
            }  
        }
        return number;
    }
}
