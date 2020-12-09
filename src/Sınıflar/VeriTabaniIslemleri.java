package Sınıflar;
import com.company.Main;

import java.sql.*;

public class VeriTabaniIslemleri {

    public Connection Baglan(){
        Connection baglantı=null;
        try{
            baglantı=DriverManager.getConnection("jdbc:sqlite:\\OtoGaleriOtomasyonu\\src\\VeriTabani\\OtoGaleriOtomasyonu.db");
            System.out.println("Bağlantı Başarılı");

        }catch (Exception e){
            System.out.println("Bağlantı Başarısız");
        }
        return baglantı;
    }
    public void VeriEklemeAraba(String araba_id, String Marka,String Seri,String Model,String Yıl,String Yakıt,String Vites,int KM,String Kasa,
                             String Motor_Gucu,String Motor_Hacmi,String Çekiş,String Renk,String Garanti,String Plaka){
        String sorgu ="Insert into Araba(araba_id,Marka,Seri,Model,Yıl,Yakıt,Vites,KM,Kasa,Motor_Gucu,Motor_Hacmi,Çekiş,Renk,Garanti,Plaka)" +
                "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
            islemler.setString(1,araba_id);
            islemler.setString(2,Marka);
            islemler.setString(3,Seri);
            islemler.setString(4,Model);
            islemler.setString(5,Yıl);
            islemler.setString(6,Yakıt);
            islemler.setString(7,Vites);
            islemler.setInt(8,KM);
            islemler.setString(9,Kasa);
            islemler.setString(10,Motor_Gucu);
            islemler.setString(11,Motor_Hacmi);
            islemler.setString(12,Çekiş);
            islemler.setString(13,Renk);
            islemler.setString(14,Garanti);
            islemler.setString(15,Plaka);
            islemler.executeUpdate();
        }catch (Exception e){
            System.out.println("İşlem Yapılamadı");
        }
    }
    /*public String araba_id,  Marka, Seri,Model,Yıl, Yakıt, Vites, Kasa;
    public String Motor_Gucu, Motor_Hacmi,Çekiş, Renk, Garanti, Plaka;*/
    public Arabalar VerileriGetirAraba(int id){
        String sorgu ="SELECT * from Araba where Id="+id;
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            while (GelenVeriler.next()){
                Arabalar araba =new Arabalar();
                araba.setAraba_id(GelenVeriler.getString("id"));
                araba.setMarka(GelenVeriler.getString("Marka"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setSeri(GelenVeriler.getString("Seri"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setYıl(GelenVeriler.getString("Yıl"));
                araba.setYakıt(GelenVeriler.getString("Yakıt"));
                araba.setVites(GelenVeriler.getString("Vites"));
                araba.setKM(GelenVeriler.getInt("KM"));
                araba.setKasa(GelenVeriler.getString("Kasa"));
                araba.setMotor_Gucu(GelenVeriler.getString("Motor_Gucu"));
                araba.setMotor_Hacmi(GelenVeriler.getString("Motor_Hacmi"));
                araba.setÇekiş(GelenVeriler.getString("Çekiş"));
                araba.setRenk(GelenVeriler.getString("Renk"));
                araba.setGaranti(GelenVeriler.getString("Garanti"));
                araba.setPlaka(GelenVeriler.getString("Plaka"));
                return araba;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }
    public Arabalar VerileriGetirAraba(){
        String sorgu ="SELECT * from Araba";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            while (GelenVeriler.next()){
                Arabalar araba =new Arabalar();
                araba.setAraba_id(GelenVeriler.getString("id"));
                araba.setMarka(GelenVeriler.getString("Marka"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setSeri(GelenVeriler.getString("Seri"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setYıl(GelenVeriler.getString("Yıl"));
                araba.setYakıt(GelenVeriler.getString("Yakıt"));
                araba.setVites(GelenVeriler.getString("Vites"));
                araba.setKM(GelenVeriler.getInt("KM"));
                araba.setKasa(GelenVeriler.getString("Kasa"));
                araba.setMotor_Gucu(GelenVeriler.getString("Motor_Gucu"));
                araba.setMotor_Hacmi(GelenVeriler.getString("Motor_Hacmi"));
                araba.setÇekiş(GelenVeriler.getString("Çekiş"));
                araba.setRenk(GelenVeriler.getString("Renk"));
                araba.setGaranti(GelenVeriler.getString("Garanti"));
                araba.setPlaka(GelenVeriler.getString("Plaka"));
                return araba;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }
    public Musteriler VerileriGetirMusteri(int id){
        String sorgu ="SELECT * from Müsteriler where Id="+id;
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            while (GelenVeriler.next()){
                Musteriler musteri = new Musteriler();
                musteri.setId(GelenVeriler.getString("id"));
                musteri.setMusteri_ad(GelenVeriler.getString("müsteri_ad"));
                musteri.setMusteri_soyad(GelenVeriler.getString("müsteri_soyad"));
                musteri.setMuster_telNo(GelenVeriler.getString("müsteri_telNo"));
                return musteri;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }
    public Musteriler VerileriGetirMusteri(){
        String sorgu ="SELECT * from Müsteriler ";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            while (GelenVeriler.next()){
                Musteriler musteri = new Musteriler();
                musteri.setId(GelenVeriler.getString("id"));
                musteri.setMusteri_ad(GelenVeriler.getString("müsteri_ad"));
                musteri.setMusteri_soyad(GelenVeriler.getString("müsteri_soyad"));
                musteri.setMuster_telNo(GelenVeriler.getString("müsteri_telNo"));
                return musteri;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }
    public void VeriEkleMusteri(String id,String ad,String soyad,String TelNo){
        String sorgu="insert into Musteriler(id,müsteri_ad,müsteri_soyad,müsteri_telNo)VALUES (?,?,?,?)";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
                islemler.setString(1,id);
                islemler.setString(2,ad);
                islemler.setString(3,soyad);
                islemler.setString(4,TelNo);
                islemler.executeUpdate();
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı");
        }

    }
     public void VeriEkleHesapTipi(String id, String personel_tip, String admin_id, String admin_tip){
        String sorgu ="insert into Hesap_tipi (id,personel_tip,admin_id,admin_tip) values (?,?,?,?);";
         try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
              islemler.setString(1,id);
              islemler.setString(2,personel_tip);
              islemler.setString(3,admin_id);
              islemler.setString(4,admin_tip);
              islemler.executeUpdate();
         }catch (Exception e){
             System.out.println("İşlem Yapılamadı");
         }
     }
     public HesapTipi VeriGetirHesapTipi(int id){
         String sorgu ="SELECT * from Hesap_tipi where id="+id;
         try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
             while (GelenVeriler.next()){
                 HesapTipi hesaplar=new HesapTipi();
                 hesaplar.setId(GelenVeriler.getString("id"));
                 hesaplar.setPersonel_tip(GelenVeriler.getString("personel_tip"));
                 hesaplar.setAdmin_id(GelenVeriler.getString("admin_id"));
                 hesaplar.setAdmin_tip(GelenVeriler.getString("admin_tip"));
                 return hesaplar;
             }
         }
         catch (Exception e){
             System.out.println("İşlem Yapılamadı"+ e.getMessage());
         }
         return null;
     }
    public HesapTipi VeriGetirHesapTipi(){
        String sorgu ="SELECT * from Hesap_tipi ";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            while (GelenVeriler.next()){
                HesapTipi hesaplar=new HesapTipi();
                hesaplar.setId(GelenVeriler.getString("id"));
                hesaplar.setPersonel_tip(GelenVeriler.getString("personel_tip"));
                hesaplar.setAdmin_id(GelenVeriler.getString("admin_id"));
                hesaplar.setAdmin_tip(GelenVeriler.getString("admin_tip"));
                return hesaplar;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }
}
