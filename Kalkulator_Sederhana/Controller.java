package Kalkulator_Sederhana;

import  javafx.event.*;
import javafx.scene.control.*;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    TextField tfBilanganPertama;
    @FXML
    TextField tfBilanganKedua;
    @FXML
    Button btnTambah;
    @FXML
    Button btnKurang;
    @FXML
    Button btnKali;
    @FXML
    Button btnBagi;
    @FXML
    TextField tfHasil;

    public void onButtonClicked(ActionEvent e){
        BilanganModel bilanganModel = new BilanganModel();

        try{
            bilanganModel.setBilanganPertama(Double.parseDouble(tfBilanganPertama.getText()));
            bilanganModel.setBilanganKedua(Double.parseDouble(tfBilanganKedua.getText()));
        }catch (NumberFormatException e1){
            tfHasil.setText("Masukan hanya boleh angka");
            return;
        }

        if (e.getTarget().equals(btnTambah)){
            bilanganModel.setHasil(bilanganModel.getBilanganPertama()+bilanganModel.getBilanganKedua());
            tfHasil.setText(String.valueOf(bilanganModel.getHasil()));
        }else if (e.getTarget().equals(btnKurang)){
            bilanganModel.setHasil(bilanganModel.getBilanganPertama()-bilanganModel.getBilanganKedua());
            tfHasil.setText(String.valueOf(bilanganModel.getHasil()));
        }else if (e.getTarget().equals(btnKali)){
            bilanganModel.setHasil(bilanganModel.getBilanganPertama()*bilanganModel.getBilanganKedua());
            tfHasil.setText(String.valueOf(bilanganModel.getHasil()));
        }else if(e.getTarget().equals(btnBagi)){
            bilanganModel.setHasil(bilanganModel.getBilanganPertama()/bilanganModel.getBilanganKedua());
            tfHasil.setText(String.valueOf(bilanganModel.getHasil()));
        }

    }


}
