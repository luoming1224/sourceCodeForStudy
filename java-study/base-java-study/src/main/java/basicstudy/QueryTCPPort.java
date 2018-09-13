package basicstudy;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class QueryTCPPort {
    public static void main(String[] args) {
        System.out.println(getIpAddresses());
    }

    protected static List<NetworkInterface> getNetworkInterface() {

        List<NetworkInterface> list = new ArrayList<NetworkInterface>();

        try {
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface iface = e.nextElement();

                if (!iface.isVirtual() && !iface.isLoopback() && iface.isUp()) {
                    list.add(iface);

                }

            }

            return list;
        } catch (Exception e1) {
            e1.printStackTrace();
            return list; //empty
        }
    }

    protected static Enumeration<InetAddress> getInetAddresses() {
        List<NetworkInterface> nc = QueryTCPPort.getNetworkInterface();
        if (nc.size() == 0) {
            return null;
        }

        for (NetworkInterface networkInterface : nc) {
            if (networkInterface.getName().toLowerCase().startsWith("bond")) {
                return networkInterface.getInetAddresses();
            } else if (networkInterface.getName().toLowerCase().startsWith("eth")) {
                return networkInterface.getInetAddresses();
            } else if (networkInterface.getName().toLowerCase().startsWith("em")) {
                return networkInterface.getInetAddresses();
            }
        }

        return nc.get(0).getInetAddresses();

    }

    /*public static String getIpAddresses() {
        String ip = "127.0.0.1";

        Enumeration<InetAddress> inetAddress = QueryTCPPort.getInetAddresses();

        if (inetAddress != null) {
            while (inetAddress.hasMoreElements()) {
                InetAddress inetAddress1 = inetAddress.nextElement();

                if (InetAddressUtils.isIPv4Address(inetAddress1.getHostAddress())) {
                    ip = inetAddress1.getHostAddress();
                }

            }
        }

        return ip;
    }*/


        public static String getIpAddresses() {
            String ip = "127.0.0.1";

            List<NetworkInterface> nc = getNetworkInterface();
            if (nc.size() == 0) {
                return null;
            }
            System.out.println(nc);

            for (NetworkInterface networkInterface : nc) {

                Enumeration<InetAddress> inetAddress = networkInterface.getInetAddresses();
                if (inetAddress != null) {
                    while (inetAddress.hasMoreElements()) {
                        InetAddress inetAddress1 = inetAddress.nextElement();

                        if (InetAddressUtils.isIPv4Address(inetAddress1.getHostAddress())) {
                            ip = inetAddress1.getHostAddress();
                            break;
                        }

                    }
                }

                if (!ip.equals("127.0.0.1"))
                    break;

            }

            return ip;
        }
}
