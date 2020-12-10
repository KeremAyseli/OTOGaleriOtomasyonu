package Sınıflar;
import com.company.Main;

import java.sql.*;
import java.util.ArrayList;

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

    /**
     * Bu metot Araba Tablosuna araba eklemeye yarar.
      * @param araba_id
     * @param Marka
     * @param Seri
     * @param Model
     * @param Yıl
     * @param Yakıt
     * @param Vites
     * @param KM
     * @param Kasa
     * @param Motor_Gucu
     * @param Motor_Hacmi
     * @param Çekiş
     * @param Renk
     * @param Garanti
     * @param Plaka
     */
    public int VeriEklemeAraba(int araba_id, String Marka,String Seri,String Model,String Yıl,String Yakıt,String Vites,int KM,String Kasa,
                             String Motor_Gucu,String Motor_Hacmi,String Çekiş,String Renk,String Garanti,String Plaka){
        String sorgu ="Insert into Araba(id,Marka,Seri,Model,Yıl,Yakıt,Vites,KM,Kasa,Motor_Gucu,Motor_Hacmi,Çekiş,Renk,Garanti,Plaka)" +
                "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
            islemler.setInt(1,araba_id);
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
            return 0;
        }catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
            return 1;
        }
    }

    /**
     * Bu Metot Araba tablosundan verilen id'ye göre arama yapar ve olan verileri <b>Arabalar tipinde</b> geri döndürür.
     * @param id
     * @return
     */

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

    /**
     * Bu metot değer almaz,Arabalar tablosunda bulunan tüm verileri <b>ArrayList < Arabalar > tipinde</b> getirmeye yarar.
     * @return
     */
    public ArrayList<Arabalar> VerileriGetirAraba(){
        String sorgu ="SELECT * from Araba";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            ArrayList<Arabalar>ArabalarListesi=new ArrayList<Arabalar>();
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
                ArabalarListesi.add(araba);
            }
            return ArabalarListesi;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }

    /**
     * Bu metot Musteriler tablosunda verilen id'ye göre arama yapar ve gelen sonucu <b>Müsteriler tipinde</b> geri döndürür.
     * @param id
     * @return
     */
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

    /**
     * Bu metot Müsteriler Tablosundaki tüm verileri <b>ArrayList< Müsteriler ></b> tipinde geri getirir.
     * @return
     */
    public ArrayList<Musteriler> VerileriGetirMusteri(){
        String sorgu ="SELECT * from Müsteriler ";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            ArrayList<Musteriler>MusterilerListesi=new ArrayList<Musteriler>();
            while (GelenVeriler.next()){
                Musteriler musteri = new Musteriler();
                musteri.setId(GelenVeriler.getString("id"));
                musteri.setMusteri_ad(GelenVeriler.getString("müsteri_ad"));
                musteri.setMusteri_soyad(GelenVeriler.getString("müsteri_soyad"));
                musteri.setMuster_telNo(GelenVeriler.getString("müsteri_telNo"));
                MusterilerListesi.add(musteri);
            }
            return MusterilerListesi;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }


    public int VeriEkleMusteri(int id,String ad,String soyad,String TelNo,int araba_id ){
        String sorgu="insert into Müsteriler(id,müsteri_ad,müsteri_soyad,müsteri_telNo,araba_id)VALUES (?,?,?,?,?)";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
                islemler.setInt(1,id);
                islemler.setString(2,ad);
                islemler.setString(3,soyad);
                islemler.setString(4,TelNo);
                islemler.setInt(5,araba_id);
                islemler.executeUpdate();
                return 0;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
            return 1;
        }

    }

    /**
     * Bu metot Hesap_tipi tablosuna Veri eklemeye yarar.
     * @param id
     * @param personel_tip
     * @param admin_id
     * @param admin_tip
     */
     public int VeriEkleHesapTipi(String id, String personel_tip, String admin_id, String admin_tip){
        String sorgu ="insert into Hesap_tipi (id,personel_tip,admin_id,admin_tip) values (?,?,?,?);";
         try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
              islemler.setString(1,id);
              islemler.setString(2,personel_tip);
              islemler.setString(3,admin_id);
              islemler.setString(4,admin_tip);
              islemler.executeUpdate();
              return 0;
         }catch (Exception e){
             System.out.println("İşlem Yapılamadı"+e.getMessage());
             return 1;
         }
     }

    /**
     * Bu metot Verilen id'ye göre veri tabanında arama yapar ve gelen değeri <b>Hesap_tipi</b> şeklinde geri döndürür.
     * @param id
     * @return
     */
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

    /**
     * Bu metot değer almaz ve Hesap_tipi tablosunda bulunan tüm verileri <b>ArrayList< Hesap_tipi > şeklinde</b> geri döndürür.
     * @return
     */
    public ArrayList<HesapTipi> VeriGetirHesapTipi(){
        String sorgu ="SELECT * from Hesap_tipi ";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
           ArrayList<HesapTipi>HesaplarListesi=new ArrayList<HesapTipi>();
            while (GelenVeriler.next()){
                HesapTipi hesaplar=new HesapTipi();
                hesaplar.setId(GelenVeriler.getString("id"));
                hesaplar.setPersonel_tip(GelenVeriler.getString("personel_tip"));
                hesaplar.setAdmin_id(GelenVeriler.getString("admin_id"));
                hesaplar.setAdmin_tip(GelenVeriler.getString("admin_tip"));
                HesaplarListesi.add(hesaplar);
            }
            return HesaplarListesi;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }

    /**
     * Bu metot verilen <b>Tablo ismi,güncellenicek sütunun ismi,satır id'si ve yeni değer</b> parametrelerini alarak çalışır.
     * @param TabloIsmı
     * @param GuncellenicekSütunIsmi
     * @param Id
     * @param YeniDeger
     */
    public void Guncelle(String TabloIsmı,String GuncellenicekSütunIsmi,int Id,String YeniDeger){
        String sorgu ="update "+TabloIsmı+" set "+GuncellenicekSütunIsmi+"=? where id="+Id;
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
                  islemler.setString(1,YeniDeger);
                  islemler.executeUpdate();
                  System.out.println("Güncelleme işlemi başarılı");
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
        }
    }

    /**
     * Bu metot verilen <b>tablo ismine ve satır id'sine</b> göre silme işlemi yapar
     * @param TabloIsmı
     * @param Id
     */
    public void Sil(String TabloIsmı,int Id){
        String sorgu ="DELETE FROM "+TabloIsmı+" Where id=?";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
            islemler.setInt(1,Id);
            islemler.executeUpdate();
            System.out.println("Silme işlemi başarılı");
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
        }
    }
}
