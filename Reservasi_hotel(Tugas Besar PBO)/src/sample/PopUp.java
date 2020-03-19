package sample;

import javax.swing.*;

public class PopUp extends JFrame {
    public void popUpTersimpan(){
        JOptionPane.showMessageDialog(this,"Data Telah Tersimpan");
    }

    public void popUpGagal(){
        JOptionPane.showMessageDialog(this, "Gagal Menyimpan Data ");
    }

    public void popUpGagal2(){
        JOptionPane.showMessageDialog(this, "Gagal Merubah Data ");
    }

    public void popUpGagal3(){
        JOptionPane.showMessageDialog(this, "Gagal Menghapus Data ");
    }
    public void popUpGagal4(){
        JOptionPane.showMessageDialog(this, "Data Yang Dicari Tidak ada ");
    }



    public void popUpTerhapus(){
        JOptionPane.showMessageDialog(this,"Data Telah Terhapus");
    }

    public void popUpTerubah(){
        JOptionPane.showMessageDialog(this,"Data Berhasil di ubah");
    }

    public void popUpReset(){
        JOptionPane.showMessageDialog(this,"Menu telah Di Bersihkan");
    }

    public void popUpExit(){
        int jawab=JOptionPane.showOptionDialog(this,"Ingin Keluar" , "Keluar"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);

        if(jawab == JOptionPane.YES_NO_OPTION){
            JOptionPane.showMessageDialog(this,"Program Akan Keluar");
            System.exit(0);
        }
    }

}
