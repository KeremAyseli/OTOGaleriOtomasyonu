package Sınıflar;
/*CREATE TABLE "Hesap_tipi" (
	"id"	nvarchar(11),
	"personel_tip"	nvarchar(1),
	"admin_id"	nvarchar(11),
	"admin_tip"	nvarchar(1),
	PRIMARY KEY("id")
)*/
public class HesapTipi extends VeriTabaniIslemleri {
   public String id,personel_tip,admin_id,admin_tip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonel_tip() {
        return personel_tip;
    }

    public void setPersonel_tip(String personel_tip) {
        this.personel_tip = personel_tip;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_tip() {
        return admin_tip;
    }

    public void setAdmin_tip(String admin_tip) {
        this.admin_tip = admin_tip;
    }
}
