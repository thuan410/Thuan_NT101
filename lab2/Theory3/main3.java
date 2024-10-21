package Theory3;

import java.math.BigInteger;
import java.util.Scanner;

public class main3 {
    public static void main() {
        Scanner scan = new Scanner(System.in);

        // Input số a
        System.out.print("Nhap co so (a): ");
        BigInteger a = new BigInteger(scan.nextLine());

        // Input số mũ x
        System.out.print("Nhap so mu (x): ");
        BigInteger x = new BigInteger(scan.nextLine());

        // Input mô đum p
        System.out.print("Nhap mo đun (p): ");
        BigInteger p = new BigInteger(scan.nextLine());

        // Tính a^x mod p
        BigInteger result = a.modPow(x, p);

        // Kết quả
        System.out.println(a + "^" + x + " mod " + p + " = " + result);

        scan.close();
    }
}
