package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.SQLException;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //Nama DMBS yang dipakai
    static final String DB_URL = "jdbc:mysql://localhost/reservasi_hotel";//Alamat Database
    static final String USER = "root";//User Database
    static final String PASS = "";//Password Database

    static Connection conn;//Koneksi ke database
    static Statement stmt;//Pernyataan query
    static ResultSet rs;//hasil query

    @FXML
    Button btn_keluar;
    @FXML
    Button btn_hapus;
    @FXML
    Button btn_ubah;
    @FXML
    Button btn_reset;
    @FXML
    Button btn_simpan;
    @FXML
    Button btn_lihatData;
    @FXML
    TextField txt_nama;
    @FXML
    TextField txt_kelamin;
    @FXML
    TextField txt_email;
    @FXML
    TextField txt_no_kontak;
    @FXML
    TextField txt_check_In;
    @FXML
    TextField txt_check_out;
    @FXML
    ChoiceBox<String> txt_kamar;
    @FXML
    TextField txt_id_co;
    @FXML
    RadioButton txt_kelamin2;
    @FXML
    RadioButton txt_kelamin3;
    @FXML
    TextField txt_bayar;


    private TextField txt_kelas = new TextField();


    private TextField txt_tarif = new TextField();
    @FXML
    private TextField jenis_kamar = new TextField();

    @FXML
    private TextField pancingan = new TextField();

    @FXML
    private TextField pancingan2 = new TextField();

    @FXML
    private TextField pancingan3 = new TextField();


    @FXML
    TableView tabel_customer;




    public void btnAction(ActionEvent e) {
        Model model = new Model();
        PopUp pop = new PopUp();


        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();


        } catch (Exception a) {
            a.printStackTrace();
        }


        if (txt_kelamin2.isSelected()) {
            pancingan.setText(txt_kelamin2.getText());


        } else if (txt_kelamin3.isSelected()) {
            pancingan.setText(txt_kelamin3.getText());
        }


        if (e.getTarget().equals(btn_simpan)) {
            txt_kamar.getItems().clear();


            tabel_customer.getItems().clear();


            try {
                model.setId_co(txt_id_co.getText());
                int id = Integer.parseInt(model.getId_co());
                model.setNama(txt_nama.getText());
                model.setKel(pancingan.getText());
                model.setEmail(txt_email.getText());
                model.setNomer_kontak(txt_no_kontak.getText());
                int kontak = Integer.parseInt(model.getNomer_kontak());
                model.setTgl_ci(txt_check_In.getText());
                model.setTgl_co(txt_check_out.getText());
                model.setHarga(pancingan3.getText());
                model.setId_kamar(jenis_kamar.getText());

                String sql1 = "Insert into customer (id_co,nama,kel,email,nomer_kontak,tgl_ci,tgl_co,status_bayar,id_kamar) " +
                        "values('%s','%s','%s','%s','%s','%s','%s','%s','%s')";
                sql1 = String.format(sql1, id, model.getNama(), model.getKel(), model.getEmail(), kontak, model.getTgl_ci(),
                        model.getTgl_co(), model.getHarga(), model.getId_kamar());
                stmt.execute(sql1);


                String sql2 = "SELECT * from customer INNER join kamar on customer.id_kamar=kamar.id_kamar ";
                rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    int id_co = rs.getInt("id_co");
                    String nama = rs.getString("nama");
                    String kel = rs.getString("kel");
                    String email = rs.getString("email");
                    String nomer_kontak = rs.getString("nomer_kontak");
                    String tgl_ci = rs.getString("tgl_ci");
                    String tgl_co = rs.getString("tgl_co");
                    String status_bayar = rs.getString("status_bayar");
                    String id_kamar = rs.getString("id_kamar");
                    String kelas = rs.getString("kelas");
                    String tarif = rs.getString("tarif");

                    txt_id_co.setText(Integer.toString(id_co));
                    txt_nama.setText(nama);
                    pancingan.setText(kel);
                    txt_email.setText(email);
                    txt_no_kontak.setText(nomer_kontak);
                    txt_check_In.setText(tgl_ci);
                    txt_check_out.setText(tgl_co);
                    pancingan3.setText(status_bayar);
                    jenis_kamar.setText(id_kamar);
                    txt_kelas.setText(kelas);
                    txt_tarif.setText(tarif);


                    ObservableList<Model> m = tabel_customer.getItems();
                    m.add(new Model(
                            txt_id_co.getText(),
                            txt_nama.getText(),
                            pancingan.getText(),
                            txt_email.getText(),
                            txt_no_kontak.getText(),
                            txt_check_In.getText(),
                            txt_check_out.getText(),
                            pancingan3.getText(),
                            jenis_kamar.getText(),
                            txt_kelas.getText(),
                            txt_tarif.getText()


                    ));

                    txt_id_co.setText("");
                    txt_nama.setText("");
                    pancingan.setText("");
                    txt_email.setText("");
                    txt_no_kontak.setText("");
                    txt_check_In.setText("");
                    txt_check_out.setText("");
                    txt_bayar.setText("");
                    jenis_kamar.setText("");
                    txt_kelas.setText("");
                    txt_tarif.setText("");


                }
                pop.popUpTersimpan();


            } catch (java.lang.NumberFormatException a) {
                pop.popUpGagal();


            } catch (Exception a) {
                a.printStackTrace();

            }


        } else if (e.getTarget().equals(btn_reset)) {
            txt_kamar.getItems().clear();
            tabel_customer.getItems().clear();
            txt_id_co.setText("");
            txt_nama.setText("");
            pancingan.setText("");
            txt_email.setText("");
            txt_no_kontak.setText("");
            txt_check_In.setText("");
            txt_check_out.setText("");
            txt_bayar.setText("");
            jenis_kamar.setText("");
            txt_kelas.setText("");
            txt_tarif.setText("");


            pop.popUpReset();

        } else if (e.getTarget().equals(btn_hapus)) {
            txt_kamar.getItems().clear();
            tabel_customer.getItems().clear();
            try {
                model.setId_co(txt_id_co.getText());
                int id = Integer.parseInt(model.getId_co());
                String sql1 = "delete from customer  where id_co=%d";
                sql1 = String.format(sql1, id);
                stmt.execute(sql1);


                String sql2 = "SELECT * from customer INNER join kamar on customer.id_kamar=kamar.id_kamar ";
                rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    int id_co = rs.getInt("id_co");
                    String nama = rs.getString("nama");
                    String kel = rs.getString("kel");
                    String email = rs.getString("email");
                    String nomer_kontak = rs.getString("nomer_kontak");
                    String tgl_ci = rs.getString("tgl_ci");
                    String tgl_co = rs.getString("tgl_co");
                    String status_bayar = rs.getString("status_bayar");
                    String id_kamar = rs.getString("id_kamar");
                    String kelas = rs.getString("kelas");
                    String tarif = rs.getString("tarif");

                    txt_id_co.setText(Integer.toString(id_co));
                    txt_nama.setText(nama);
                    pancingan.setText(kel);
                    txt_email.setText(email);
                    txt_no_kontak.setText(nomer_kontak);
                    txt_check_In.setText(tgl_ci);
                    txt_check_out.setText(tgl_co);
                    pancingan3.setText(status_bayar);
                    jenis_kamar.setText(id_kamar);
                    txt_kelas.setText(kelas);
                    txt_tarif.setText(tarif);


                    ObservableList<Model> m = tabel_customer.getItems();
                    m.add(new Model(
                            txt_id_co.getText(),
                            txt_nama.getText(),
                            pancingan.getText(),
                            txt_email.getText(),
                            txt_no_kontak.getText(),
                            txt_check_In.getText(),
                            txt_check_out.getText(),
                            pancingan3.getText(),
                            jenis_kamar.getText(),
                            txt_kelas.getText(),
                            txt_tarif.getText()


                    ));

                    txt_id_co.setText("");
                    txt_nama.setText("");
                    pancingan.setText("");
                    txt_email.setText("");
                    txt_no_kontak.setText("");
                    txt_check_In.setText("");
                    txt_check_out.setText("");
                    txt_bayar.setText("");
                    jenis_kamar.setText("");
                    txt_kelas.setText("");
                    txt_tarif.setText("");

                }

                pop.popUpTerhapus();


            } catch (java.lang.NumberFormatException a) {
                pop.popUpGagal3();


            } catch (Exception a) {
                a.printStackTrace();

            }


        } else if (e.getTarget().equals(btn_ubah)) {
            txt_kamar.getItems().clear();
            tabel_customer.getItems().clear();
            try {
                model.setId_co(txt_id_co.getText());
                int id = Integer.parseInt(model.getId_co());
                model.setNama(txt_nama.getText());
                model.setKel(txt_kelamin2.getText());
                model.setEmail(txt_email.getText());
                model.setNomer_kontak(txt_no_kontak.getText());
                int kontak = Integer.parseInt(model.getNomer_kontak());
                model.setTgl_ci(txt_check_In.getText());
                model.setTgl_co(txt_check_out.getText());
                model.setHarga(txt_bayar.getText());
                model.setId_kamar(jenis_kamar.getText());
                String sql1 = "update customer set nama = '%s', kel = '%s',email='%s',nomer_kontak = '%d',tgl_ci = '%s',tgl_co = '%s',status_bayar ='%s',id_kamar = '%s'  where id_co=%d";
                sql1 = String.format(sql1, model.getNama(), model.getKel(), model.getEmail(), kontak, model.getTgl_ci(),
                        model.getTgl_co(), model.getHarga(), model.getId_kamar(), id);
                stmt.execute(sql1);


                String sql2 = "SELECT * from customer INNER join kamar on customer.id_kamar=kamar.id_kamar ";
                rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    int id_co = rs.getInt("id_co");
                    String nama = rs.getString("nama");
                    String kel = rs.getString("kel");
                    String email = rs.getString("email");
                    String nomer_kontak = rs.getString("nomer_kontak");
                    String tgl_ci = rs.getString("tgl_ci");
                    String tgl_co = rs.getString("tgl_co");
                    String status_bayar = rs.getString("status_bayar");
                    String id_kamar = rs.getString("id_kamar");
                    String kelas = rs.getString("kelas");
                    String tarif = rs.getString("tarif");

                    txt_id_co.setText(Integer.toString(id_co));
                    txt_nama.setText(nama);
                    pancingan.setText(kel);
                    txt_email.setText(email);
                    txt_no_kontak.setText(nomer_kontak);
                    txt_check_In.setText(tgl_ci);
                    txt_check_out.setText(tgl_co);
                    pancingan3.setText(status_bayar);
                    jenis_kamar.setText(id_kamar);
                    txt_kelas.setText(kelas);
                    txt_tarif.setText(tarif);


                    ObservableList<Model> m = tabel_customer.getItems();
                    m.add(new Model(
                            txt_id_co.getText(),
                            txt_nama.getText(),
                            pancingan.getText(),
                            txt_email.getText(),
                            txt_no_kontak.getText(),
                            txt_check_In.getText(),
                            txt_check_out.getText(),
                            pancingan3.getText(),
                            jenis_kamar.getText(),
                            txt_kelas.getText(),
                            txt_tarif.getText()


                    ));

                    txt_id_co.setText("");
                    txt_nama.setText("");
                    pancingan.setText("");
                    txt_email.setText("");
                    txt_no_kontak.setText("");
                    txt_check_In.setText("");
                    txt_check_out.setText("");
                    pancingan3.setText("");
                    jenis_kamar.setText("");
                    txt_kelas.setText("");
                    txt_tarif.setText("");

                }

                pop.popUpTerubah();


            } catch (java.lang.NumberFormatException a) {
                pop.popUpGagal2();


            } catch (Exception a) {
                a.printStackTrace();

            }

        } else if (e.getTarget().equals(btn_keluar)) {
            txt_kamar.getItems().clear();
            pop.popUpExit();

        } else if (e.getTarget().equals(btn_lihatData)) {
            txt_kamar.getItems().clear();


            tabel_customer.getItems().clear();

            try {
                String sql = "SELECT * from customer INNER join kamar on customer.id_kamar=kamar.id_kamar ";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id_co = rs.getInt("id_co");
                    String nama = rs.getString("nama");
                    String kel = rs.getString("kel");
                    String email = rs.getString("email");
                    String nomer_kontak = rs.getString("nomer_kontak");
                    String tgl_ci = rs.getString("tgl_ci");
                    String tgl_co = rs.getString("tgl_co");
                    String status_bayar = rs.getString("status_bayar");
                    String id_kamar = rs.getString("id_kamar");
                    String kelas = rs.getString("kelas");
                    String tarif = rs.getString("tarif");

                    txt_id_co.setText(Integer.toString(id_co));
                    txt_nama.setText(nama);
                    pancingan.setText(kel);
                    txt_email.setText(email);
                    txt_no_kontak.setText(nomer_kontak);
                    txt_check_In.setText(tgl_ci);
                    txt_check_out.setText(tgl_co);
                    pancingan3.setText(status_bayar);
                    jenis_kamar.setText(id_kamar);
                    txt_kelas.setText(kelas);
                    txt_tarif.setText(tarif);


                    ObservableList<Model> m = tabel_customer.getItems();
                    m.add(new Model(
                            txt_id_co.getText(),
                            txt_nama.getText(),
                            pancingan.getText(),
                            txt_email.getText(),
                            txt_no_kontak.getText(),
                            txt_check_In.getText(),
                            txt_check_out.getText(),
                            pancingan3.getText(),
                            jenis_kamar.getText(),
                            txt_kelas.getText(),
                            txt_tarif.getText()


                    ));

                    txt_id_co.setText("");
                    txt_nama.setText("");
                    pancingan.setText("");
                    txt_email.setText("");
                    txt_no_kontak.setText("");
                    txt_check_In.setText("");
                    txt_check_out.setText("");
                    pancingan3.setText("");
                    jenis_kamar.setText("");
                    txt_kelas.setText("");
                    txt_tarif.setText("");


                }



            } catch (Exception a) {
                a.printStackTrace();

            }


        }

        txt_kamar.getItems().addAll("Standart", "Suite", "Deluxe");
        pancingan2.setText(txt_kamar.getValue());
        if (pancingan2.getText().equals("Standart")) {
            jenis_kamar.setText("km_01");
            if (txt_bayar.getText().equals("1000000")) {
                pancingan3.setText("terbayar");
            } else {
                pancingan3.setText("belum terbayar");
            }
        } else if (pancingan2.getText().equals("Suite")) {
            jenis_kamar.setText("km_02");
            if (txt_bayar.getText().equals("5000000")) {
                pancingan3.setText("terbayar");
            } else {
                pancingan3.setText("belum terbayar");
            }
        } else if (pancingan2.getText().equals("Deluxe")) {
            jenis_kamar.setText("km_03");
            if (txt_bayar.getText().equals("3000000")) {
                pancingan3.setText("terbayar");
            } else {
                pancingan3.setText("belum terbayar");
            }
        }


    }
}
