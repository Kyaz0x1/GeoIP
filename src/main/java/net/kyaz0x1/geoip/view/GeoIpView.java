package net.kyaz0x1.geoip.view;

import net.kyaz0x1.geoip.events.ButtonVerifyClickEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GeoIpView extends JFrame {

    private final JLabel lblTitle;
    private final JTextField txtAddress;
    private final JButton btnVerify;

    public GeoIpView(){
        super("GeoIP v1.0.0");
        setSize(275, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        this.lblTitle = new JLabel("GeoIP");
        lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        lblTitle.setBounds(90, 20, 80, 25);

        add(lblTitle);

        this.txtAddress = new JTextField();
        txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
        txtAddress.setBounds(40, 50, 180, 20);

        add(txtAddress);

        this.btnVerify = new JButton("Verificar");
        btnVerify.setBounds(80, 75, 90, 20);
        btnVerify.addActionListener(new ButtonVerifyClickEvent(txtAddress));

        add(btnVerify);
    }

}