package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

public class Controller  {
    @FXML
    TextField tfIP1;
    @FXML
    TextField tfIP2;
    @FXML
    TextField tfIP3;
    @FXML
    TextField tfIP4;

    @FXML
    Button btnHitung;

    @FXML
    TextField tfSubnetMask;
    @FXML
    TextField tfAddressRange;
    @FXML
    TextField ipNetwork;
    @FXML
    TextField tfIpBinary;
    @FXML
    TextField tfBinaryNetmask;

    @FXML
    TextField tfSubnet;
//    public ComboBox<String> tfSubnet;
//    ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10",
//            "11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30");






    @FXML
    public void onButtonClicked(ActionEvent e){
        if(e.getTarget().equals(btnHitung)){
            IPModel model = new IPModel();


             int kol1 = Integer.valueOf(tfIP1.getText());
            int kol2 = Integer.valueOf(tfIP2.getText());
            int kol3 = Integer.valueOf(tfIP3.getText());
            int kol4 = Integer.valueOf(tfIP4.getText());

            String IPbinary1 = Integer.toBinaryString(kol1);
            String IPbinary2 = Integer.toBinaryString(kol2);
            String IPbinary3 = Integer.toBinaryString(kol3);
            String IPbinary4 = Integer.toBinaryString(kol4);


            // netmask , binary netmask dan ipNetwork
            int subBin = 255;
            String subBinary = Integer.toBinaryString(subBin);
            model.setSubnetBinary(subBinary);






            if(kol1<=127){
                  model.setNetmask("255.0.0.0");
                  tfSubnetMask.setText(model.getNetmask());
                  tfBinaryNetmask.setText(model.getSubnetBinary());
                model.setIpNetwork(tfIP1.getText()+".0"+".0"+"0");
                ipNetwork.setText(model.getIpNetwork());
            }else if(kol1<=191){
                model.setNetmask("255.255.0.0");
                tfSubnetMask.setText(model.getNetmask());
                tfBinaryNetmask.setText(model.getSubnetBinary()+"."+model.getSubnetBinary());
                model.setIpNetwork(tfIP1.getText()+"."+tfIP2.getText()+".0"+".0");
                ipNetwork.setText(model.getIpNetwork());

            }else if(kol1<=233) {
                model.setNetmask("255.255.255.0");
                tfSubnetMask.setText(model.getNetmask());
                tfBinaryNetmask.setText(model.getSubnetBinary()+"."+model.getSubnetBinary()+"." +model.getSubnetBinary());
                model.setIpNetwork(tfIP1.getText()+"."+tfIP2.getText()+"."+tfIP3.getText()+".0");
                ipNetwork.setText(model.getIpNetwork());
            }





           // IPBinary
            model.setIpBinary(IPbinary1+ "."+IPbinary2+"." + IPbinary3+"." +IPbinary4 );
            tfIpBinary.setText(model.getIpBinary());

        }

    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        tfSubnet.setItems(list);
//    }
}
