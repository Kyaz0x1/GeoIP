package net.kyaz0x1.geoip.events;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.kyaz0x1.geoip.models.Address;
import net.kyaz0x1.geoip.service.WebService;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonVerifyClickEvent implements ActionListener {

    private JTextField txtAddress;
    private Gson gson;

    public ButtonVerifyClickEvent(JTextField txtAddress){
        this.txtAddress = txtAddress;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String address = txtAddress.getText();
        if(address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe um endereço ip!", "GeoIP", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!isAddress(address)){
            JOptionPane.showMessageDialog(null, "O endereço informado é inválido!", "GeoIP", JOptionPane.ERROR_MESSAGE);
            return;
        }

        final String content = WebService.getInstance().read("http://ip-api.com/json/" + address);
        final Address addressObj = gson.fromJson(content, Address.class);
        JOptionPane.showMessageDialog(null, gson.toJson(addressObj));
    }

    private boolean isAddress(String value){
        return value.matches("\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
    }

}