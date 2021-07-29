package net.kyaz0x1.geoip;

import net.kyaz0x1.geoip.view.GeoIpView;

import javax.swing.SwingUtilities;

public class GeoIP {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GeoIpView().setVisible(true));
    }

}