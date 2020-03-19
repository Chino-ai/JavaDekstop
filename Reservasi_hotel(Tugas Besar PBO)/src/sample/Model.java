package sample;


public class Model  {
private String id_co;
   private String nama;
    private String kel;
    private String email;
    private String nomer_kontak;

    private String tgl_ci,tgl_co;
    private int waktu;
    private  String id_kamar;
    private String kelas;
    private String tarif;
    private String harga;

    public String getId_co() {
        return id_co;
    }

    public void setId_co(String id_co) {
        this.id_co = id_co;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKel() {
        return kel;
    }

    public void setKel(String kel) {
        this.kel = kel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomer_kontak() {
        return nomer_kontak;
    }



    public void setNomer_kontak(String nomer_kontak) {
        this.nomer_kontak = nomer_kontak;
    }

    public String getTgl_ci() {
        return tgl_ci;
    }

    public void setTgl_ci(String tgl_ci) {
        this.tgl_ci = tgl_ci;
    }

    public String getTgl_co() {
        return tgl_co;
    }

    public void setTgl_co(String tgl_co) {
        this.tgl_co = tgl_co;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public String getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(String id_kamar) {
        this.id_kamar = id_kamar;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getTarif() {
        return tarif;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Model(String id_co , String nama , String kel, String email, String nomer_kontak, String tgl_ci, String tgl_co
            , String harga, String id_kamar , String kelas, String tarif ){
       this.id_co=id_co;
        this.nama = nama;
        this.kel = kel;
        this.email = email;
        this.nomer_kontak = nomer_kontak;
        this.tgl_ci = tgl_ci;
        this.tgl_co = tgl_co;
        this.harga = harga;
        this.id_kamar = id_kamar;
        this.kelas=kelas;
        this.tarif=tarif;

    }



    public Model(){

    }




}


