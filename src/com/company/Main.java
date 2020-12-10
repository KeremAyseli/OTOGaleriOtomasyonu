package com.company;

import Sınıflar.Arabalar;
import Sınıflar.HesapTipi;
import Sınıflar.VeriTabaniIslemleri;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        VeriTabaniIslemleri veritabanı=new VeriTabaniIslemleri();
        veritabanı.Baglan();
        Arabalar araba = new Arabalar();

      veritabanı.Sil("Müsteriler",2);
        if( veritabanı.VeriEkleMusteri(2,"kerem","ayseli","1235489",0)==0){
            System.out.println("Müşteri başarıyla eklendi.");
        }
        else {
            System.out.println("Aynı müşteriden bulunmakta.");
        }


    }
}
