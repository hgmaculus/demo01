package security;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;

public class HardInfo {

    private ArrayList<String> listPhysAddress;

    public HardInfo() {
        listPhysAddress = new ArrayList<String>();
    }

    public void Load() {
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
                    //System.out.println(String.join(":", hexadecimalFormat));
                    listPhysAddress.add(String.join(":", hexadecimalFormat));
                }
            }
        } catch (SocketException ex) {
            System.getLogger(showMacAddress.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // Check return true when hinfo is available
    public boolean Check(String hinfo) {
        for (String l : listPhysAddress) {
            if (l.equals(hinfo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getListPhysAddress() {
        if (Objects.nonNull(listPhysAddress)) {
            return listPhysAddress;
        } else {
            return new ArrayList<String>();
        }
    }

}
