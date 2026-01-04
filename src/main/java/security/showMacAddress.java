package security;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class showMacAddress {

    public static void main(String[] args) {

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                byte[] hardwareAddress = ni.getHardwareAddress();
                if (hardwareAddress != null) {
                    String[] hexadecimalFormat = new String[hardwareAddress.length];
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
                    }
                    System.out.println(String.join(":", hexadecimalFormat));
                }
            }
        } catch (SocketException ex) {
            System.getLogger(showMacAddress.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
}
