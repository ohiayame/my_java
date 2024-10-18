package ProgramingClass;

public class Ip {
    public static void main(String[] args) {
        int addr1 = 210;
        int addr2 = 101;
        int addr3 = 236;
        int addr4 = 198;

        int mask1 = 255;
        int mask2 = 255;
        int mask3 = 255;
        int mask4 = 0;

        int subAddr1 = addr1 & mask1;
        int subAddr2 = addr2 & mask2;
        int subAddr3 = addr3 & mask3;
        int subAddr4 = addr4 & mask4;

        System.out.println(subAddr1 + "." + subAddr2 + "." + subAddr3 + "." + subAddr4);

        // 210.101.236.164  (10진수
        // D2.65.EC.A4   (16진수
        int myIpAddr = 0xD265ECA4;  // -> -765072220

        int bar = 1;
        System.out.println(bar << 1);  // 2
        System.out.println(bar << 2);  // 4
        System.out.println(bar << 3);  // 8
        System.out.println(bar << 4);  // 16

        int foo = 16;
        System.out.println(foo >> 1);  // 8
        System.out.println(foo >> 2);  // 4
        System.out.println(foo >> 3);  //2
        System.out.println(foo >> 4);  // 1

        int ipAddr1 = (myIpAddr >> 24) & 0xFF;
        int ipAddr2 = (myIpAddr >> 16) & 0xFF;
        int ipAddr3 = (myIpAddr >> 8) & 0xFF;
        int ipAddr4 = myIpAddr & 0xFF;
        System.out.println(ipAddr1 + "." + ipAddr2 + "." + ipAddr3 + "." + ipAddr4);

        long flags = 0;
        long bitValue = 1L << 63;

        flags = flags | bitValue;
        String binaryString = Long.toBinaryString(flags);
        System.out.println(binaryString);


        bitValue = 1L << 2;
        flags = flags | bitValue;
        String binaryString2 = Long.toBinaryString(flags);
        System.out.println(binaryString2);


        long mask = 1L << 2;

        long result = flags & mask;
        System.out.println(result >> 2);

    }
}
